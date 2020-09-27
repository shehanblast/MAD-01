package com.example.mad;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //private Toolbar toolbar;
    private  Button button_addGuest,button_EditGuest,button_DeleteGuest;
    private ListView todoguest;
    private TextView count;
    Context context;
    private DbHandler dbHandler;
    private List<guest> Guest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        dbHandler=new DbHandler(context);
        button_addGuest  =findViewById(R.id.button_addGuest);
        //button_EditGuest  =findViewById(R.id.button_EditGuest);
        //button_DeleteGuest  =findViewById(R.id.button_DeleteGuest);
        //toolbar  =findViewById(R.id.mytoolBar);

        //setSupportActionBar(toolbar);

        todoguest=findViewById(R.id.todoguest);
        count=findViewById(R.id.text);
        Guest=new ArrayList<>();

        Guest=dbHandler.getAllGuests();
        guestAdapter gAdapter=new guestAdapter(context,R.layout.single_guest,Guest);
        todoguest.setAdapter(gAdapter);






        button_addGuest.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(context,AddGuest.class));



            }
        });





        /*todoguest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setTitle("Test");
                builder.setMessage("Message");
                builder.show();

            }
        });*/




    }
}