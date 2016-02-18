package com.example.zhangxin.mywidget;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.example.topbar.CustomTopBar;

public class MainActivity extends Activity {
    private CustomTopBar customTopBar;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;
        customTopBar=(CustomTopBar)findViewById(R.id.ctbar);
        customTopBar.setOnTopbarClickListener(new CustomTopBar.topbarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(mContext,"点击了左边按钮",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(mContext,"点击了右边按钮",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
