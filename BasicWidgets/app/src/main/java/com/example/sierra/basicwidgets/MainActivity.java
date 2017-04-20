package com.example.sierra.basicwidgets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    EditText fname;
    EditText email;
    EditText pass;
    EditText date;
    RadioGroup rg;
    Spinner spn;
    Button btn;
    CheckBox cppBox;
    CheckBox pyBox;
    CheckBox javBox;

    String fnameS;
    String emailS;
    String passS;
    String dateS;
    String gender;
    String languages="";
    String spnS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fname = (EditText) findViewById(R.id.fname);
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.password);
        date = (EditText) findViewById(R.id.date);

        rg = (RadioGroup) findViewById(R.id.rg);
        spn = (Spinner) findViewById(R.id.spn);
        btn=(Button) findViewById(R.id.sbt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fnameS = fname.getText().toString();
                emailS = email.getText().toString();
                passS =  pass.getText().toString();
                dateS = date.getText().toString();

                int selectedId = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(selectedId);
                gender = rb.getText().toString();

                cppBox = (CheckBox) findViewById(R.id.cppChk);
                pyBox = (CheckBox) findViewById(R.id.pyChk);
                javBox = (CheckBox) findViewById(R.id.javaChk);

                if(cppBox.isChecked()) languages += cppBox.getText().toString() +", ";
                if(pyBox.isChecked()) languages += pyBox.getText().toString() + ", ";
                if(javBox.isChecked()) languages += javBox.getText().toString();

                spnS = spn.getSelectedItem().toString();
                Intent i = new Intent(getApplicationContext(),Shower.class);
                i.putExtra("fname",fnameS);
                i.putExtra("email",emailS);
                i.putExtra("pass",passS);
                i.putExtra("date",dateS);
                i.putExtra("gender",gender);
                i.putExtra("languages",languages);
                i.putExtra("spn",spnS);
                startActivity(i);

            }
        });





    }
}
