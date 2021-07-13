package com.example.dnddbstatstest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        dbHelper = new DBHelper(MainActivity.this);

        List<CharSheet> allChar = dbHelper.getAllChar();

        //for improving performance
        recyclerView.setHasFixedSize(true);

        //sets layout manager and adapter
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new RecyclerViewAdapter(allChar);
        recyclerView.setAdapter(mAdapter);
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        List<CharSheet> allChar = dbHelper.getAllChar();
        mAdapter = new RecyclerViewAdapter(allChar);
        recyclerView.setAdapter(mAdapter);
    }
    public void onClick(View view)
    {
        if(view.getId() == R.id.AddButton)
        {
            Intent intent = new Intent(this, AddEditActivity.class);
            startActivity(intent);
        }

    }


}
