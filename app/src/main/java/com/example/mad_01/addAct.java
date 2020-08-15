package com.example.mad_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class addAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add2);
        getSupportActionBar().setTitle("Add Budget");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
