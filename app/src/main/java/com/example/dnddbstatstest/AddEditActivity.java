package com.example.dnddbstatstest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;


public class AddEditActivity extends AppCompatActivity {
    private DBHelper dbHelper;
    EditText nameText, editStr, editDex, editCon, editWis, editInt, editCha;
    Button Storebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addedit);

        nameText = findViewById(R.id.nameText);
        editStr = findViewById(R.id.editStr);
        editDex = findViewById(R.id.editDex);
        editCon = findViewById(R.id.editCon);
        editWis = findViewById(R.id.editWis);
        editInt = findViewById(R.id.editInt);
        editCha = findViewById(R.id.editCha);
        Storebtn = findViewById(R.id.storeButton);

        dbHelper = new DBHelper(this);
    }
    public void onClick(View view)
    {
        if(view.getId() == R.id.storeButton)
        {
            CharSheet charSheet;
            try
            {
                if(nameText.getText().toString().isEmpty())
                {
                    throw new IOException("name cannot be empty");
                }
                charSheet = new CharSheet(nameText.getText().toString(), -1,
                        Integer.parseInt(editStr.getText().toString()),
                        Integer.parseInt(editDex.getText().toString()),
                        Integer.parseInt(editCon.getText().toString()),
                        Integer.parseInt(editWis.getText().toString()),
                        Integer.parseInt(editInt.getText().toString()),
                        Integer.parseInt(editCha.getText().toString()));
            } catch(Exception e)
            {
                Toast.makeText(getApplicationContext(),"One or More Parameters Empty",Toast.LENGTH_SHORT).show();
                //charSheet = new CharSheet("Error",-1,-1,-1,-1,-1,-1,-1);
                return;
            }
            boolean aChar = dbHelper.addChar(charSheet);

            if(aChar == true)
            {
                Toast.makeText(this, "Addition: " + aChar, Toast.LENGTH_SHORT).show();

            }
            else if(aChar == false)
            {
                Toast.makeText(this, "Addition: " + aChar, Toast.LENGTH_SHORT).show();
            }

        }
    }
}