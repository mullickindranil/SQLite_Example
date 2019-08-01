package com.example.indoapps.test;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button b1,b2;
    EditText et1,et2;
    TextView t1,t2;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent k=getIntent();
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);

        et1=findViewById(R.id.editText2);
        et2=findViewById(R.id.editText3);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st1,st2;
                st1=et1.getText().toString();
                st2=et2.getText().toString();
                try{


                    SQLiteDatabase mydatabase = openOrCreateDatabase("INDRO",MODE_PRIVATE,null);

                    Cursor resultSet = mydatabase.rawQuery("Select * from T1 where Roll=? and Name=?",new String[]{st1,st2});


                    resultSet.moveToFirst();

                    if(resultSet.getCount()>0)
                    {
                        Intent j=new Intent(MainActivity.this,WelcomeP.class);
                        startActivity(j);
                    }
                    else
                        Toast.makeText(getApplicationContext(),"Invalid User id or Password ",Toast.LENGTH_LONG).show();
                }
                catch(Exception ex)
                {
                    Toast.makeText(getApplicationContext(), ex.getMessage(),Toast.LENGTH_LONG).show();
                }

            }





        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,RegistrationP.class);
                startActivity(i);
            }
        });

    }

}
