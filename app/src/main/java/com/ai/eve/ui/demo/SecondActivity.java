package com.ai.eve.ui.demo;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by huangfu on 2016/4/11 11:59 10:41 10:42 10.:45
 */
public class SecondActivity extends TracerActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
//        ViewRoot

//        ImageView imageViewToRight = (ImageView) findViewById(R.id.image1);
//        imageViewToRight.scrollTo(0, 400);
//        Log.i("=======getScrollY=", imageViewToRight.getScrollY() + "=====");

//       MyView myView= (MyView) findViewById(R.id.myview);
//        myView.setSweepValue(270);
//        MyVoiceView myView= (MyVoiceView) findViewById(R.id.m);
    }
    public static void main(String[] args) {
        System.out.println();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
