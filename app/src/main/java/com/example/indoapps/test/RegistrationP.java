package com.example.indoapps.test;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationP extends Activity{

    Button b1;
    EditText et1,et2,et3;

    public void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.layout);


        et1=findViewById(R.id.editText);
        et2=findViewById(R.id.editText4);
        et3=findViewById(R.id.editText5);

        b1=findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(et2.getText().toString().equals(et3.getText().toString()))
                {
                    insertData();
                    Intent j=new Intent(RegistrationP.this,MainActivity.class);
                    startActivity(j);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Password Mismatch",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void insertData()
    {
        try
        {
            String r,n;
            r=et1.getText().toString();
            n=et2.getText().toString();

            SQLiteDatabase mydatabase = openOrCreateDatabase("INDRO",MODE_PRIVATE,null);

            mydatabase.execSQL("CREATE TABLE IF NOT EXISTS t1(Roll VARCHAR(10),Name VARCHAR(10));");

            mydatabase.execSQL("Insert into t1 values(?, ?)",new String[]{r,n});

            mydatabase.close();
            et1.setText("");
            et2.setText("");
            et3.setText("");
            Toast.makeText(getApplicationContext(),"Registration Completed",Toast.LENGTH_LONG).show();
        }
        catch(Exception ex)
        {
            Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

}
