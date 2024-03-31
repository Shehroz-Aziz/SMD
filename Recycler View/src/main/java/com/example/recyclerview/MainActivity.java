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
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvRestaurants;
    Adapter myAdapter;
    ArrayList<Restaurant> list;
    Button btnAddNew;
    Integer TotalCount;

    EditText SearchBar;
    ImageButton Searchbtn;
    boolean SearchBtnPressed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SearchBtnPressed=false;
        init();

        rvRestaurants.setHasFixedSize(true);
        myAdapter = new Adapter(list);

        rvRestaurants.setLayoutManager(new LinearLayoutManager(this));
        //rvChats.setLayoutManager(new GridLayoutManager(this,4));
        rvRestaurants.setAdapter(myAdapter);


        Searchbtn.setOnClickListener(v -> {
            if(!SearchBtnPressed)
            {
                if (SearchBar.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this, "Enter Some Text", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int i, j;
                    for (i = 0; i < list.size(); i++) {
                        if (!list.get(i).getLocation().contains(SearchBar.getText().toString()) && !list.get(i).getName().contains(SearchBar.getText().toString()) && !list.get(i).getDescription().contains(SearchBar.getText().toString())) {
                            list.remove(i);
                        }
                    }

                    Restaurant temp;
                    boolean swapped;
                    for (i = 0; i < list.size() - 1; i++) {
                        swapped = false;
                        for (j = 0; j < list.size() - i - 1; j++) {
                            if (Integer.parseInt(list.get(j).getRatings()) > Integer.parseInt(list.get(j + 1).getRatings())) {
                                temp = list.get(j);
                                list.set(j, list.get(j + 1));
                                list.set(j + 1, temp);
                                swapped = true;
                            }
                        }
                        if (!swapped)
                            break;
                    }
                    SearchBtnPressed=true;
                    Searchbtn.setImageResource(R.drawable.ic_back);
                }
            }
            else
            {
                Searchbtn.setImageResource(R.drawable.ic_search);
                SearchBtnPressed=false;
                recreate();
            }

        });
        btnAddNew.setOnClickListener(v -> {

            Toast.makeText(MainActivity.this, TotalCount.toString(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Adding.class);
            startActivity(intent);
            finish();
        });

    }
    private void init()
    {
        list = new ArrayList<>();
        String index;
        list.add(new Restaurant("Dares Delight","Desi and Continental","090078601","4","PIA Road, Lahore"));
        SharedPreferences sharedPreferences= getSharedPreferences("Count",MODE_PRIVATE);
        TotalCount = sharedPreferences.getInt("Total",-1);
        for (int i = 0 ; i <= TotalCount ; i++)
        {
            index = Integer.toString(i);
            Toast.makeText(MainActivity.this,index,Toast.LENGTH_SHORT).show();
            SharedPreferences Temp = getSharedPreferences(index, MODE_PRIVATE);
            list.add(new Restaurant(Temp.getString("Name",""),Temp.getString("Description",""),Temp.getString("Contact",""),Temp.getString("Rating",""),Temp.getString("Location","")));
        }
        rvRestaurants = findViewById(R.id.rvRestaurants);
        btnAddNew = findViewById(R.id.btnAddNew);
        Searchbtn = findViewById(R.id.btnSearch);
        SearchBar = findViewById(R.id.etSeachBarText);

    }
}