package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class UserPanel extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<UserList> userDocArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_panel);

        userDocArrayList=new ArrayList<>();

        userDocArrayList.add(new UserList(""));
        userDocArrayList.add(new UserList(""));
        userDocArrayList.add(new UserList(""));
        userDocArrayList.add(new UserList(""));

        //Fetch From firebase

        recyclerView=findViewById(R.id.rvUser);
        layoutManager=new LinearLayoutManager(UserPanel.this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new UserAdapter(userDocArrayList,this);
        recyclerView.setAdapter(adapter);
    }
}
