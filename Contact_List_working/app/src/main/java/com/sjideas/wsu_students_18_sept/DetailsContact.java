package com.sjideas.wsu_students_18_sept;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsContact extends AppCompatActivity {
    DbAdapter db;
    String id,name,number,email,address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_contact);

        Intent intent = getIntent();
        id = intent.getStringExtra("ID");
        name = intent.getStringExtra("NAME");
        number = intent.getStringExtra("NUMBER");
        email = intent.getStringExtra("EMAIL");
        address = intent.getStringExtra("ADDRESS");
        ((TextView) findViewById(R.id.name)).setText(name);
        ((TextView) findViewById(R.id.number)).setText(number);
        ((TextView) findViewById(R.id.email)).setText(email);
        ((TextView) findViewById(R.id.address)).setText(address);
        //calling DbAdapter
        db = new DbAdapter(this);
        db.open();
    }
    public void Edit(View v){
        //go to EditContact page
        Intent edit = new Intent(DetailsContact.this, EditContact.class);
        edit.putExtra("ID", id);
        edit.putExtra("NAME", name);
        edit.putExtra("NUMBER", number);
        edit.putExtra("EMAIL", email);
        edit.putExtra("ADDRESS",address);
        startActivity(edit);
    }
    public void Delete(View v){
        db.delete(Integer.parseInt(id));
        Toast.makeText(getApplicationContext(),"deleted", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onBackPressed() {
        finish();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
