package com.ai.eve.ui.demo;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
/**
 * -   ┏┓　　　┏┓
 * - ┏┛┻━━━┛┻┓
 * - ┃　　　━　　　┃
 * - ┃　┳┛　┗┳　┃
 * - ┃　　　　　　　┃
 * - ┃　　　┻　　　┃
 * - ┗━┓　　　┏━┛
 * -     ┃　　　┃
 * -     ┃　　　┃
 * -     ┃　　　┗━━━━┓
 * -     ┃　　　　　　　  ┣┓
 * -     ┃　　　　　　　  ┏┛
 * -     ┗┓┓┏━┳┓┏━┛
 * -       ┃┫┫　┃┫┫
 * -       ┗┻┛　┗┻┛
 * -        神兽保佑
 * -        无 BUG !
 *
 * Created by huangfu on 2016/6/3 18:38.
 */
public class ThreeActivity extends TracerActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //设置Logog
        toolbar.setLogo(R.drawable.hh_edit);
        //设置主标题
        toolbar.setTitle("Title");
        //设置主标题颜色
//        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        //设置副标题
        toolbar.setSubtitle("Subtitle");
        setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int menuItemId = item.getItemId();
                if (menuItemId == R.id.action_edit) {
                    Toast.makeText(ThreeActivity.this , "item1", Toast.LENGTH_SHORT).show();

                } else if (menuItemId == R.id.action_share) {
                    Toast.makeText(ThreeActivity.this , "item2" , Toast.LENGTH_SHORT).show();

                } else if (menuItemId == R.id.action_settings) {
                    Toast.makeText(ThreeActivity.this , "item3" , Toast.LENGTH_SHORT).show();

                }
                return true;
            }
        });
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DrawerLayout lay= (DrawerLayout) findViewById(R.id.DragLayout1);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,lay,toolbar,R.string.abc_action_bar_home_description,R.string.abc_action_bar_home_description_format);
        toggle.syncState();
        lay.setDrawerListener(toggle);
        applyKitKatTranslucency();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 為了讓 Toolbar 的 Menu 有作用，這邊的程式不可以拿掉
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }




}
