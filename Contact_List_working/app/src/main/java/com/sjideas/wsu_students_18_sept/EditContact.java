package com.sjideas.wsu_students_18_sept;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditContact extends AppCompatActivity {
    DbAdapter db;
    String id,name,number,email,address;
    EditText etname,etnumber,etemail,etaddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_contact);

        Intent intent = getIntent();
        id = intent.getStringExtra("ID");
        name = intent.getStringExtra("NAME");
        number = intent.getStringExtra("NUMBER");
        email = intent.getStringExtra("EMAIL");
        address = intent.getStringExtra("ADDRESS");
        ((EditText) findViewById(R.id.name)).setText(name);
        ((EditText) findViewById(R.id.number)).setText(number);
        ((EditText) findViewById(R.id.email)).setText(email);
        ((EditText) findViewById(R.id.address)).setText(address);
        //calling DbAdapter
        db = new DbAdapter(this);
        db.open();
        //get data from text feld
        etname =(EditText)findViewById(R.id.name);
        etnumber =(EditText)findViewById(R.id.number);
        etemail =(EditText)findViewById(R.id.email);
        etaddress = (EditText)findViewById(R.id.address);
    }
    public void Save(View v){
        name=etname.getText().toString();
        number=etnumber.getText().toString();
        email=etemail.getText().toString();
        address=etaddress.getText().toString();
        db.update(Integer.parseInt(id),name, number, email, address);
        Toast.makeText(getApplicationContext(),"Update success", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onBackPressed() {
        finish();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
