package com.example.shadertextview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by zhangxin on 16/2/17.
 */
public class RectTextView extends TextView {
    public RectTextView(Context context) {
        super(context);
    }

    public RectTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RectTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint mPaint1=new Paint();
        mPaint1.setColor(Color.RED);
        mPaint1.setStyle(Paint.Style.FILL);
        Paint mPaint2=new Paint();
        mPaint2.setColor(Color.WHITE);
        mPaint2.setStyle(Paint.Style.FILL);
        canvas.drawRect(0,0,getMeasuredWidth()+20,getMeasuredHeight()+20,mPaint1);

        canvas.drawRect(10,10,getMeasuredWidth()-10,getMeasuredHeight()-10,mPaint2);

        canvas.save();
       // canvas.translate(10,0);
        super.onDraw(canvas);
        canvas.restore();
    }
}
