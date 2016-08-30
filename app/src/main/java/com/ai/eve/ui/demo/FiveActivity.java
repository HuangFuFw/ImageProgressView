package com.ai.eve.ui.demo;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by huangfu on 2016/8/10 18.:23
 */
public class FiveActivity extends TracerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.hh_edit);
        toolbar.setTitle("Title");
        setSupportActionBar(toolbar);
        //沉浸式
        applyKitKatTranslucency();

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "FAB", Snackbar.LENGTH_LONG)
                        .setAction("ok", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //这里的单击事件代表点击消除Action后的响应事件\
//                                Toast.makeText(FourActivity.this, "okok====", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });


    }
}
