package com.jfq.msms;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jfq.msms.adapter.MyAdapter;
import com.jfq.msms.fragment.Fragment1;
import com.jfq.msms.fragment.Fragment2;
import com.jfq.msms.fragment.Fragment3;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AutoLayoutActivity {
    ViewPager myViewPager;
    RadioGroup myRadioGroup;
    RadioButton index,member,me;
    List<Fragment> lists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //AutoLayoutConifg.getInstance().useDeviceSize();
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
        //给radiubutton设置点击事件
        setRadiuButton();
         //viewpager的适配器
         setViewPagerAdapter();
    }

    /**
     * 给radiubutton设置点击事件
     */
    private void setRadiuButton() {
        myRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (group.getCheckedRadioButtonId()){
                    case R.id.index:  //选中首页
                        switchPage(0);
                        break;
                    case R.id.member: //选中会员商城
                        switchPage(1);
                        break;
                    case R.id.me:   //选中我的
                        switchPage(2);
                        break;
                }
            }
        });
    }

    /**
     * 点击切换按钮
     */
    public void switchPage(int position) {
        myViewPager.setCurrentItem(position);
        myViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        index.setChecked(true);
                        break;
                    case 1:
                        member.setChecked(true);
                        break;
                    case 2:
                        me.setChecked(true);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    /**
     * 给viewpager设置适配器
     */
    public void setViewPagerAdapter() {
        myViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
    }

    /**
     * 设置viewpager的数据源
     */
    public void initData() {
        Fragment1  fg1 = new Fragment1();
        lists.add(fg1);

        Fragment2 fg2 = new Fragment2();
        lists.add(fg2);

        Fragment3 fg3 = new Fragment3();
        lists.add(fg3);
    }

}
