package com.example.topbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by zhangxin on 16/2/17.
 */
public class CustomTopBar extends RelativeLayout {
    private String mTitleText;
    private float mTitleTextSize;
    private int mTitleTextColor;

    private int mLeftTextColor;
    private int mLeftBackground;
    private float mLeftTextSize;
    private String mLeftText;

    private int mRightTextColor;
    private int mRightBackground;
    private float mRightTextSize;
    private String mRightText;

    private Button mLeftButton;
    private Button mRightButton;
    private TextView mTitleTextView;
    private LayoutParams params;
    public CustomTopBar(Context context) {
        super(context);
    }

    public CustomTopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }

    public CustomTopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView(Context context,AttributeSet atts){
        TypedArray ta = context.obtainStyledAttributes(atts, R.styleable.CustomTopBar);
        //从TypedArray中取出对应的值来为要设置的属性赋值
        mTitleText=ta.getString(R.styleable.CustomTopBar_mYtitle);
        mTitleTextSize=ta.getDimension(R.styleable.CustomTopBar_mYtitleTextSize,10);
        mTitleTextColor=ta.getColor(R.styleable.CustomTopBar_mYtitleTextColor,0);

        mLeftText=ta.getString(R.styleable.CustomTopBar_mYleftText);
        mLeftTextColor=ta.getColor(R.styleable.CustomTopBar_mYleftTextColor,0);
        mLeftBackground=ta.getColor(R.styleable.CustomTopBar_mYleftBackground,0);
        mLeftTextSize=ta.getDimension(R.styleable.CustomTopBar_mYleftTextSize,10);

        mRightText=ta.getString(R.styleable.CustomTopBar_mYrightText);
        mRightTextColor=ta.getColor(R.styleable.CustomTopBar_mYrightTextColor,0);
        mRightBackground=ta.getColor(R.styleable.CustomTopBar_mYrightBackground,0);
        mRightTextSize=ta.getDimension(R.styleable.CustomTopBar_mYrightTextSize,10);
        //获取完TypedArray的值后，一般要调用recyle方法来避免重新创建的时候的错误。
        ta.recycle();

        mLeftButton=new Button(context);
        mRightButton=new Button(context);
        mTitleTextView=new TextView(context);

        mLeftButton.setText(mLeftText);
        mRightButton.setText(mRightText);
        mTitleTextView.setText(mTitleText);

        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        addView(mLeftButton,params);

        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        addView(mRightButton,params);

        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        mTitleTextView.setGravity(Gravity.CENTER);
        addView(mTitleTextView,params);

        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.leftClick();
            }
        });

        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.rightClick();
            }
        });
    }
    //定义接口
    public interface topbarClickListener{
        //左按钮事件
        void leftClick();
        //右按钮事件
        void rightClick();
    }

    public topbarClickListener mListener;

    public void setOnTopbarClickListener(topbarClickListener mListener){
        this.mListener=mListener;
    }
    //id区分显示哪一个，0是左按钮显示，右按钮不显示，flag区分是否显示,true显示
    public void setButtonVisibility(int id,boolean flag){
        if(flag){
            if(id==0){
                mLeftButton.setVisibility(View.VISIBLE);
                mRightButton.setVisibility(View.GONE);
            }else if(id==1){
                mLeftButton.setVisibility(View.GONE);
                mRightButton.setVisibility(View.VISIBLE);
            }else{
                mLeftButton.setVisibility(View.VISIBLE);
                mRightButton.setVisibility(View.VISIBLE);
            }
        }else{
                mLeftButton.setVisibility(View.GONE);
                mRightButton.setVisibility(View.GONE);
        }
    }
}
