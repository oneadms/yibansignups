package com.yiban.test.utils.ok;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;



/**
 * OkHttp框架Cookie管理类
 */

public class CookieJarManager implements CookieJar {

    private final String TAG = "CookieJarManager";

    private static  HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

    private static String CSRF = "a65b126f94428aff012b8834ee30dca1";

    static{



    }

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {

        if (null == url || null == cookies || cookies.size() <= 0) {
            return;
        }
        List<Cookie> cookie_ = new ArrayList<>();
        cookie_.addAll(cookies);
        cookie_.add(new Cookie.Builder().name("csrf_token").domain(url.host()).value(CSRF).build());


        cookieStore.put(url.host(), cookie_);
//        System.out.println("host_"+url.host());

        for (Cookie cookie : cookies) {
//            System.out.println("domain"+cookie.domain()+ "value"+cookie.value());
//            System.out.println(cookie.name());
        }


    }


    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        if (null != url) {
            List<Cookie> cookies = cookieStore.get(url.host());
            return cookies != null ? cookies : new ArrayList<Cookie>();
        } else {
            return new ArrayList<Cookie>();
        }
    }

}