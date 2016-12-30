package com.jfq.msms.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jfq.msms.R;
import com.jfq.msms.bean.Myselfcenter;
import com.jfq.msms.url.URLs;
import com.jfq.msms.utils.GsonCallback;
import com.jfq.msms.view.GlideCircleTransform;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by Administrator on 2016.12.27.
 */

public class Fragment3 extends Fragment {
    private View view;
    private ImageView personage_head;
    private TextView personage_name, personage_vip, personage_manage1, personage_manage2, personage_manage3, personage_sign;
    private SharedPreferences share;
    private String token;
    private String uid;
    private String ordinary;//会员
    private int isSign;//是否签到
    private String adress_num;//收货地址
    private String integral_num;//积分
    private String photo;//头像地址
    private String name;//名字
    private String cart_num;//购物车数量
    private TextView myself_tv1, myself_tv2, myself_tv3, myself_tv4, myself_tv5, myself_tv6, myself_tv7, myself_tv8;//需要设置图片的textview


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment3_layout, container, false);
        init();
        getdata();

        return view;
    }

    //初始化
    public void init() {
        personage_head = (ImageView) view.findViewById(R.id.personage_head);
        personage_name = (TextView) view.findViewById(R.id.personage_name);
        personage_vip = (TextView) view.findViewById(R.id.personage_vip);
        personage_manage1 = (TextView) view.findViewById(R.id.personage_manage1);
        personage_manage2 = (TextView) view.findViewById(R.id.personage_manage2);
        personage_manage3 = (TextView) view.findViewById(R.id.personage_manage3);
        personage_sign = (TextView) view.findViewById(R.id.personage_sign);

        myself_tv1 = (TextView) view.findViewById(R.id.myself_tv1);
        myself_tv2 = (TextView) view.findViewById(R.id.myself_tv2);
        myself_tv3 = (TextView) view.findViewById(R.id.myself_tv3);
        myself_tv4 = (TextView) view.findViewById(R.id.myself_tv4);
        myself_tv5 = (TextView) view.findViewById(R.id.myself_tv5);
        myself_tv6 = (TextView) view.findViewById(R.id.myself_tv6);
        myself_tv7 = (TextView) view.findViewById(R.id.myself_tv7);
        myself_tv8 = (TextView) view.findViewById(R.id.myself_tv8);

        personage_head.setBackgroundResource(R.drawable.head_view);
        setimgtoleft(R.drawable.dingdan, myself_tv1);
        setimgtotop(R.drawable.daifukuan_btn, myself_tv2);
        setimgtotop(R.drawable.daifahuo_btn, myself_tv3);
        setimgtotop(R.drawable.daishouhuo_btn, myself_tv4);
        setimgtotop(R.drawable.daituikuan_btn, myself_tv5);
        setimgtoleft(R.drawable.my_shop_car, myself_tv6);
        setimgtoleft(R.drawable.my_point, myself_tv7);
        setimgtoleft(R.drawable.my_location, myself_tv8);

        //获取sharepreferences的数据
        share = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        token = share.getString("token", "");
        uid = share.getString("id", "");
    }

    //下载解析json
    public void getdata() {
        OkHttpUtils.post()
                .url(URLs.BASE_URL + URLs.USER + URLs.MY_SELF)
                .addParams("token", token)
                .addParams("uid", uid)
                .build()
                .execute(new GsonCallback<Myselfcenter>() {//自定义的接口回调
                    @Override
                    public void onError(Call call, Exception e) {
                        Toast.makeText(getActivity(), "请求失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(Call call, Myselfcenter myselfcenter) {
                        if (myselfcenter != null) {//返回值不为空时候获取具体值
                            ordinary = myselfcenter.getOrdinary();
                            isSign = myselfcenter.getIsSign();
                            adress_num = myselfcenter.getAdress_num();
                            integral_num = myselfcenter.getIntegral_num();
                            photo = myselfcenter.getPhoto();
                            name = myselfcenter.getName();
                            cart_num = myselfcenter.getCart_num();
                            setdata();
                        }
                    }
                });
    }

    //设置UI
    public void setdata() {
        personage_name.setText(name);
        personage_vip.setText(ordinary);
        personage_manage1.setText(cart_num);
        personage_manage2.setText(integral_num);
        personage_manage3.setText(adress_num);
        if (isSign == 2) {//判断是不是签过的到
            personage_sign.setText("已签到");
        } else {
            personage_sign.setText("未签到");
        }
        //Glide下载头像
        Glide.with(getActivity())
                .load(photo)
                .transform(new GlideCircleTransform(getActivity()))//自定义下载头像为圆形
                .placeholder(R.mipmap.ic_launcher)//没有下载完成时展示的图片
                .error(R.mipmap.ic_launcher)//下载失败展示的图片
                .into(personage_head);
    }


    //设置文字左面图片的大小

    /**
     *
     * @param res 图片资源文件
     * @param tv view文件
     */
    public void setimgtoleft(int res, TextView tv) {
        Drawable drawable = getResources().getDrawable(res);//转化图片资源文件为Drawable
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth() / 2, drawable.getIntrinsicHeight() / 2);//设置图片为原图的50%
        tv.setCompoundDrawables(drawable, null, null, null);//图片在文字的方位，参数代表左上右下
    }

    /**
     *
     * @param res 图片资源文件
     * @param tv view文件
     */
    //设置文字上面图片大小
    public void setimgtotop(int res, TextView tv) {
        Drawable drawable = getResources().getDrawable(res);//转化图片资源文件为Drawable
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth() * 3/ 4, drawable.getIntrinsicHeight() *3 / 4);//设置图片为原图的75%
        tv.setCompoundDrawables(null, drawable, null, null);//图片在文字的方位，参数代表左上右下
    }
}
