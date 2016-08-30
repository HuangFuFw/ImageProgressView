package com.ai.eve.ui.demo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ai.eve.ui.demo.R;

/**
 * Created by huangfu on 2016/5/6 11:48.
 */
public class TopBar extends RelativeLayout {
    private Context mContext;

    private int mLeftTextColor;
    private Drawable mleftBackground;
    private String mLeftText;
    private int mRightTextColor;
    private Drawable mRightBackground;
    private String mRightText;
    private int mTitleColor;
    private float mTitleTextSize;
    private String mTitlecontent;
    private Button mLeftButton;
    private Button mRightButton;
    private TextView mTitleView;
    private LayoutParams mLeftParams;
    private LayoutParams mRightParams;
    private LayoutParams mTitleParams;
    private topbarClickListener mClickListener;

    public TopBar(Context context) {
        super(context);
        this.mContext = context;
    }

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        mLeftTextColor = typedArray.getColor(R.styleable.TopBar_leftTextColor, 0);
        mleftBackground = typedArray.getDrawable(R.styleable.TopBar_leftBackground);
        mLeftText = typedArray.getString(R.styleable.TopBar_leftText);

        mRightTextColor = typedArray.getColor(R.styleable.TopBar_rightTextColor, 0);
        mRightBackground = typedArray.getDrawable(R.styleable.TopBar_rightBackground);
        mRightText = typedArray.getString(R.styleable.TopBar_rightText);

        mTitleColor = typedArray.getColor(R.styleable.TopBar_titleColor, 0);
        mTitleTextSize = typedArray.getDimension(R.styleable.TopBar_titleTextSize, 10);
        mTitlecontent = typedArray.getString(R.styleable.TopBar_titlecontent);
        typedArray.recycle();

        mLeftButton = new Button(mContext);
        mRightButton = new Button(mContext);
        mTitleView = new TextView(mContext);

        mLeftButton.setTextColor(mLeftTextColor);
        mLeftButton.setBackground(mleftBackground);
        mLeftButton.setText(mLeftText);

        mRightButton.setTextColor(mRightTextColor);
        mRightButton.setBackground(mRightBackground);
        mRightButton.setText(mRightText);

        mTitleView.setTextColor(mTitleColor);
        mTitleView.setTextSize(mTitleTextSize);
        mTitleView.setText(mTitlecontent);
        mTitleView.setGravity(Gravity.CENTER);

        mLeftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        addView(mLeftButton, mLeftParams);

        mRightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(mRightButton, mRightParams);

        mTitleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(mTitleView, mTitleParams);

        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.leftClick();
            }
        });

        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.rightClick();
            }
        });

    }

    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
    }

    public interface topbarClickListener{
        void leftClick();
        void rightClick();
    }

    public void setmClickListener(topbarClickListener mClickListener){
        this.mClickListener=mClickListener;
    }

    public void setButtonVisibility(int id,boolean flag){
        if(flag){
            if(id==0){
                mLeftButton.setVisibility(View.VISIBLE);
            }else{
                mRightButton.setVisibility(View.VISIBLE);
            }

        }else{
            if(id==0){
                mLeftButton.setVisibility(View.GONE);
            }else{
                mRightButton.setVisibility(View.GONE);
            }
        }
    }


}
