package com.yiban.test.ui.main;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yiban.test.R;
import com.yiban.test.adapter.UserListAdapter;
import com.yiban.test.adapter.bean.UserBean;
import com.yiban.test.model.YiBanHelper;
import com.yiban.test.model.bean.LoginResult;
import com.yiban.test.service.AutoSignUpService;
import com.yiban.test.ui.base.BaseActivity;
import com.yiban.test.ui.setting.SettingActivity;
import com.yiban.test.utils.SpUtils;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

public class MainActivity extends BaseActivity {

    private RecyclerView recyclerUser;
    private UserListAdapter adapter;
    private ArrayList<UserBean> userBeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
//    getSupportActionBar().hide();

    }

    @Override
    public void init() {


            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(openFileInput("user"));
                if (userBeans == null) {
                    ArrayList<UserBean> obj = (ArrayList<UserBean>) objectInputStream.readObject();
                    if (obj != null) {
                        userBeans = obj;
                    }
                    loadUserToRecyclerView(this.userBeans);
                }


            } catch (Exception e) {
                e.printStackTrace();
            }



    }

    @Override
    public void initView() {
        boolean auto = SpUtils.getBoolean("auto");
        if (auto) {
            bindService(new Intent(MainActivity.this, AutoSignUpService.class), new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    AutoSignUpService.MyBinder myBinder = (AutoSignUpService.MyBinder) service;
                    myBinder.getService().setFlag(SpUtils.getBoolean("auto"));
                    myBinder.setContent(MainActivity.this);
                }

                @Override
                public void onServiceDisconnected(ComponentName name) {

                }
            },BIND_AUTO_CREATE);
            startService(MainActivity.this.getIntent());


            recyclerUser = (RecyclerView) findViewById(R.id.recycler_user);

        }

    }

    public void loadUserToRecyclerView(List<UserBean> list) {
        recyclerUser.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        adapter = new UserListAdapter(this, list);
        recyclerUser.setAdapter(adapter);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        if (requestCode == 1) {


            
            try {
                Uri uri = data != null ? data.getData() : null;
                InputStream inputStream = getContentResolver().openInputStream(uri);
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuffer sb = new StringBuffer();
                userBeans = new ArrayList<>();

                while ((temp = br.readLine()) != null) {
                    String[] arr = temp.trim().split("\\s+");
                    Log.i("temp", temp);

                    if (arr.length < 2) {
                        Toast.makeText(this, "文档错误,某行缺少账号或密码,请检查文档,但是为了不影响其他用户 将继续对其他无错误的用户导入", Toast.LENGTH_SHORT).show();
                        continue;
                    }
                    userBeans.add(new UserBean(arr[0].trim(), arr[1].trim()));

//
//                    sb.append(temp);
//                    sb.append("\n");
                }
                loadUserToRecyclerView(userBeans);

                try {
                    if (userBeans.size() > 0) {
                        ObjectOutputStream outputStream = new ObjectOutputStream(openFileOutput("user", MODE_PRIVATE));
                        outputStream.writeObject(userBeans);
                        outputStream.flush();
                        outputStream.close();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
//                Toast.makeText(this, "  " + sb.toString().trim(), Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.load_all) {
            loadOptFile();

        }
        if (item.getItemId() == R.id.start_work) {
            if (userBeans != null) {
                for (UserBean user : userBeans) {
                    String phone = user.getPhone();
                    String msg = user.getMsg();
                    start(user, phone, msg);
                }
                adapter.notifyDataSetChanged();
            }

        }
        if (item.getItemId() == R.id.setting) {
            startActivity(new Intent(this, SettingActivity.class));
        }


        return true;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);

    }

    private void start(UserBean user, String phone, String msg) {
        YiBanHelper yiBanHelper = new YiBanHelper();
        try {
            yiBanHelper.start(phone, msg, new YiBanHelper.DataResult<LoginResult>() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull String e) {

                }

                @Override
                public void onResponse(LoginResult loginResult) throws IOException {
                    if (loginResult != null) {
                        String name = loginResult.getData().getUser().getName();
                        if (null != name) {
                            user.setName(name);
                            user.setOk(1);
                        }else{
                            user.setOk(2);
                        }


                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadOptFile() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("text/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent,1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}