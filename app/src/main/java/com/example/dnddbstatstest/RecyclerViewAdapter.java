package com.example.dnddbstatstest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    List<CharSheet> charSheets;

    public RecyclerViewAdapter(List<CharSheet> charSheets) {
        this.charSheets = charSheets;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView listNameView;
        TextView listIDView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            listNameView = itemView.findViewById(R.id.listNameView);
            listIDView = itemView.findViewById(R.id.listIDView);
        }

        public TextView getListNameView() {
            return listNameView;
        }

        public TextView getListIDView() {
            return listIDView;
        }
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_list,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.listNameView.setText(charSheets.get(position).getName());
        holder.listIDView.setText(Integer.toString(charSheets.get(position).getId()));

    }

    @Override
    public int getItemCount() {
        return charSheets.size();
    }


}
