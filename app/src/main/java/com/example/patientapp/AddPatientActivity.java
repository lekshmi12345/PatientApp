package com.example.patientapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddPatientActivity extends AppCompatActivity {
AppCompatButton b1;
EditText ed1,ed2,ed3,ed4,ed5;
String getPcode,getName,getAdd,getMob,getDrname;
DbHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);
        b1=(AppCompatButton) findViewById(R.id.sub);
        ed1=(EditText) findViewById(R.id.pcode);
        ed2=(EditText) findViewById(R.id.pname);
        ed3=(EditText) findViewById(R.id.addrs);
        ed4=(EditText) findViewById(R.id.mbno);
        ed5=(EditText) findViewById(R.id.dname);
        mydb=new DbHelper(this);
        mydb.getReadableDatabase();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPcode=ed1.getText().toString();
                getName=ed2.getText().toString();
                getAdd=ed3.getText().toString();
                getMob=ed4.getText().toString();
                getDrname=ed5.getText().toString();
                boolean status=mydb.insertPatient(getPcode,getName,getAdd,getMob,getDrname);
                if (status==true)
                {
                    Toast.makeText(getApplicationContext(), "Successfully inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}