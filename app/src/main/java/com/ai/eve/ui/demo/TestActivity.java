package com.ai.eve.ui.demo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.ms.square.android.expandabletextview.ExpandableTextView;

/**
 * Created by huangfu on 2016/7/20 16:41.
 */
public class TestActivity extends TracerActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AsyncTask a=new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] params) {
                return null;
            }
        };
        a.execute();
//        RequestQueue

        int[] s=new int[3];
//        HashMap
//        LruCache




        LinearLayout inflate_linear = (LinearLayout) findViewById(R.id.linear_content);
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.test, inflate_linear, true);
//        inflate_linear.addView(view);

        Button btn_one = (Button) view.findViewById(R.id.btn_one);
        Button btn_two = (Button) view.findViewById(R.id.btn_two);
        ViewGroup btn_one_parent = (ViewGroup) btn_one.getParent();
//
        ViewGroup viewGroup_inner = (ViewGroup) view.getParent();
//        ViewGroup.LayoutParams params1 = btn_one_parent.getLayoutParams();
//        ViewGroup.LayoutParams params2 = viewGroup_inner.getLayoutParams();
        btn_one.setText("button的父容器" + btn_one_parent + "=======" );
        btn_two.setText("layout的父容器" + viewGroup_inner + "=======" );
        ExpandableTextView expTv1 = (ExpandableTextView)view
                .findViewById(R.id.expand_text_view);

// IMPORTANT - call setText on the ExpandableTextView to set the text content to display
        expTv1.setText(getString(R.string.temp_text));

    }


}
