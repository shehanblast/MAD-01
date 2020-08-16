package com.example.vendors;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class BackToMain extends AppCompatActivity {
    public Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_to_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Vendors");
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg="";
        switch (item.getItemId()){
            case R.id.search:
                msg="Search";
                break;
            case R.id.summary:
                msg="Summary";
                break;
            case R.id.report:
                msg="Report";
                break;

        }
        Toast.makeText(this, msg+ " checked", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
