package com.bawei.viewpagerrec.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.viewpagerrec.R;
import com.bawei.viewpagerrec.bean.DataBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/11 0011.
 */
public class Myname extends RecyclerView.Adapter<Myname.MyViewHolder>{
    private ArrayList<DataBean.Data> mDatas;
    private Context context;

    public Myname(ArrayList<DataBean.Data> mDatas, Context context) {
        this.mDatas = mDatas;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
        View v = View.inflate(context, R.layout.recy_item, null);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(mDatas.get(position).efficacy);
        ImageLoader.getInstance().displayImage(mDatas.get(position).goods_img,
                holder.iv);
    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int possion);
    }
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;
    public void setOnItemClickListener(OnRecyclerViewItemClickListener
                                               listener) {
        this.mOnItemClickListener = listener;
    }




    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv;
        ImageView iv;

        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.tv_recy);
            iv = (ImageView) view.findViewById(R.id.iv_recy);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                //主要要在点击事件里面得到以下数据
                mOnItemClickListener.onItemClick(v, getPosition());
            }
        }
    }
}


