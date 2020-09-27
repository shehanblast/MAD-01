package com.example.vendors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AddPayment extends AppCompatActivity {
    public Toolbar toolbar;
    private EditText p_name, p_amount, p_date;
    private Button addp;
    private DbHandler dbHandler;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_payment);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add Payment");
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);


       /* p_name = findViewById(R.id.pname);
        p_amount = findViewById(R.id.pamount);
        p_date = findViewById(R.id.editTextDate);
        addp = findViewById(R.id.buttonp);
        context = this;

        dbHandler = new DbHandler(context);*/


      /*  addp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String pname = p_name.getText().toString();
                String pamount = p_amount.getText().toString();
                String pdate = p_date.getText().toString();


               Vendor vendor = new Vendor("", "", "", "", "","", "",pname, pamount, pdate);
               dbHandler.addVendor(vendor);



            }
        });*/

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();

        if(id == R.id.check1){
            Intent intent = new Intent(AddPayment.this, EditPayment.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
