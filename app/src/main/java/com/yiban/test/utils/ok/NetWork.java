package com.yiban.test.utils.ok;

import com.google.gson.Gson;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class NetWork {
    private static MediaType JSON;
    private static Gson mGson = new Gson();
    private static String url;

    static {

        okHttpClient = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)//设置连接超时时间
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .cookieJar(new CookieJarManager())
                .addInterceptor(new Interceptor() {
                    @NotNull
                    @Override
                    public Response intercept(@NotNull Chain chain) throws IOException {
                        Request.Builder builder = chain.request().newBuilder();
                        Request request = builder.header("AppVersion", "4.9.6")
//                        .header("Host", "mobile.yiban.cn")
                                .header("Authorization", "Bearer")
                                .header("accept", "*/*")
                                .header("connection", "Keep-Alive")
                                .header("origin","https://c.uyiban.com")
                                .header("cookie","csrf_token=a65b126f94428aff012b8834ee30dca1")
                                .header("x-requested-with","com.yiban.app")
                                .header("referer","https://c.uyiban.com/")
                                .header("user-agent","Mozilla/5.0 (Linux; Android 5.1.1; SM-N9760 Build/LMY47I; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/52.0.2743.100 Mobile Safari/537.36 yiban_android")
                                .header("accept-encoding","gzip/deflate")
                                .build();
                        return chain.proceed(request);
                    }
                }).followRedirects(false).build();
        JSON = MediaType.Companion.parse("application/x-www-form-urlencoded");

    }

    private static OkHttpClient okHttpClient;

    public static void postJson(String url, String params, Callback callback) {
        RequestBody body = RequestBody.Companion.create(params, JSON);
        Request request = new Request.Builder().url(url).post(body).build();
//        System.out.println(params);
        okHttpClient.newCall(request).enqueue(callback);

        NetWork.url = url;
    }

    public static void get(String url, Callback callback) {
        Request request = new Request.Builder().url(url).get().build();
        okHttpClient.newCall(request).enqueue(callback);
        NetWork.url = url;
    }

}