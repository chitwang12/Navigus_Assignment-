package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class AdminPanel extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<AdminDoc> adminDocArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        adminDocArrayList=new ArrayList<>();

        adminDocArrayList.add(new AdminDoc("",3,0));
        adminDocArrayList.add(new AdminDoc("",5,0));
        adminDocArrayList.add(new AdminDoc("",1,1));
        adminDocArrayList.add(new AdminDoc("",3,10));
        //Fetch From firebase

        recyclerView=findViewById(R.id.rvAdmin);
        layoutManager=new LinearLayoutManager(AdminPanel.this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new AdminRecyclerViewAdapter(this,adminDocArrayList);
        recyclerView.setAdapter(adapter);
    }
}
