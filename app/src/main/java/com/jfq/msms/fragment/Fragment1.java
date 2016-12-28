package com.jfq.msms.fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.jfq.msms.R;
import com.jfq.msms.adapter.MyAdAdapter;
import com.jfq.msms.bean.Adbean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.jfq.msms.utils.GsonCallback;
import java.util.ArrayList;
import java.util.List;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;
import okhttp3.Call;
import okhttp3.Response;

public class Fragment1 extends Fragment {
    AutoScrollViewPager autoScrollViewPager;
    LinearLayout layout_points;
    private String vperPath = "http://api.ipadown.com/iphone-client/ad.flash.php?count=5";
    private String vperPath1 = "http://www.ysapp.cn/jifenqian/api.php/Mall/homeBanner";
    private List<Adbean.DataBean> pager = new ArrayList<>();
    //ptrlistview 请求地址，以及数据源
    private PullToRefreshListView listView;
    private MyAdAdapter myAdAdapter;
    public Fragment1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.layout_home_adhead,null);

        autoScrollViewPager= (AutoScrollViewPager) view.findViewById(R.id.hdviewPager);
        layout_points= (LinearLayout) view.findViewById(R.id.layoutIcons);
        getdata();
        autoScrollViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                Log.i("=====","----"+position);
                //根据布局容器得到其中的所有child
                if (pager.size() != 0) {
                    //根据布局容器得到其中的所有child
                    int count = layout_points.getChildCount();
                    for (int i = 0; i < count; i++) {
                        ImageView imgPoint = (ImageView) layout_points.getChildAt(i);
                        if (i == position) {
                            imgPoint.setImageResource(R.drawable.perssed_point);
                        } else {
                            imgPoint.setImageResource(R.drawable.default_point);
                        }
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return view;
    }
    //设置广告图片
    private void setHead() {
        List<View> views = new ArrayList<>();
        Log.i("=dada==","===="+pager.size()+""+"===");

        for (int i = 0; i < pager.size(); i++) {
            Log.i("=dadada==","===="+pager.size()+""+"==="+pager.get(i).getPic());
            //加载原图

            ImageView img = new ImageView(getContext());
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Glide.with(getContext())
                    .load(pager.get(i).getPic())
                    .placeholder(R.mipmap.ic_launcher)
                    .into(img);
            views.add(img);


            //加载原点(指示器)
            ImageView imgPoint = new ImageView(getContext());

            //默认选中第一个
            if (i == 0) {
                imgPoint.setImageResource(R.drawable.perssed_point);
            } else {
                imgPoint.setImageResource(R.drawable.default_point);
            }
            imgPoint.setPadding(5, 0, 5, 0);

            layout_points.addView(imgPoint);
        }

        myAdAdapter =  new MyAdAdapter(views);
        autoScrollViewPager.setAdapter(myAdAdapter);
        //启动自动轮播功能
        autoScrollViewPager.startAutoScroll();
        //手触摸停止自动滚动，一旦手放开继续自动滑动；默认开启的；
        autoScrollViewPager.setStopScrollWhenTouch(true);
        //默认循环轮播
        autoScrollViewPager.setCycle(true);
        //设置图片轮播的间隔时间
        autoScrollViewPager.setInterval(2000);
    }

    private  void getdata(){
        pager.clear();
        OkHttpUtils.post()
                .url(vperPath1)
                .addParams("cid", "0")
                .build()
                .execute(new GsonCallback<Adbean>() {
                    @Override
                    public void onError(Call call, Exception e) {
                        Log.e("hhh", "GsonCallback error==" + e.getMessage());
                        Toast.makeText(getContext(), "  请求失败，" + e.getMessage(), Toast.LENGTH_LONG).show();
                        //ptrlv_comments.onRefreshComplete();
                        Log.i("=dadada==","===="+"shibai");
                    }
                    @Override
                    public void onResponse(Call call, Adbean response) {
                        if (response != null) {
                            //resultData = response;
                            Log.e("hhh", "resultData==" + pager.toString());

                            pager.addAll(response.getData());
                           // pager.clear();
                            setHead();
                            Log.i("=dadada==","===="+"成功");
                        } else {
                            Log.e("hhh", "response is null");
                        }
                    }
                });
    }



}

