package com.sebeelaapp.doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    // variables
    TextInputLayout re_name ,re_surname,re_email,re_date, re_address,re_phone,re_gender;
    Button add;
    FirebaseDatabase mydatabase;
    DatabaseReference myreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // getting all xml elememts from xml file
        re_name =   findViewById(R.id.name);
        re_surname =findViewById(R.id.surnamein);
        re_email =  findViewById(R.id.emailin);
        re_date =   findViewById(R.id.datein);
        re_address= findViewById(R.id.addressin);
        re_phone =  findViewById(R.id.contactsin);
        re_gender = findViewById(R.id.genderin);
        add =       findViewById(R.id.adding);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydatabase = FirebaseDatabase.getInstance();
                myreference =mydatabase.getReference("Clients");
                // get all values
                String name    = re_name.   getEditText().getText().toString();
                String surname = re_surname.getEditText().getText().toString();
                String email   = re_email.  getEditText().getText().toString();
                String date    = re_date.   getEditText().getText().toString();
                String address = re_address.getEditText().getText().toString();
                String phone =   re_phone.  getEditText().getText().toString();
                String gender =  re_gender. getEditText().getText().toString();

               UserHelperClass  connect = new UserHelperClass(name,surname,email,date,address,phone,gender);

              myreference.setValue(connect);

            }
        });
    }
}

