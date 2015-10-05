package com.akshay.leftshifttests;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Akshay on 03-10-2015.
 */
public class MyCustomBroadcast extends BroadcastReceiver{

    private static final String TAG = MyCustomBroadcast.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "Inside   MyCustomBroadcast");
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder notificationBuilder = new Notification.Builder(context);
        notificationBuilder.setContentTitle("New Notification")
                .setContentText("Hello to all").
                setSmallIcon(R.drawable.leftshift);
        Notification notification = notificationBuilder.build();
        notificationManager.notify(1, notification);
    }

}
