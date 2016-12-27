package com.jfq.msms;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    ViewPager myViewPager;
    RadioGroup myRadioGroup;
    RadioButton index,member,me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    //初始化操作
    public void init() {
         myViewPager = (ViewPager) findViewById(R.id.myViewPager);
         myRadioGroup = (RadioGroup) findViewById(R.id.myRadioGroup);
         index = (RadioButton) findViewById(R.id.index);
         member = (RadioButton) findViewById(R.id.member);
         me = (RadioButton) findViewById(R.id.me);
         //初始化数据
         initData();


    }


    public void initData() {

    }


}
