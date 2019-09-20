package com.example.meloncrawling.RecyclerPackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.meloncrawling.R;

import org.w3c.dom.Text;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView titleView;
    TextView singerView;
    TextView albumView;
    ImageView coverView;

    public ViewHolder(View itemView){
        super(itemView);

        titleView = itemView.findViewById(R.id.titleView);
        singerView = itemView.findViewById(R.id.singerView);
        albumView = itemView.findViewById(R.id.albumView);
        coverView = itemView.findViewById(R.id.coverView);
    }
}
