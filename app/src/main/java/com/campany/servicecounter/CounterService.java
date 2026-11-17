package com.campany.servicecounter;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

public class CounterService extends Service {

    private Handler handler;
    private Runnable runnable;
    private int tickCount = 1;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("SVC", "onCreate");
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                Log.d("SVC", "Тик " + tickCount);
                tickCount++;
                handler.postDelayed(this, 1000);
            }
        };
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("SVC", "onStartCommand");
        handler.removeCallbacks(runnable);
        handler.post(runnable);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("SVC", "onDestroy");
        handler.removeCallbacks(runnable);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
