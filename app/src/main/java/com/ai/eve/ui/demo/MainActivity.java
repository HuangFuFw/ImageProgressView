package com.ai.eve.ui.demo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.ai.eve.ui.demo.widget.MyDialogFragment;

import java.util.ArrayList;

public class MainActivity extends Activity implements MyDialogFragment.UserNameListener {
    private ImageProgressView iView;
    private int progress = 0;
    private final int SUCCESS = 0;


    private ArrayList<String> myDataset = new ArrayList<String>();

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SUCCESS:
                    Toast.makeText(MainActivity.this, "图片上传完成", Toast.LENGTH_SHORT).show();
                    iView.stopProgress();
                    break;
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity);
//        ViewServer.get(this).addWindow(this);
//
//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//
//
//            }
//        };
//        Drawable d = getDrawable(R.drawable.ab_android);


//        Timer timer = new Timer();
//        timer.schedule(timerTask, 1000, 1000);

//RecyclerView的测试
//        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.my_recycler_view);
//        recyclerView.setHasFixedSize(true);
//        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//
//        for (int i=0;i<30;i++){
//           myDataset.add(0,"text"+i);
//        }
//        recyclerView.setAdapter(new MyAdapter(myDataset));


//带进度阴影图片的测试
//        setContentView(R.layout.activity_mainactivity);
//        iView= (ImageProgressView) findViewById(R.id.iView);
//
// //上传进度
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    if(progress==100){
//                        handler.sendEmptyMessage(SUCCESS);
//                        return;
//                    }
//                    progress++;
////                    iView.startProgress(progress);
//                    try{
//                        Thread.sleep(200);
//                    } catch (InterruptedException e){
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();

    }

    public void onDestroy() {
        super.onDestroy();
//        ViewServer.get(this).removeWindow(this);
    }

    public void onResume() {
        super.onResume();
//        ViewServer.get(this).setFocusedWindow(this);
    }
//
//    public void onClick(View view) {
//        FragmentManager manager = getFragmentManager();
//        Fragment frag = manager.findFragmentByTag("fragment_edit_name");
//        if (frag != null) {
//            manager.beginTransaction().remove(frag).commit();
//        }
//        switch (view.getId()) {
//            case R.id.btn1:
//                MyAlertDialogFragment fragment = new MyAlertDialogFragment();
//                fragment.show(manager, "fragment1");
//
//                break;
//            case R.id.btn2:
//                MyDialogFragment fragment1 = new MyDialogFragment();
//                fragment1.show(manager, "fragment_edit_name");
//                break;
//
//        }

//    }


    @Override
    public void onFinished(String userName) {
        Toast.makeText(this, "Hello, " + userName, Toast.LENGTH_SHORT).show();
    }

}
