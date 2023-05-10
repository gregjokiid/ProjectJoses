package com.joses.uts.adapter;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.joses.uts.R;
import com.joses.uts.model.News;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<com.joses.uts.adapter.NewsAdapter.ListViewHolder> {
    private com.joses.uts.adapter.NewsAdapter.OnItemClickCallBack onItemClickCallBack;

    public void setOnItemClickCallBack(com.joses.uts.adapter.NewsAdapter.OnItemClickCallBack onItemClickCallBack){
        this.onItemClickCallBack = onItemClickCallBack;
    }

    private final ArrayList<News> newsList;

    public NewsAdapter(ArrayList<News> list){
        this.newsList = list;
    }

    @NonNull
    @Override
    public com.joses.uts.adapter.NewsAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_news, viewGroup, false);
        return new com.joses.uts.adapter.NewsAdapter.ListViewHolder(view);
    }

    @SuppressLint("WrongConstant")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull final com.joses.uts.adapter.NewsAdapter.ListViewHolder holder, int position) {
        News news = newsList.get(position);
        Glide.with(holder.itemView.getContext())
                .load((news.getNewsImage()))
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);
        holder.tvName.setText(news.getNewsTitle());
        holder.tvDetail.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
        holder.tvDetail.setText(news.getNewsDetail());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onItemClickCallBack.onItemClicked(newsList.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
        }
    }

    public interface OnItemClickCallBack {
        void onItemClicked(News data);
    }
}
