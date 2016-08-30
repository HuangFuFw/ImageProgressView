package com.ai.eve.ui.demo;

import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ai.eve.ui.demo.bean.Person;
import com.ai.eve.ui.demo.utils.TimeTrace;

import org.xmlpull.v1.XmlPullParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by huangfu on 2016/8/26 17.:42
 */
public class SPrefsActivity extends TracerActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sprefs);
        testAnnotatedMethod();

//        SharedPreferences sharedPreferences = getSharedPreferences("fileName", Context.MODE_PRIVATE); //私有数据
//        SharedPreferences.Editor editor = sharedPreferences.edit();//获取编辑器
//        editor.putString("key1", "哈哈");
//        editor.putString("key2", "呵呵");
//        editor.putInt("age", 4);
//        editor.commit();//提交修改
//        System.nanoTime();


//        Bitmap oldbmp = drawableToBitmap(drawable);
        Button button = (Button) findViewById(R.id.btn);
        textView = (TextView) findViewById(R.id.tve);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SharedPreferences sharedPreferences = getSharedPreferences("fileName", Context.MODE_PRIVATE);
                File xmlFile = new File("/data/data/"+getPackageName().toString()+"/shared_prefs/fileName.xml");
//                InputStream iStream = SPrefsActivity.class.getClassLoader()
//                        .getResourceAsStream("fileName.xml");
                InputStream iStream = null;
                try {
                    iStream = new FileInputStream(xmlFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                textView.setText(readXML(iStream).toString());
            }
        });


    }


    public static Person readXML(InputStream inStream) {

        XmlPullParser parser = Xml.newPullParser();

        try {
            parser.setInput(inStream, "UTF-8");
            int eventType = parser.getEventType();

            Person currentPerson = null;

            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT://文档开始事件,可以进行数据初始化处理
                        currentPerson = new Person();
                        break;

                    case XmlPullParser.START_TAG://开始元素事件
                        String name = parser.getName();
                        if (name.equalsIgnoreCase("map")) {
                            currentPerson = new Person();
                        } else if (currentPerson != null) {
                            if (name.equalsIgnoreCase("string")) {
                                currentPerson.setName1(parser.nextText());// 如果后面是Text元素,即返回它的值
                            }else if(name.equalsIgnoreCase("int")){
                                currentPerson.setName2(parser.nextText());// 如果后面是Text元素,即返回它的值

                            }
                        }
                        break;

                    case XmlPullParser.END_TAG://结束元素事件
                        if (parser.getName().equalsIgnoreCase("person") && currentPerson != null) {
                            currentPerson = null;
                        }

                        break;
                }

                eventType = parser.next();
            }

            inStream.close();
            return currentPerson;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args){
        //TODO
        testAnnotatedMethod();
        System.out.println("哈哈哈哈哈");

    }
    @TimeTrace
    private static void testAnnotatedMethod() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }


}
