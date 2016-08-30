package com.ai.eve.ui.demo.widget;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by huangfu on 2016/6/3 16:48.
 */
public class DragLayout extends FrameLayout{
    private ViewDragHelper mViewDragHelper;
    private View mainView;
    private View menuView;
    private int mWidth;

    public DragLayout(Context context) {
        super(context);
        initInstance();
    }

    public DragLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInstance();
    }

    public DragLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInstance();
    }

    private void initInstance(){
        mViewDragHelper=ViewDragHelper.create(this, mCallBack);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        menuView = getChildAt(0);
        mainView = getChildAt(1);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = mainView.getMeasuredWidth();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mViewDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mViewDragHelper.processTouchEvent(event);
        return true;
    }

    private ViewDragHelper.Callback mCallBack=new ViewDragHelper.Callback() {
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return mainView==child;
        }

        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return left;
        }

        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            return 0;
        }

        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            super.onViewReleased(releasedChild, xvel, yvel);
            if(mainView.getLeft()<500){
                mViewDragHelper.smoothSlideViewTo(mainView,0,0);
                ViewCompat.postInvalidateOnAnimation(DragLayout.this);
            }else{
                mViewDragHelper.smoothSlideViewTo(mainView,300,0);
                ViewCompat.postInvalidateOnAnimation(DragLayout.this);
            }

        }

    };

    @Override
    public void computeScroll() {
        super.computeScroll();
        //每一帧中回调{@link #continueSettling(boolean)}方法,直至返回false.如果这个方法返回false,就不会再移动去完成手势动作的事件.
        if(mViewDragHelper.continueSettling(true)){
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }
}
