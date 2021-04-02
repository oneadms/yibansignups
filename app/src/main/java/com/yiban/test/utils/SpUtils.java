package com.yiban.test.utils;

import android.content.SharedPreferences;

import com.yiban.test.AppClient;

public class SpUtils {
    private static SharedPreferences sharedPreferences;

    static {
        sharedPreferences = AppClient.getSp();
    }

    public static void putString(String key,String str) {
        sharedPreferences.edit().putString(key, str).commit();
    }
    public static void putBoolean(String key,boolean flag) {
        sharedPreferences.edit().putBoolean(key, flag).commit();
    }
    public static String getString(String key) {
        return sharedPreferences.getString(key, "");
    }
    public static boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, true);
    }

}
