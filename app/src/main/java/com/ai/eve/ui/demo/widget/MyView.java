package com.ai.eve.ui.demo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by huangfu on 2016/5/10 11:39.
 */
public class MyView extends View{
    private Paint mCirclePaint;
    private Paint mArcPaint;
    private Paint mTextPaint;
    private float mSweepValue=25;
    public MyView(Context context) {
        super(context);
        initPaint();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void initPaint(){
        mCirclePaint =new Paint();
        mCirclePaint.setColor(getResources().getColor(android.R.color.holo_blue_bright));
        mCirclePaint.setStyle(Paint.Style.FILL);
        mCirclePaint.setAntiAlias(true);
        mArcPaint =new Paint();
        mArcPaint.setColor(getResources().getColor(android.R.color.holo_blue_bright));
        mArcPaint.setStyle(Paint.Style.STROKE);
        mArcPaint.setStrokeWidth(30);
        mArcPaint.setAntiAlias(true);
        mTextPaint =new Paint();
        mTextPaint.setColor(Color.BLACK);
        mTextPaint.setTextSize(46);
        mTextPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int length = getWidth();
        canvas.drawCircle(length / 2, length / 2, (float) (length * 0.5 / 2), mCirclePaint);

        RectF mArcRectF=new RectF((float)(length*0.1),(float)(length*0.1),(float)(length*0.9),(float)(length*0.9));
        canvas.drawArc(mArcRectF, 270, mSweepValue, false, mArcPaint);

        String showText="android";
        int len= (int) mTextPaint.measureText(showText);
        canvas.drawText("android", 0, showText.length() - 2, (length - len) / 2, length / 2 + (mTextPaint.getTextSize() / 4), mTextPaint);
//     canvas.drawRoundRect();
        Matrix matrix=new Matrix();
//        matrix.preScale()

    }

    public void  setSweepValue(float sweepValue){
        if(sweepValue!=0){
            mSweepValue=sweepValue;
        }else{
            mSweepValue=25;
        }
        this.invalidate();
    }

}
