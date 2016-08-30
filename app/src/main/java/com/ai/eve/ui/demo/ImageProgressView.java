package com.ai.eve.ui.demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by huangfu on 2016/2/23 11:01.
 */
public class ImageProgressView extends ImageView{

    private Paint mPaint;
    private int width,height;
    private Context context;
    private int progress=0;

    private boolean start=false;
    private boolean stop =false;


    public ImageProgressView(Context context) {
        this(context, null);
    }

    public ImageProgressView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ImageProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        mPaint=new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(start==true){
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);

        mPaint.setColor(Color.parseColor("#90000000"));
        canvas.drawRect(0, 0, getWidth(), getHeight()-getHeight()*progress/100, mPaint);

        mPaint.setColor(Color.parseColor("#00000000"));
        canvas.drawRect(0, getHeight() - getHeight() * progress / 100, getWidth(), getHeight(), mPaint);

        mPaint.setTextSize(40);
        mPaint.setColor(Color.parseColor("#FFFFFF"));
        mPaint.setStrokeWidth(1);
        Rect rect=new Rect();
        mPaint.getTextBounds("100%", 0, "100%".length(), rect);
            if(stop ==false) {
                canvas.drawText(progress + "%", getWidth() / 2 - rect.width() / 2, getHeight() / 2, mPaint);
            }
        }
    }

    public void startProgress(int progress){
        start=true;
        this.progress=progress;
        postInvalidate();
    }
    public void stopProgress(){
        stop =true;
        postInvalidate();
    }

}
