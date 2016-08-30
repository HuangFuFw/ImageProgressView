package com.ai.eve.ui.demo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ScrollView;
import android.widget.Scroller;


/**
 * Created by huangfu on 2016/5/13 11:33.
 */
public class MyScrollView extends ViewGroup{
    private Scroller mScroller;
    private int screenHeight;
    private int mLastY;
    private int mStart;
    private ScrollView s;


    public MyScrollView(Context context) {
        super(context);
        mScroller=new Scroller(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mScroller=new Scroller(context);
//
//        WindowManager windowManager = (WindowManager)context
//                .getSystemService(Context.WINDOW_SERVICE);
//        DisplayMetrics metrics = new DisplayMetrics();
//        windowManager.getDefaultDisplay().getMetrics(metrics);
//        screenHeight = metrics.heightPixels;

        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);
        screenHeight = wm.getDefaultDisplay().getHeight();

    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childCount=getChildCount();
        Log.i("====","childcount==="+childCount);
        for(int i=0;i<childCount;i++){
            View childView=getChildAt(i);
            measureChild(childView,widthMeasureSpec,heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount=getChildCount();
        Log.i("====","childcount==="+childCount);
        MarginLayoutParams mlp= (MarginLayoutParams) getLayoutParams();
        mlp.height=getHeight()*childCount;
        setLayoutParams(mlp);

        for(int i=0;i<childCount;i++){
            View childView=getChildAt(i);
            if(childView.getVisibility()!=View.GONE){
              childView.layout(l,i*screenHeight , r, (i+1)*screenHeight);
            }
        }
        Log.i("=====getHeight",getHeight()+"=====");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y= (int) event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mLastY=y;
                Log.i("ACTION_DOWN==y=",y+"=====");
                Log.i("ACTION_DOWN==getScrollY=", getScrollY()+"=====");
                mStart = getScrollY();
                break;
            case MotionEvent.ACTION_MOVE:
//                if(!mScroller.isFinished()){
//                   mScroller.abortAnimation();
//                }
                int dy=mLastY-y;
                if(getScrollY()<0){
                    dy= -getScrollY();
                }
                if(getScrollY()>getHeight()-screenHeight){
                    dy = getHeight() - getScrollY()-screenHeight;
                }
//                // 已经到达顶端，下拉多少，就往上滚动多少
//                if (dy < 0 && getScrollY() + dy < 0)
//                {
//                    dy = -getScrollY();
//                }
//                // 已经到达底部，上拉多少，就往下滚动多少
//                if (dy > 0 && getScrollY() + dy > getHeight() - getScrollY())
//                {
//                    dy = getHeight() - screenHeight - getScrollY();
//                }

                scrollBy(0,dy);
                mLastY=y;
                Log.i("=====ACTION_MOVE==y=",y+"=====");
                Log.i("=====ACTION_MOVE==getScrollY=", getScrollY()+"=====");
                break;
            case MotionEvent.ACTION_UP:
                int mEnd=getScrollY();
                int dScroll=mEnd-mStart;
                //上滑  dScroll>0 (dy这个参数大于0 上滑)
                if(dScroll>0){
                    if(dScroll<screenHeight/3){
                        mScroller.startScroll(0,getScrollY(),0,-dScroll);
                    }else{
                        mScroller.startScroll(0,getScrollY(),0,screenHeight-dScroll);
                    }
                }else{
                    //
                    if(-dScroll<screenHeight/3){
                        mScroller.startScroll(0,getScrollY(),0,-dScroll);
                    }else{
                        mScroller.startScroll(0,getScrollY(),0,-screenHeight-dScroll);
                    }
                }
                break;
        }
        postInvalidate();
        return true;
    }

    @Override
    public void computeScroll() {
//        super.computeScroll();
        //其中Scroller.computeScrollOffset()方法是判断scroller的移动动画是否完成，当你调用startScroll()方法的时候这个方法返回的值一直都为true，如果采用其它方式移动视图比如：scrollTo()或 scrollBy时那么这个方法返回false。
        if(mScroller.computeScrollOffset()){//
            scrollTo(0,mScroller.getCurrY());
            postInvalidate();
        }

    }
}
