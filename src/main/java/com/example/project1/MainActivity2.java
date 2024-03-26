package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.material.button.MaterialButton;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Find the back button (FrameLayout)
        FrameLayout backButton = findViewById(R.id.back);

        // Set OnClickListener for the back button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Navigate back to the previous activity
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Find the MaterialButtons
        MaterialButton btn1 = findViewById(R.id.btn1);
        MaterialButton btn2 = findViewById(R.id.btn2);
        MaterialButton btn3 = findViewById(R.id.btn3);

        // Set OnClickListener for button 1
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the corresponding TextView and hide others
                findViewById(R.id.tvs1).setVisibility(View.VISIBLE);
                findViewById(R.id.tvs2).setVisibility(View.GONE);
                findViewById(R.id.tvs3).setVisibility(View.GONE);

                // Change background tint color of button 1
                btn1.setBackgroundTintList(ContextCompat.getColorStateList(MainActivity2.this, R.color.Clicked));

                // Restore default background tint color for other buttons
                btn2.setBackgroundTintList(ContextCompat.getColorStateList(MainActivity2.this,R.color.Blue));
                btn3.setBackgroundTintList(ContextCompat.getColorStateList(MainActivity2.this,R.color.Blue));
            }
        });

        // Set OnClickListener for button 2
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the corresponding TextView and hide others
                findViewById(R.id.tvs1).setVisibility(View.GONE);
                findViewById(R.id.tvs2).setVisibility(View.VISIBLE);
                findViewById(R.id.tvs3).setVisibility(View.GONE);

                // Change background tint color of button 2
                btn2.setBackgroundTintList(ContextCompat.getColorStateList(MainActivity2.this,R.color.Clicked));

                // Restore default background tint color for other buttons
                btn1.setBackgroundTintList(ContextCompat.getColorStateList(MainActivity2.this,R.color.Blue));
                btn3.setBackgroundTintList(ContextCompat.getColorStateList(MainActivity2.this,R.color.Blue));
            }
        });

        // Set OnClickListener for button 3
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the corresponding TextView and hide others
                findViewById(R.id.tvs1).setVisibility(View.GONE);
                findViewById(R.id.tvs2).setVisibility(View.GONE);
                findViewById(R.id.tvs3).setVisibility(View.VISIBLE);

                // Change background tint color of button 3
                btn3.setBackgroundTintList(ContextCompat.getColorStateList(MainActivity2.this,R.color.Clicked));

                // Restore default background tint color for other buttons
                btn1.setBackgroundTintList(ContextCompat.getColorStateList(MainActivity2.this,R.color.Blue));
                btn2.setBackgroundTintList(ContextCompat.getColorStateList(MainActivity2.this,R.color.Blue));
            }
        });

        // Initially, set button 1 as pressed
        btn1.performClick();
    }
}