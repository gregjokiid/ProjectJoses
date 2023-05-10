package com.example.latihanuts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListHeroAdapter extends RecyclerView.Adapter<ListHeroAdapter.ListViewHolder> {
    private ArrayList<Hero> listHero;

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback{
        void onItemClicked(Hero data);
    }
    public ListHeroAdapter(ArrayList<Hero> list){
        this.listHero = list;
    }

    @NonNull
    @Override
    public ListHeroAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_hero,parent,false);
        return new
                ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHeroAdapter.ListViewHolder holder, int position) {
        Hero hero = listHero.get(position);
        holder.imgPhoto.setImageResource(hero.getPhoto());
        holder.tvName.setText(hero.getName());
        holder.tvDesc.setText(hero.getDescription());
        holder.itemView.setOnClickListener(v -> onItemClickCallback.onItemClicked(listHero.
                get(holder.getAdapterPosition())));

    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDesc;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDesc = itemView.findViewById(R.id.tv_item_description);
        }
    }
}
