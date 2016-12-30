package com.jfq.msms.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.jfq.msms.R;

/**
 * Created by lyp13 on 2016/12/30.
 * 分类筛选试图自定义控件
 */

public class FilterView extends LinearLayout implements View.OnClickListener{
    Context mContext;
    View mView;
    View divider_line;  //titlbar与listview的分割线
    LinearLayout all_listView;  //listview
    LinearLayout catagrey;  //分类
    LinearLayout sort;   //排序
    LinearLayout select;   //筛选
    int spinnerPosition = -1;  //下拉试图的位置
    private OnSpinnerListener onSpinnerListener;  //下拉试图的点击监听


    public FilterView(Context context) {
        super(context);
        init(context);
    }

    public FilterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        mView = LayoutInflater.from(context).inflate(R.layout.fragment2_head_layout,this);

        initView();
        initListener();
    }


    public void initView() {
        divider_line.setVisibility(GONE);
        all_listView.setVisibility(GONE);
    }

    public void initListener() {
        catagrey.setOnClickListener(this);
        sort.setOnClickListener(this);
        select.setOnClickListener(this);
        all_listView.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.category:
                spinnerPosition = 0;
                if (onSpinnerListener!=null){
                    onSpinnerListener.OnSpinnerClick(spinnerPosition);
                }
                break;
            case R.id.sort:
                if (onSpinnerListener!=null){
                    onSpinnerListener.OnSpinnerClick(spinnerPosition);
                }
                break;
            case R.id.select:
                if (onSpinnerListener!=null){
                    onSpinnerListener.OnSpinnerClick(spinnerPosition);
                }
                break;
        }
    }


    public interface  OnSpinnerListener{
        void OnSpinnerClick(int position);
    }
}
