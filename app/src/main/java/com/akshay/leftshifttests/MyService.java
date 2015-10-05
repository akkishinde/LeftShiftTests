package com.akshay.leftshifttests;


        import android.app.Service;
        import android.content.Intent;
        import android.os.Binder;
        import android.os.IBinder;
        import android.widget.Toast;

        import java.text.SimpleDateFormat;
        import java.util.Random;

public class MyService extends Service {
    IBinder serviceBinder = new MyServiceBinder();

    public MyService() {
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();
        super.onCreate();

    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();

        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "onStartCommand", Toast.LENGTH_SHORT).show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent broadcastIntent = new Intent();
                broadcastIntent.setAction(ServiceActivity.MY_ACTION);
                broadcastIntent.putExtra("Data","1");
                sendBroadcast(broadcastIntent);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                broadcastIntent.setAction(ServiceActivity.MY_ACTION);
                broadcastIntent.putExtra("Data2","2");
                sendBroadcast(broadcastIntent);
            }

        }).start();
        return START_STICKY;
    }

    public int getRandomNumber() {

        return new Random().nextInt();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "onBind", Toast.LENGTH_SHORT).show();


        return serviceBinder;
    }

    public class MyServiceBinder extends Binder {
        public MyService getServiceBinder() {

            return MyService.this;
        }
    }
}
