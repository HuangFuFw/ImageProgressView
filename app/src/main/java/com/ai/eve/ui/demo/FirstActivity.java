package com.ai.eve.ui.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.ai.eve.ui.demo.widget.TopBar;

/**
 * Created by huangfu on 2016/4/11 11:58.
 */
public class FirstActivity extends TracerActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        TopBar topbar= (TopBar) findViewById(R.id.topbar);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String[] values = getResources().getStringArray(R.array.operating_systems);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
        spinner.setAdapter(adapter);
//        TextView tv1=(MyTextView1)findViewById(R.id.tv1);
//        TextView tv2=(MyTextView2)findViewById(R.id.tv2);
//        tv1.setText(getResources().getString(R.string.tv1_content));
//        tv1.setText("你好你好你好你好");
//        tv2.setText("你好你好你好你好");
        topbar.setButtonVisibility(1,false);
        topbar.setmClickListener(new TopBar.topbarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(FirstActivity.this, "left======", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void rightClick() {

                Toast.makeText(FirstActivity.this, "right======", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void onClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

}
