package com.yiban.test.service;


import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.yiban.test.R;
import com.yiban.test.adapter.bean.UserBean;
import com.yiban.test.model.YiBanHelper;
import com.yiban.test.model.bean.LoginResult;
import com.yiban.test.ui.main.MainActivity;

import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import okhttp3.Call;

public class AutoSignUpService extends Service {
    private final MyBinder myBinder = new MyBinder();
    boolean flag;
    private Context context;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

   public class MyBinder extends Binder {
       public void setContent(Context context) {
           AutoSignUpService.this.context = context;
       }
        public AutoSignUpService getService() {
            return AutoSignUpService.this;
        }
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    private String createNotificationChannel(String channelID, String channelNAME, int level) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationChannel channel = new NotificationChannel(channelID, channelNAME, level);
            manager.createNotificationChannel(channel);
            return channelID;
        } else {
            return null;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyService", "onCreate executed");
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        Notification notification = null;

            notification = new NotificationCompat.Builder(this,createNotificationChannel("oneadms","oneadms", NotificationManager.IMPORTANCE_HIGH))
                    .setContentTitle("易班打卡正在为你服务")
                    .setContentText("yiban sign up fuck for you")
                    .setWhen(System.currentTimeMillis())
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(),
                            R.mipmap.ic_launcher))
                    .setContentIntent(pi)
                    .build();

        startForeground(1, notification);
        new Thread(() -> {
            while (true) {
                if (flag) {


                    try {
                        ObjectInputStream objectInputStream = new ObjectInputStream(openFileInput("user"));
                        ArrayList<UserBean> userBeans = (ArrayList<UserBean>) objectInputStream.readObject();
                        if (userBeans != null) {
                            for (UserBean userBean : userBeans) {
                                YiBanHelper yiBanHelper = new YiBanHelper();
                                yiBanHelper.start(userBean.getPhone(), userBean.getMsg(), new YiBanHelper.DataResult<LoginResult>() {
                                    @Override
                                    public void onFailure(@NotNull Call call, @NotNull String e) {

                                    }

                                    @Override
                                    public void onResponse(LoginResult loginResult) throws IOException {
                                        if (loginResult != null
                                        ) {
                                            String name = loginResult.getData().getUser().getName();
//                                            Log.i("service", "onResponse: " + name);
                                            userBean.setName(name);
                                            userBean.setOk(1);
                                            ((MainActivity) context).runOnUiThread(()->{
                                                ((MainActivity) context).loadUserToRecyclerView(userBeans);
                                            });
                                        }


                                    }
                                });
                            }
                        }
                        synchronized (this){
                            wait(30000);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
