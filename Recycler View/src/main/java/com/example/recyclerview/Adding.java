package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class Adding extends AppCompatActivity {

    EditText des,name,contact,rating,location;
    MaterialButton btnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);
        init();

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Total;
                if (name.getText().toString().equals("") || des.getText().toString().equals("") || location.getText().toString().equals("")|| contact.getText().toString().equals(""))
                {
                    Toast.makeText(Adding.this, "Fill All Feilds", Toast.LENGTH_SHORT).show();
                }
                else if(!rating.getText().toString().equals("5")  && !rating.getText().toString().equals("4") && !rating.getText().toString().equals("3") && !rating.getText().toString().equals("2") && !rating.getText().toString().equals("1")  )
                {
                    Toast.makeText(Adding.this, "Wrong Ratings Input", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SharedPreferences sharedPreferences = getSharedPreferences("Count",MODE_PRIVATE);
                    Total = sharedPreferences.getInt("Total",-1);
                    Total++;
                    SharedPreferences.Editor Myedit = sharedPreferences.edit();
                    Myedit.putInt("Total",Total);
                    Myedit.apply();
                    SharedPreferences sharedPreferences1 = getSharedPreferences(Integer.toString(Total) ,MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences1.edit();
                    editor.putString("Name",name.getText().toString().trim());
                    editor.putString("Rating",rating.getText().toString().trim());
                    editor.putString("Description",des.getText().toString().trim());
                    editor.putString("Location",location.getText().toString().trim());
                    editor.putString("Contact",contact.getText().toString().trim());
                    editor.apply();
                    Intent intent = new Intent(Adding.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }
    public  void init()
    {
        des=findViewById(R.id.tvResDescription2);
        location=findViewById(R.id.tvResLocation2);
        name=findViewById(R.id.tvResName2);
        contact=findViewById(R.id.tvResContact2);
        rating=findViewById(R.id.tvResRatings2);
        btnEnter=findViewById(R.id.btnEnter2);
    }

}