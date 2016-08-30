package com.ai.eve.ui.demo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

import com.ai.eve.ui.demo.component.LocalService;
import com.ai.eve.ui.demo.component.RemoteService;

/**
 * Created by huangfu on 2016/7/8 10.:38
 */
public class ServiceDemoActivity extends TracerActivity {

    private LocalService localService;
    private IMyInterface iMyInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//
//        Intent intent = new Intent(this, LocalService.class);
//        bindService(intent, conn, Context.BIND_AUTO_CREATE);


        Intent intent = new Intent(this, RemoteService.class);
        bindService(intent, conn, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
//            LocalService.LocalBinder sBinder = (LocalService.LocalBinder) service;
//            localService = sBinder.getService();
            iMyInterface = IMyInterface.Stub.asInterface(service);
            try {
                iMyInterface.print("===");
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            iMyInterface=null;
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
