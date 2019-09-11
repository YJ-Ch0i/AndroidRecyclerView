package com.example.recyclerview.RecyclerViewClasses;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;
import com.example.recyclerview.Data.Data;
import com.example.recyclerview.Data.Person;
import com.example.recyclerview.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<Person> data = null;

    public RecyclerAdapter(ArrayList<Person> dataList) {
        this.data = dataList;
    }

    @Override   //아이템뷰를 관리하는 ViewHolder 객체 생성
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

//        Context context = parent.getContext();
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //View view = inflater.inflate(R.layout.card_view, parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override   //index에 해당하는 데이터를 ViewHolder가 관리하는 View에 바인딩
    public void onBindViewHolder(ViewHolder viewHolder, int index){
        viewHolder.imageView.setImageResource(data.get(index).getImageId());
        viewHolder.textView.setText(data.get(index).getName());
    }

    @Override   //Adapter가 관리하고 있는 데이터 집합의 전체 개수 리턴
    public int getItemCount(){
        return data.size();
    }
}
