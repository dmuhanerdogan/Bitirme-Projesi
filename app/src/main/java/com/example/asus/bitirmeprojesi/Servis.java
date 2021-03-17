package com.example.asus.bitirmeprojesi;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class Servis extends Service {
    Handler handler=new Handler();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;

    }
    @Override
    public void onCreate()
    {
        super.onCreate();

        Toast.makeText(getApplicationContext(),"Servis başladı",Toast.LENGTH_LONG).show();

        Runnable runnable=new Runnable() {
            @Override
            public void run() {

                handler.postDelayed(this,1000);

            }
        };
        handler.post(runnable);

    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();

    }

}
