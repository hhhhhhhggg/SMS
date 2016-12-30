package com.jfq.msms.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jfq.msms.R;
import com.jfq.msms.adapter.ModeAdapter;
import com.jfq.msms.bean.Mode;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 会员商场主页页面
 * Created by LYP on 2016.12.27.
 */

public class Fragment2 extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
    //会员商城URL
    private static final String PATH ="http://www.ysapp.cn/jifenqian/api.php/Mall/productList1";
    View view;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    int now_page=1;
    List<Mode> lists = new ArrayList<>();
    ModeAdapter modeAdapter;
    LinearLayoutManager linearLayoutManager;
    int lastVisibaleItem = 0;
    ProgressDialog progressDialog;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("onAttach","==onAttach===");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment2_layout,null);
        initView();
        return view;
    }

    public void initView() {
       recyclerView = (RecyclerView) view.findViewById(R.id.my_recyclerView);
       swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.my_SwipRefreshLayout);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("---------","onActivityCreated");
        initData();

        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(Color.GREEN,Color.BLUE,Color.BLACK);

        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        modeAdapter = new ModeAdapter(getActivity(),lists);
        recyclerView.setAdapter(modeAdapter);
        setOnClick();

        /**
         *RecyclerView设置滑动监听，如果滑动到底部，继续加载
         */
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState ==RecyclerView.SCROLL_STATE_IDLE
                        && lastVisibaleItem+1 == modeAdapter.getItemCount()){
                        now_page++;
                        initData();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibaleItem = linearLayoutManager.findLastVisibleItemPosition();
            }
        });

    }


    /**
     * recyclerview设置点击事件
     */

    public void setOnClick() {
        Log.e("点击事件","====");
        modeAdapter.setOnItem(new ModeAdapter.MyInto() {
            @Override
            public void newsdetial(View view, String tag) {
                showDialog();
                Log.e("我点的是：","==="+tag);
            }
        });
    }


    /**
     * 点击显示进度条
     */
    public void showDialog() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("正在加载，请稍后...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 100:
                    swipeRefreshLayout.setRefreshing(false);
                    modeAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };

    /**
     * 初始化数据源
     */
    public void initData() {
        OkHttpUtils.post(PATH)
                .params("integral1",0)
                .params("price1",0)
                .params("order",1)
                .params("page_size",10)
                .params("integral2",0)
                .params("cid",192)
                .params("price2",0)
                .params("now_page",now_page)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        String s1 = s.substring(2);
                        jiexi(s1);
                        Log.e("info","====请求的数据==="+s1+"");
                    }
                });
    }

    /**
     * 解析数据
     */

    public void jiexi(String s1) {
        JSONObject jsdata = null;
        try {
            jsdata = new JSONObject(s1);
            JSONArray jsonArray = jsdata.getJSONArray("data");
            for (int i = 0; i <jsonArray.length(); i++) {
                Mode mode = new Mode();
                JSONObject jsonObject = jsonArray.optJSONObject(i);
                mode.setProduct_id(jsonObject.optString("product_id"));
                mode.setName(jsonObject.optString("name"));
                mode.setPricex(jsonObject.optString("pricex"));
                mode.setPricey(jsonObject.optString("pricey"));
                mode.setHeadpic(jsonObject.optString("headpic"));


                lists.add(mode);
                Log.i("info","===="+lists.size());
                 //modeAdapter.notifyDataSetChanged();

            }
              handler.sendEmptyMessage(100);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        lists.clear();
        now_page=1;
        initData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * 刷新
     */
    @Override
    public void onRefresh() {
        lists.clear();
        now_page=1;
        initData();
    }
}
