package com.mahfuz.movietune.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mahfuz.movietune.activity.DetailActivity;
import com.mahfuz.movietune.activity.MainActivity;
import com.mahfuz.movietune.R;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

/**
 * Created by mahfuz on 7/1/18.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    Context mContext;
    List<String> imageUrls = Collections.emptyList();
    List<String> ids = Collections.emptyList();
    boolean notDetailsActivity;

    public RecyclerAdapter(Context context, List<String> id, List<String> poster_path,boolean notDetailsActivity) {
        this.mContext = context;
        Log.d(MainActivity.sTAG, "RecyclerAdapter: "+mContext);
        this.ids = id;
        this.imageUrls = poster_path;
        this.notDetailsActivity = notDetailsActivity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;

        if (!notDetailsActivity){
            view = LayoutInflater.from(mContext).inflate(R.layout.custom_layout_two,parent,false);
        }else{
            view = LayoutInflater.from(mContext).inflate(R.layout.custom_row,parent,false);
        }


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Picasso.with(mContext).load(imageUrls.get(position)).into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return imageUrls.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView mImageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.imageView);
            mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext,DetailActivity.class);
                    intent.putExtra("id",ids.get(getPosition()));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
