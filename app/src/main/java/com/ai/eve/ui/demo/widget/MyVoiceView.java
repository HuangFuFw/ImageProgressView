package com.ai.eve.ui.demo.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import android.widget.TextView;

/**
 * Created by huangfu on 2016/5/11 16:39.
 */
public class MyVoiceView extends View {
    private Paint mRectPaint;
    private int mWith;
    private int mRectHeight;
    private int mRectWith;
    private float mRectTop;
    private int offset;
    private int mRectCount;
    private LinearGradient mgradient;
    private int mLastY;
    private int mLastX;
    private Scroller mScroller;
//    ViewDragHelper
//    ViewGroup

    public MyVoiceView(Context context) {
        super(context);
    }

    public MyVoiceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mScroller=new Scroller(context);
    }

    public MyVoiceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScroller=new Scroller(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
        int widthSize=MeasureSpec.getSize(widthMeasureSpec);
        int heightMode=MeasureSpec.getMode(heightMeasureSpec);
        int heightSize=MeasureSpec.getSize(heightMeasureSpec);

        int width;
        if (widthMode==MeasureSpec.EXACTLY){
            width=widthSize;
        }else{
            width=200;
            if(widthMode==MeasureSpec.AT_MOST){
                width=Math.min(200,width);
            }
        }

        int height;
        if (heightMode==MeasureSpec.EXACTLY){
            height=heightSize;
        }else{
            height=400;
            if(heightMode==MeasureSpec.AT_MOST){
                height=Math.min(400,heightSize);
            }
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mRectPaint=new Paint();
        mRectPaint.setStyle(Paint.Style.FILL);
        mRectPaint.setColor(Color.BLUE);
        mWith = getWidth();
        mRectHeight=getHeight();
//        mRectCount=10;
//        mRectWith= (int) (mWith*0.6/mRectCount);
//        offset=5;
//        mgradient = new LinearGradient(0,0,mRectWith,mRectHeight,new int[]{Color.BLUE,Color.GREEN},null, Shader.TileMode.CLAMP);
//        mRectPaint.setShader(mgradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        for (int i = 0; i < mRectCount; i++) {
////            double mRandom = Math.random() == 0 ? 1 : Math.random();
//            mRectTop = (float) (mRectHeight * 1);
//            canvas.drawRect((float) (mWith * 0.4 / 2 + mRectWith * i + offset), mRectTop, (float) (mWith * 0.4 / 2 + mRectWith * (i + 1)), mRectHeight, mRectPaint);
//        }
//        Log.i("=================", "onDraw");
            canvas.drawRect(100, 400, 400, 700, mRectPaint);
//        postInvalidateDelayed(3000);
        TextView t=new TextView(getContext());
        ObjectAnimator animator = ObjectAnimator.ofFloat(t, "translationY", t.getTranslationY(),0);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x= (int) event.getX();
        int y= (int) event.getY();
        int rx= (int) event.getRawX();
        int ry= (int) event.getRawY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
//                mLastY=y;
//                mLastX=x;
                mLastX=rx;
                mLastY=ry;
                Log.i("ACTION_DOWN==y=",y+"=====");
                Log.i("ACTION_DOWN==ryry=",ry+"=====");
//                Log.i("ACTION_DOWN==getScrollY=", getScrollY()+"=====");
                break;
            case MotionEvent.ACTION_MOVE:
//                if(!mScroller.isFinished()){
//                   mScroller.abortAnimation();
//                }
//                int dx=x-mLastX;
//                int dy=y-mLastY;
                int dx=rx-mLastX;
                int dy=ry-mLastY;
//                if(getScrollY()<0){
//                    dy=0;
//                }
//                if(getScrollY()>getHeight()-screenHeight){
//                    dy=0;
//                }
                // 已经到达顶端，下拉多少，就往上滚动多少
                layout(getLeft()+dx, getTop()+dy,getRight()+dx,getBottom()+dy);


//                scrollBy(0,dy);
//                mLastY=y;
                mLastX=rx;
                mLastY=ry;
//                Log.i("=====ACTION_MOVE==getScrollY=", getScrollY()+"=====");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("=====ACTION_UP==y=",y+"=====");
                Log.i("ACTION_DOWN==ryry=",ry+"=====");


                break;
        }
        postInvalidate();
        return true;
    }

//    @Override
//    public void computeScroll() {
////        super.computeScroll();
//        if(mScroller.computeScrollOffset()){
//            scrollTo(0,mScroller.getCurrX());
//            postInvalidate();
//        }
//
//    }

}
