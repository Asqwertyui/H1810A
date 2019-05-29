package com.ks.day02.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.ks.day02.R;
import com.ks.day02.bean.Bean;

import java.util.ArrayList;

/**
 * Created by F0519 on 2019/5/29.
 */

public class Myadaoter extends RecyclerView.Adapter<Myadaoter.ViewHolder> {
    private ArrayList<Bean.RecentBean> mRecentBeans;
    private Context context;

    public Myadaoter(ArrayList<Bean.RecentBean> recentBeans, Context context) {
        mRecentBeans = recentBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Bean.RecentBean bean = mRecentBeans.get(position);
        holder.tv.setText(bean.getTitle());
        if(position%3==0){
            RoundedCorners corners = new RoundedCorners(30);
            RequestOptions options = RequestOptions.bitmapTransform(corners);
            Glide.with(context).load(bean.getThumbnail()).apply(options).into(holder.iv);
        }else {
            RequestOptions options = new RequestOptions().circleCrop();
            Glide.with(context).load(bean.getThumbnail()).apply(options).into(holder.iv);
        }
    }

    @Override
    public int getItemCount() {
        return mRecentBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        private ImageView iv;
        public ViewHolder(View itemView) {
            super(itemView);
          tv=  itemView.findViewById(R.id.tv);
            iv=itemView.findViewById(R.id.iv);
        }
    }
}
