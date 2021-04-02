package com.yiban.test;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class AppClient extends Application {

    private static SharedPreferences sp;
    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sp = getSharedPreferences("sp", MODE_PRIVATE);
        context = getApplicationContext();

    }


    public static SharedPreferences getSp() {
        return sp;
    }
}
