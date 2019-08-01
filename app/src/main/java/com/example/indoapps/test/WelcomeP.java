package com.example.indoapps.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class WelcomeP extends Activity {
    EditText et1;
    TextView t1;

    public void onCreate(Bundle b) {
        super.onCreate(b);
        Intent j=getIntent();
        setContentView(R.layout.layout2);

    }

    public void Read(View v)
    {
        try
        {

            String f="Indro.txt";
            et1=(EditText) this.findViewById(R.id.editText6);
            t1=findViewById(R.id.textView2);
            InputStream is=this.openFileInput(f);

            if(is != null)
            {
                InputStreamReader isr=new InputStreamReader(is);
                BufferedReader br=new BufferedReader(isr);
                String r="";
                StringBuilder s=new StringBuilder();

                while ((r = br.readLine())!= null)
                {
                    s.append(r);

                }
                is.close();
                String ret=s.toString();
                t1.setText(ret);

            }

        }

        catch(Exception ex)

        {

        }
    }


    public void Write(View v)
    {
        try
        {
            String f="Indro.txt";
            et1=(EditText) findViewById(R.id.editText6);
            String s=et1.getText().toString();
            OutputStreamWriter out=new OutputStreamWriter(this.openFileOutput(f,Context.MODE_PRIVATE));
            out.write(s);
            out.close();
            Toast.makeText(getApplicationContext(), "File Written",Toast.LENGTH_SHORT).show();
            et1.setText("");
        }catch(Exception ex){}


    }



}
