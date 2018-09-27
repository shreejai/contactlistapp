package com.sjideas.wsu_students_18_sept;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class addNewContact extends AppCompatActivity {
    //calling variables
    DbAdapter db;
    EditText etname,etnumber,etemail,etaddress;
    String name,number,email,address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_contact);
        //get data from text feld
        etname =(EditText)findViewById(R.id.name);
        etnumber =(EditText)findViewById(R.id.number);
        etemail =(EditText)findViewById(R.id.email);
        etaddress = (EditText)findViewById(R.id.address);
        //calling DbAdapter
        db = new DbAdapter(this);
        db.open();
    }
    public void Save(View v){
        if(db.isExist(number)){
            Toast.makeText(getApplicationContext(),"already exist", Toast.LENGTH_SHORT).show();
        }else{
            name=etname.getText().toString();
            number=etnumber.getText().toString();
            email=etemail.getText().toString();
            address=etaddress.getText().toString();
            db.insert(name,number,email,address);
            Toast.makeText(getApplicationContext(),"Contact added", Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public void onBackPressed() {
        finish();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}