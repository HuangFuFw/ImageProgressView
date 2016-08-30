package com.ai.eve.ui.demo.component;


import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * Created by huangfu on 2016/7/8 10.:30
 */
public class LocalService extends Service {
    private LocalBinder localBinder=new LocalBinder();

    public class LocalBinder extends Binder{
       public LocalService getService(){
            return LocalService.this;
        }

    }
    @Override
    public IBinder onBind(Intent intent) {
//        return null;
        return localBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
}
