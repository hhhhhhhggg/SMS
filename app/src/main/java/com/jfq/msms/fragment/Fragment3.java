package com.jfq.msms.fragment;

import android.content.Context;
import android.content.SharedPreferences;
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
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by Administrator on 2016.12.27.
 */

public class Fragment3 extends Fragment {
    View view;
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

        personage_head.setBackgroundResource(R.drawable.head_view);

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
                .execute(new GsonCallback<Myselfcenter>() {
                    @Override
                    public void onError(Call call, Exception e) {
                        Toast.makeText(getActivity(), "请求失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(Call call, Myselfcenter myselfcenter) {
                        if (myselfcenter != null) {
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

    public void setdata() {
        personage_head = (ImageView) view.findViewById(R.id.personage_head);
        personage_name.setText(name);
        personage_vip.setText(ordinary);
        personage_manage1.setText(cart_num);
        personage_manage2.setText(integral_num);
        personage_manage3.setText(adress_num);
        if (isSign == 2) {
            personage_sign.setText("已签到");
        }else {
            personage_sign.setText("未签到");
        }
        Glide.with(getActivity())
                .load(photo)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(personage_head);
    }
}
