package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdminRecyclerViewAdapter extends RecyclerView.Adapter<AdminRecyclerViewAdapter.ViewHolder> {
    Context context;
    ArrayList<AdminDoc> adminDocList;

    public AdminRecyclerViewAdapter(Context context, ArrayList<AdminDoc> adminDocList) {
        this.context = context;
        this.adminDocList = adminDocList;
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivDoc;
        TextView tvCurrentViewers,tvPastViewers;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivDoc=itemView.findViewById(R.id.ivDoc);
            tvCurrentViewers=itemView.findViewById(R.id.tvCurrentViewers);
            tvPastViewers=itemView.findViewById(R.id.tvPastViewers);
        }
    }

    @NonNull
    @Override
    public AdminRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_item_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(adminDocList.get(position));
        Glide.with(context).load(adminDocList.get(position).getDocUrl()).into(holder.ivDoc);
        holder.tvCurrentViewers.setText(adminDocList.get(position).getCurrentViewers());
        holder.tvPastViewers.setText(adminDocList.get(position).getPastViewers());
    }

    @Override
    public int getItemCount() {
        return adminDocList.size();
    }
}
