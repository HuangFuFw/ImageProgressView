package com.ai.eve.ui.demo.component;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.ai.eve.ui.demo.IMyInterface;

/**
 * Created by huangfu on 2016/7/11 10.:30
 */
public class RemoteService extends Service {

//    private RemoteIBinder remoteIBinder;

    private final IMyInterface.Stub remoteIBinder=new IMyInterface.Stub(){
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void print(String str) throws RemoteException {

        }
    };
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return remoteIBinder;
    }
}
