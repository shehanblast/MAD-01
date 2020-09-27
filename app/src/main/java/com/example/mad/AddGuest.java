package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

public class AddGuest extends AppCompatActivity {

    private EditText add_gender,addinvitation,addtelno,addemail,addtype,addAdress,add_id,add_name;
    private TextView Invitation,TelNo,id,Address,name,Gender,Type,text_topic,Email,addContactDetails;
    private Button Add,Edit;
    private DbHandler dbHandler;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_guest);

        //EditText
        add_name=findViewById(R.id.add_name);
        add_id=findViewById(R.id.add_id);
        add_gender=findViewById(R.id.add_gender);
        addinvitation=findViewById(R.id.addinvitation);
        addtelno=findViewById(R.id.addtelno);
        addemail=findViewById(R.id.addemail);
        addtype=findViewById(R.id.addtype);
        addAdress=findViewById(R.id.addAdress);
        context=this;

        dbHandler=new DbHandler(context);

        //button
        Add=findViewById(R.id.Add);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int guest_id=add_id.getId();
                String guest_name=add_name.getText().toString();
                String guest_gender= add_gender.getText().toString();
                String guest_invitation= addinvitation.getText().toString();
                String guest_telno=addtelno.getText().toString();
                String guest_email=addemail.getText().toString();
                String guest_type=addtype.getText().toString();
                String guest_address=addAdress.getText().toString();
                long started=System.currentTimeMillis();

                guest guest=new guest(guest_id,guest_name,guest_gender,guest_type,guest_telno,guest_email,guest_type,guest_address,started,0);
                dbHandler.addGuest(guest);

                startActivity(new Intent(context,MainActivity.class));
            }
        });




    }

}