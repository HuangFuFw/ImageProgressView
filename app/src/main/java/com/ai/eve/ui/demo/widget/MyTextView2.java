package com.ai.eve.ui.demo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by huangfu on 2016/5/5 14:57.
 */
public class MyTextView2 extends TextView {
    private Paint mPaint;
    private int mViewWidth=0;
    private LinearGradient mLinearGradient;
    private Matrix mGradientMatrix;
    private float mTranalate;

    public MyTextView2(Context context) {
        super(context);
    }

    public MyTextView2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w,h,oldw,oldh);
        if(mViewWidth==0){
            mViewWidth=getMeasuredWidth();
            Log.i("=================",w+"===");
            Log.i("=================","onSizeChanged");
            if(mViewWidth>0){
                mPaint=getPaint();
                mLinearGradient=new LinearGradient(0,0,mViewWidth,0,new int[]{Color.BLUE,0xffffffff, Color.BLUE},null, Shader.TileMode.CLAMP);
                mPaint.setShader(mLinearGradient);
                mGradientMatrix=new Matrix();
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.i("=================", getWidth()+"======"+getHeight());
        Log.i("=================","onMeasure");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.i("=================", "onLayout");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mGradientMatrix!=null){
            mTranalate+=mViewWidth/5;
            if(mTranalate>2*mViewWidth){
                mTranalate=-mViewWidth;
            }
            mGradientMatrix.setTranslate(mTranalate,0);
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            postInvalidateDelayed(100);
        }
        Log.i("=================","onDraw");
    }

}
