package com.example.dnddbstatstest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    Button Storebtn;
    EditText nameText, editStr, editDex, editCon, editWis, editInt, editCha;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        nameText = findViewById(R.id.nameText);
        editStr = findViewById(R.id.editStr);
        editDex = findViewById(R.id.editDex);
        editCon = findViewById(R.id.editCon);
        editWis = findViewById(R.id.editWis);
        editInt = findViewById(R.id.editInt);
        editCha = findViewById(R.id.editCha);
        Storebtn = findViewById(R.id.storeButton);
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
    public void onClick(View view)
    {
        if(view.getId()== R.id.viewAllButton)
        {
            List<CharSheet> allChar = dbHelper.getAllChar();
            dbHelper.deleteChar(allChar.get(0));

        }
        else if(view.getId() == R.id.storeButton)
        {
            CharSheet charSheet;
            try
            {
                charSheet = new CharSheet(nameText.getText().toString(), -1,
                        Integer.parseInt(editStr.getText().toString()),
                        Integer.parseInt(editDex.getText().toString()),
                        Integer.parseInt(editCon.getText().toString()),
                        Integer.parseInt(editWis.getText().toString()),
                        Integer.parseInt(editInt.getText().toString()),
                        Integer.parseInt(editCha.getText().toString()));
            }
            catch(Exception e)
            {
                Toast.makeText(getApplicationContext(),"One or More Parameters Empty",Toast.LENGTH_SHORT).show();
                //charSheet = new CharSheet("Error",-1,-1,-1,-1,-1,-1,-1);
                return;
            }


            boolean aChar = dbHelper.addChar(charSheet);

            if(aChar == true)
            {
                Toast.makeText(this, "Addition: " + aChar, Toast.LENGTH_SHORT).show();
                List<CharSheet> allChar = dbHelper.getAllChar();
                mAdapter = new RecyclerViewAdapter(allChar);
                recyclerView.setAdapter(mAdapter);
            }
            else if(aChar == false)
            {
                Toast.makeText(this, "Addition: " + aChar, Toast.LENGTH_SHORT).show();
            }

        }

    }


}
