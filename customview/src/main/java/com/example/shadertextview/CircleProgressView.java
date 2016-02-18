package com.example.shadertextview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

/**
 * Created by zhangxin on 16/2/18.
 */
public class CircleProgressView extends View {
    private Paint mPaint;
    private float mCircleXY;
    private float mRadius;
    private String mShowText;
    private Paint mTextPaint;
    private Paint mArcPaint;
    private RectF mArcRectF;
    private String TAG="CircleProgressView";
    public CircleProgressView(Context context) {
        this(context,null);
    }

    public CircleProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initValue();
    }

    public CircleProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //初始化参数值

    public void initValue(){
        mShowText="android skill";

        mPaint=new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);

        mTextPaint=new Paint();
        mTextPaint.setColor(Color.BLACK);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(40);

        mArcPaint=new Paint();
        mArcPaint.setColor(Color.BLUE);
        mArcPaint.setAntiAlias(true);
        mArcPaint.setStyle(Paint.Style.STROKE);
        mArcPaint.setStrokeWidth(10);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthSize=MeasureSpec.getSize(widthMeasureSpec);
        int heightSize=MeasureSpec.getSize(heightMeasureSpec);

        mArcRectF=new RectF((float) (widthSize*0.1),(float) (widthSize*0.1),(float)(widthSize*0.9),(float) (widthSize*0.9));

        mCircleXY=widthSize/2;
        mRadius=(float) (widthSize/4);
        setMeasuredDimension(widthMeasureSpec,heightMeasureSpec);
        Log.e(TAG,"widthSize-->"+widthSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画椭圆
        canvas.drawArc(mArcRectF,270,270,false,mArcPaint);
        //画圆
        canvas.drawCircle(mCircleXY,mCircleXY,mRadius,mPaint);
        //画字
        canvas.drawText(mShowText,0,mShowText.length(),mCircleXY,mCircleXY,mTextPaint);
        //canvas.save();
    }

    private int measureWidth(int measureSpec){
        int result=0;
        int widthMode=MeasureSpec.getMode(measureSpec);
        int specWidthSize=MeasureSpec.getSize(measureSpec);
        if(widthMode==MeasureSpec.EXACTLY){
            result=specWidthSize;
        }else{
            result=40;
        }
        return result;
    }

    private int measureHeight(int measureSpec){
        int result=0;
        int heightMode=MeasureSpec.getMode(measureSpec);
        int speHeightSize=MeasureSpec.getSize(measureSpec);
        if(heightMode==MeasureSpec.EXACTLY){
            result=speHeightSize;
        }else{
            result=40;
        }
        return result;
    }
}
