package com.example.patientapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchPatientActivity extends AppCompatActivity {
AppCompatButton b1;
EditText ed1,ed2,ed3,ed4,ed5;
String getMob,getPcode,getName,getAdd,getDrname;
DbHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_patient);
        ed1=(EditText) findViewById(R.id.mbno);
        ed2=(EditText) findViewById(R.id.pcode);
        ed3=(EditText) findViewById(R.id.pname);
        ed4=(EditText) findViewById(R.id.addrs);
        ed5=(EditText) findViewById(R.id.dname);
        mydb=new DbHelper(this);
        mydb.getWritableDatabase();
        b1=(AppCompatButton) findViewById(R.id.search);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMob=ed1.getText().toString();
                Cursor c=mydb.searchPatient(getMob);
                if (c.getCount()==0)
                {
                    ed2.setText("");
                    ed3.setText("");
                    ed4.setText("");
                    ed5.setText("");
                    Toast.makeText(getApplicationContext(), "No Employee found", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    while (c.moveToNext())
                    {
                        getPcode=c.getString(1);
                        getName=c.getString(2);
                        getAdd=c.getString(3);
                        getDrname=c.getString(5);
                    }
                    ed2.setText(getPcode);
                    ed3.setText(getName);
                    ed4.setText(getAdd);
                    ed5.setText(getDrname);
                }

            }
        });
    }
}