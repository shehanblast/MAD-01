package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditGuest extends AppCompatActivity {

    private EditText edit_gender,editinvitation,edittelno,editemail,edittype,editAdress,edit_id,edit_name;
    private Button edit1;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_guest);

        edit_gender=findViewById(R.id.edit_gender);
        editinvitation=findViewById(R.id.editinvitation);
        edittelno =findViewById(R.id.edittelno);
        editemail=findViewById(R.id.editemail);
        edittype=findViewById(R.id.edittype);
        editAdress=findViewById(R.id.editAdress);
        edit_id=findViewById(R.id.edit_id);
        edit_name=findViewById(R.id.edit_name);

        edit1 =findViewById(R.id.edit);

        edit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,MainActivity.class));
            }
        });


    }
}