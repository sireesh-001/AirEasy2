package com.cuberto.AirEasy;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class NotificationChannels extends Application {
    public static final String Chl_onscreen="screenchannel";
    public static final String Chl_popup="popupchannel";
    @Override
    public void onCreate(){
        super.onCreate();
        createchannels();
    }
    void createchannels(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
        NotificationChannel notificationChannel1=new NotificationChannel(Chl_onscreen,"screenchannel",NotificationManager.IMPORTANCE_LOW);
        notificationChannel1.setDescription("OnScreen notification");

        NotificationChannel notificationChannel2=new NotificationChannel(Chl_popup,"popupchannel",NotificationManager.IMPORTANCE_HIGH);
        notificationChannel2.setDescription("OnScreen notification");

        NotificationManager notificationManager=getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(notificationChannel1);
        notificationManager.createNotificationChannel(notificationChannel2);
    }}
}
