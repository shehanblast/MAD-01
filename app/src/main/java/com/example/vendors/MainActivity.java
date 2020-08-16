package com.example.vendors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    public Toolbar toolbar;

    public FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Vendors");
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);

        floatingActionButton = findViewById(R.id.button1);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,  AddVendor.class);
                startActivity(intent);
            }
        });
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