package com.example.recyclerview.RecyclerViewClasses;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;

public class ViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView textView;

    public ViewHolder(View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageView1);
        textView = itemView.findViewById(R.id.nameView);
    }
}
