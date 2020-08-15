package com.example.mad_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Budget extends AppCompatActivity {

    Button bttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        getSupportActionBar().setTitle("Budget");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bttn = findViewById(R.id.btn2);
    }




    public void onResume() {

        super.onResume();
        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Budget.this,addAct.class);
                startActivity(intent);
            }
        });
    }
}
