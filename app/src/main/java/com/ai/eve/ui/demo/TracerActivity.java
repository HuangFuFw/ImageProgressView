package com.ai.eve.ui.demo;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Window;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;


/**
 * Created by huangfu on 2016/4/11 11:43.
 */


public class TracerActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notify("onCreate");
//        ViewServer.get(this).addWindow(this);
    }
    public void onDestroy() {
        super.onDestroy();
//        ViewServer.get(this).removeWindow(this);
    }

    public void onResume() {
        super.onResume();
//        ViewServer.get(this).setFocusedWindow(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        notify("onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        notify("onStop");
    }
    //下面两个方法是4.4版本一下状态栏有颜色
    public void applyKitKatTranslucency() {
        // KitKat translucent navigation/status bar.
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            SystemBarTintManager mTintManager = new SystemBarTintManager(this);
            mTintManager.setStatusBarTintEnabled(true);
            mTintManager.setNavigationBarTintEnabled(true);
            mTintManager.setTintColor(0xFF03A9FF);
//            mTintManager.setTintDrawable(UIElementsHelper
//                    .getGeneralActionBarBackground(this));
        }
    }
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        notify("onRestoreInstanceState");
//    }
//
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        notify("onSaveInstanceState");
//    }

    private void notify(String methodName) {
//        String name = this.getClass().getName();
//        String[] strings = name.split("\\.");
//        Notification noti = new Notification.Builder(this)
//                .setContentTitle(methodName + " " + strings[strings.length - 1]).setAutoCancel(true)
//                .setSmallIcon(R.drawable.ic_launcher)
//                .setContentText(name).build();
//        NotificationManager notificationManager =
//                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        notificationManager.notify((int) System.currentTimeMillis(), noti);
    }

}
