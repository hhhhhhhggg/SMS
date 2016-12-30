package com.jfq.msms.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jfq.msms.R;
import com.jfq.msms.bean.Mode;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by lyp13 on 2016/12/29.
 */

public class ModeAdapter extends RecyclerView.Adapter{

    private View view;
    Context context;
    List<Mode> list;
    LayoutInflater inflater;
    static final int FOOTER =1; //底部
    static final int NOFOOTER =0;
    MyInto myInto;

    public ModeAdapter(Context context, List<Mode> list) {
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getItemViewType(int position) {
         if (position+1==getItemCount()){
             //说明需要显示加载
             return FOOTER;
         }else {
             return NOFOOTER;
         }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==NOFOOTER){   //没有到底部
            view = inflater.inflate(R.layout.fragment2_item,null);
            /**
             * 给每一项item添加点击事件
             */
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myInto.newsdetial(v, (String) v.getTag());
                }
            });

            return new MyViewHolder(view);
        }else if (viewType==FOOTER){  //加载到了底部
            View view = inflater.inflate(R.layout.fragment2_footerview,null);
            return new MyFooter(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof MyViewHolder){
            Picasso.with(context)
                    .load(list.get(position).getHeadpic())
                    .into((ImageView)holder.itemView.findViewById(R.id.iv_image));

            TextView tv_name = (TextView) holder.itemView.findViewById(R.id.tv_name);
            tv_name.setText(list.get(position).getName());
            TextView tv_now_price = (TextView) holder.itemView.findViewById(R.id.tv_now_price);
            tv_now_price.setText(list.get(position).getPricex());
            TextView tv_origin_price = (TextView) holder.itemView.findViewById(R.id.tv_origin_price);
            tv_origin_price.setText(list.get(position).getPricey());
            holder.itemView.setTag(position+"");
        }
    }

    @Override
    public int getItemCount() {
        return list.size()+1;
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
    /**
     * 加载条的Viewholder
     */
    //这个是加载条的viewholder
    class MyFooter extends RecyclerView.ViewHolder{
        public MyFooter(View itemView) {
            super(itemView);
        }
    }
    public void setOnItem(MyInto myInto)
    {
        this.myInto=myInto;
    }

    public interface MyInto{
        void  newsdetial(View view,String tag);
    }
}
