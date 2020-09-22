package com.example.vendors;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddVendor extends AppCompatActivity {
    public Toolbar toolbar;
    public FloatingActionButton floatingActionButton;
    private EditText name, category, note, estimated_amount, number, email, address;
    private Button add;
    private DbHandler dbHandler;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vendor);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add Vendor");
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        floatingActionButton = findViewById(R.id.button2);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddVendor.this, AddPayment.class);
                startActivity(intent);
            }
        });


        name = findViewById(R.id.editTextTextPersonName3);
        category = findViewById(R.id.editTextTextPersonName2);
        note = findViewById(R.id.editTextTextPersonName);
        estimated_amount = findViewById(R.id.editTextTextPersonName6);
        number = findViewById(R.id.editTextTextPersonName4);
        email = findViewById(R.id.editTextTextEmailAddress);
        address = findViewById(R.id.editTextTextPersonName7);
        add = findViewById(R.id.btnadd);
        context = this;

        dbHandler = new DbHandler(context);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String vname = name.getText().toString();
                String vcategory = category.getText().toString();
                String vnote = note.getText().toString();
                String vestimated_amount = estimated_amount.getText().toString();
                String vnumber = number.getText().toString();
                String vemail = email.getText().toString();
                String vaddress = address.getText().toString();


                Vendor vendor = new Vendor(vname, vcategory, vnote, vestimated_amount, vnumber, vemail, vaddress);
                dbHandler.addVendor(vendor);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return true;
    }

   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg="";
        switch (item.getItemId()){
            case R.id.check1:
               msg="Added";
                break;

        }
        Toast.makeText(this, msg+ " the vendor", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}



 

       