package com.example.meloncrawling.RecyclerPackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.meloncrawling.Dto.MusicDto;
import com.example.meloncrawling.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<MusicDto> musicList = null;

    public RecyclerAdapter(List<MusicDto> musicList){
        this.musicList = musicList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleView.setText(musicList.get(position).getTitle());
        holder.singerView.setText(musicList.get(position).getSinger());
        holder.albumView.setText(musicList.get(position).getAlbum());

        Glide.with(holder.itemView).load(musicList.get(position).getImgSoruce())
                .override(200, 200)
                .into(holder.coverView);
    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }
}
