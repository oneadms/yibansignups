package com.yiban.test.model;

import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;


import com.google.gson.Gson;
import com.yiban.test.AppClient;
import com.yiban.test.model.bean.LoginResult;
import com.yiban.test.model.bean.TaskDetails;
import com.yiban.test.model.bean.TaskResult;
import com.yiban.test.model.bean.UncompletedTask;
import com.yiban.test.utils.EncryptUtils;
import com.yiban.test.utils.ok.NetWork;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class YiBanHelper {
    private final Gson gson = new Gson();
    private String verifyRequest;
    private final String CSRF = "a65b126f94428aff012b8834ee30dca1";





    private static long getTimeSmap() {
        return System.currentTimeMillis() * 100 + System.currentTimeMillis() % 10 + System.currentTimeMillis() / 10 % 10;
    }

    public interface DataResult<T> {

        void onFailure(@NotNull Call call, @NotNull String e);

        void onResponse(T t) throws IOException;
    }

    /**
     * 二次认证
     */
    private void auth(String accessToken) {
        NetWork.get("http://f.yiban.cn/iapp/index?act=iapp7463&v=" + accessToken, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException,RuntimeException {
                if (response.code() == 302) {
                    String location = response.header("Location");
//                    System.out.println(location);
                    Pattern p = Pattern.compile("verify_request=(.*?)&");
                    Matcher matcher = p.matcher(location);
                    if (matcher.find()) {
                        String group = matcher.group();
                        verifyRequest = group.substring(15);
//                        System.out.println(verifyRequest);
                    }

                    NetWork.get("https://api.uyiban.com/base/c/auth/yiban?verifyRequest=" + verifyRequest + "&CSRF=" + CSRF, new Callback() {
                        @Override
                        public void onFailure(@NotNull Call call, @NotNull IOException e) {
                            e.printStackTrace();
                            throw new RuntimeException("二次认证失败");

                        }

                        @Override
                        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException,RuntimeException {

//                            System.out.println(response.headers());
//                            System.out.println(response.body().string());
                            getUncompletedList();
                        }
                    });
                }
            }
        });
    }

    private String getStartTime(Date date) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd 00:00");
//        Log.i("time", "getStartTime: "+ft.format(date));
        return ft.format(date);

    }

    private String getEndTimeStr(Date date) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd 23:59");
//        Log.i("time", "getEndTime: "+ft.format(date));
        return ft.format(date);

    }


    /**
     * 获取没完成的任务
     */
    private void getUncompletedList() throws UnsupportedEncodingException,RuntimeException {
        String s = "https://api.uyiban.com/officeTask/client/index/uncompletedList?StartTime=" +
                URLEncoder.encode(getStartTime(new Date(System.currentTimeMillis() - 86400000 * 3)), "UTF-8")
                + "&EndTime=" + URLEncoder.encode(getEndTimeStr(new Date()), "UTF-8")
                + "&CSRF=" + CSRF;
        NetWork.get(s, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException,RuntimeException {
//                if (response.code() != 200) {
//                    return;
//                }
//                System.out.println(response.body().string());
                UncompletedTask uncompletedTask = gson.fromJson(response.body().string(), UncompletedTask.class);

                List<UncompletedTask.DataDTO> data = uncompletedTask.getData();
                if (data == null) {
                    return;
                }
                for (UncompletedTask.DataDTO datum : data) {
//                    System.out.println(datum.getTitle());
//                    System.out.println(datum.getTimeoutState());
                    getUncompletedDetails(datum.getTaskId(), new DataResult<TaskDetails.DataDTO>() {
                        @Override
                        public void onFailure(@NotNull Call call, @NotNull String e) {

                        }

                        @Override
                        public void onResponse(TaskDetails.DataDTO dataDTO) throws IOException {
//                            System.out.println(gson.toJson(dataDTO));
                            if (dataDTO != null) {
                                submitTask(dataDTO.getWFId(), dataDTO);
                            }

                        }
                    });
                }
            }
        });
    }


    private void submitTask(String Wfid, TaskDetails.DataDTO dataDTO) throws UnsupportedEncodingException {
        if (dataDTO.getStartTime() * 100 > System.currentTimeMillis()) {
            return;
        }

//        1616405400*100
        String data = "data=" +
                URLEncoder.encode("{\"0caddc48d709afde9cc4986b3a85155e\":\"36.2\",\"a4f42d8428d2d4ca3f4562ff86305eb0\"" +
                        ":{\"name\":\"江门职业技术学院\",\"location\":\"113.107748,22.626487\",\"address\":\"潮连镇潮连大道6号\"}}", "UTF-8");

        String extends_ = "&extend=" +
                URLEncoder.encode("{\"TaskId\":" +
                        "\"" +
                        dataDTO.getId() +
                        "\",\"title\":\"任务信息\",\"content\":[{\"label\":\"任务名称\",\"value\":\"" +
                        dataDTO.getTitle() +
                        "\"},{\"label\":\"发布机构\",\"value\":\"学生工作处\"},{\"label\":\"发布人\",\"value\":\"张荣滔\"}]}", "UTF-8");

//https://api.uyiban.com/workFlow/c/my/apply/0fdc7d14852072e89644a84c593dfb26?CSRF=a5711d8e06ad5b678b195c4a27ecabbb
        NetWork.postJson("https://api.uyiban.com/workFlow/c/my/apply/" + Wfid + "?CSRF=" + CSRF, data + extends_, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                TaskResult taskResult = gson.fromJson(response.body().string(), TaskResult.class);
//                System.out.println(taskResult.getCode());

                if (taskResult.getCode() == 0) {
                    //操作成功
                    Looper.prepare();
                    Handler handler = new Handler();
                    handler.post(()->{
                        Toast.makeText(AppClient.getContext(), "打卡成功", Toast.LENGTH_SHORT).show();
                    });
                    Looper.loop();

                }
            }
        });
    }

    private void getUncompletedDetails(String taskId, DataResult<TaskDetails.DataDTO> data) {
        NetWork.get("https://api.uyiban.com/officeTask/client/index/detail?TaskId=" + taskId + "&CSRF=" + CSRF, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                TaskDetails taskDetails = gson.fromJson(response.body().string(), TaskDetails.class);
                data.onResponse(taskDetails.getData());
            }
        });
    }

    public void start(String user, String pass, DataResult<LoginResult> dataResult) throws UnsupportedEncodingException,RuntimeException {
//        System.out.println(encodePass(pass));
        //https://mobile.yiban.cn/api/v2/passport/login?account=15992266476&passwd=OTNz%252BKfbC0zZ0h5tH7r4KUFS92YZL567UFvStK3BgS7%252FPjTglbro62JguxRf7YWubW2ZhZ86Uv3FfBi6gioH%252B%252FxS5GcsV7P2s4u26FOwThQZHm3fpgQh2I7M6NkCdl2DbwJvp6Et82yFrhsgbT6tMzUHdipKE5xeg%252FqWbUWHv41kYLDp8y8Z4bnFnJPb10lRlCn%252Be6Mukwna6bokeLhSI1JaxX349EijvZ6P9Mvj1Ml%252FCbKcfVcOGkyGrEhXLfz%252BpDM56NATNpaCuIcwnaGJgvRk4jSc%252BPEyL3lougMyU8Z1qYgaWTf%252BvXsdQ7y74siBDflNUXCgwRmn04vyK9uUnQ1SrH5d%252FLbKfVbmnm%252FC2Fukriskp0EDnlYmtF52e2OyK0%252FjFer6m79YW7ZZiCHEKpKr6lEJTujAStJ2E%252F5IAGI0ztSy0006%252Be9qpdKigIrv87EefTCcCNPIADe3ASR%252FPejGg%252Bjy%252FsIBMy%252FUFIi51qH%252BzOvtEduVVLTs1xbTJfIX9q9tzjGYrQkUjN6YQNpJJhviHXpWqyL3JHOA0i68PpCnrNZ9Stih0EV845fGGkhWM4ITNHsaRjECdUupYfbzbrrpvaeggX%252B0ProXFn3lf9iXgmo4T6he29X%252F87439ZxihT8TYUKNEQMDyh9NBPLvy9Kp7CmCWkAWcChjRj1gCUE%253D&ct=2&app=1&v=4.9.6&apn=wifi&identify=865166024273487&sig=3e973e054e0f6e7f&token=&device=samsung%3ASM-N9760&sversion=22
        NetWork.get("https://mobile.yiban.cn/api/v2/passport/login?account=" + user
                + "&passwd=" + URLEncoder.encode(encodePass(pass), "UTF-8") + "&ct=2&app=1&v=4.9.6&identify=865166024273487&device=samsung:SM-N9760&version=22&apn=wifi&sig=3e973e054e0f6e7f&Z&token=", new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                dataResult.onFailure(call, e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//                Log.i("TAG", response.body().string());

                LoginResult loginResult = gson.fromJson(response.body().string(), LoginResult.class);

                if (loginResult.getResponse().equals("100")) {
                    String token = loginResult.getData().getToken();
                    String accessToken = loginResult.getData().getAccessToken();
                    auth(accessToken);
                    dataResult.onResponse(loginResult);
                }


            }
        });
    }

    private static byte[] base64Decode(byte[] paramArrayOfbyte) {
        return Base64.decode(paramArrayOfbyte, 2);
    }

    private String encodePass(String pass) {
        String public_key = "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAxbzZk3gEsbSe7A95iCIk\n" +
                "59Kvhs1fHKE6zRUfOUyTaKd6Rzgh9TB/jAK2ZN7rHzZExMM9kw6lVwmlV0VabSmO\n" +
                "YL9OOHDCiEjOlsfinlZpMZ4VHg8gkFoOeO4GvaBs7+YjG51Am6DKuJWMG9l1pAge\n" +
                "96Uhx8xWuDQweIkjWFADcGLpDJJtjTcrh4fy8toE0/0zJMmg8S4RM/ub0q59+VhM\n" +
                "zBYAfPmCr6YnEZf0QervDcjItr5pTNlkLK9E09HdKI4ynHy7D9lgLTeVmrITdq++\n" +
                "mCbgsF/z5Rgzpa/tCgIQTFD+EPPB4oXlaOg6yFceu0XUQEaU0DvAlJ7Zn+VwPkkq\n" +
                "JEoGudklNePHcK+eLRLHcjd9MPgU6NP31dEi/QSCA7lbcU91F3gyoBpSsp5m7bf5\n" +
                "//OBadjWJDvl2KML7NMQZUr7YXqUQW9AvoNFrH4edn8d5jY5WAxWsCPQlOqNdybM\n" +
                "vKF2jhjIE1fTWOzK+AvvFyNhxer5bWGU4S5LTr7QNXnvbngXCdkQfrcSn/ydQXP0\n" +
                "vXfjf3NhpluFXqWe5qUFKXvjY6+PdrE/lvTmX4DdvUIu9NDa2JU9mhwAPPR1yjjp\n" +
                "4IhgYOTQL69ZQcvy0Ssa6S25Xi3xx2XXbdx8svYcQfHDBF1daK9vca+YRX/DzXxl\n" +
                "1S4uGt+FUWSwuFdZ122ZCZ0CAwEAAQ==";
        return new String(EncryptUtils.encryptRSA2Base64(pass.getBytes(), base64Decode(public_key.getBytes()), 1024, "RSA/None/PKCS1Padding"));


    }
}
