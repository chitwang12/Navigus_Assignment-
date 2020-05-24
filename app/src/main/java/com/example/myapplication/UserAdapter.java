package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private ArrayList<UserList> userLists;
    private Context context;

    public UserAdapter(ArrayList<UserList> userLists, Context context) {
        this.userLists = userLists;
        this.context = context;
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivDocUser;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivDocUser=itemView.findViewById(R.id.ivDocUser);
        }
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.user_item_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(userLists.get(position));
        Glide.with(context).load(userLists.get(position).getUserDocUrl()).into(holder.ivDocUser);
    }

    @Override
    public int getItemCount() {
        return userLists.size();
    }
}
