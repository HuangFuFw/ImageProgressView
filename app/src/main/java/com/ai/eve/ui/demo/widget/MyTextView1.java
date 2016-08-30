package com.ai.eve.ui.demo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by huangfu on 2016/5/5 14:57.
 */
public class MyTextView1 extends TextView {
    private Paint mPaint1;
    private Paint mPaint2;

    public MyTextView1(Context context) {
        super(context);
        initPaint();
    }

    public MyTextView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public MyTextView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        initPaint();
    }
    private void initPaint(){
        mPaint1=new Paint();
        mPaint1.setColor(Color.YELLOW);
        mPaint1.setStyle(Paint.Style.STROKE);
        mPaint2=new Paint();
        mPaint2.setColor(getResources().getColor(android.R.color.holo_blue_bright));
        mPaint2.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint1);
        canvas.drawRect(10, 10, getMeasuredWidth() - 10, getMeasuredHeight() - 10, mPaint2);
        canvas.save();
        canvas.translate(10, 0);
        super.onDraw(canvas);
        canvas.restore();
    }
}
