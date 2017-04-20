package com.example.sierra.basicwidgets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class Shower extends AppCompatActivity {

    TextView fname;
    TextView email;
    TextView pass;
    TextView date;
    TextView gen;
    TextView spn;
    TextView lan;

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
        setContentView(R.layout.activity_shower);

        fname = (TextView) findViewById(R.id.fnameTV);
        email = (TextView) findViewById(R.id.emailTV);
        pass = (TextView) findViewById(R.id.passTV);
        date = (TextView) findViewById(R.id.dateTV);
        gen = (TextView) findViewById(R.id.genTV);
        spn = (TextView) findViewById(R.id.spnTV);
        lan = (TextView) findViewById(R.id.lanTV);

        Intent i = getIntent();
        fnameS = i.getStringExtra("fname");
        emailS = i.getStringExtra("email");
        passS = i.getStringExtra("pass");
        dateS = i.getStringExtra("date");
        gender = i.getStringExtra("gender");
        languages = i.getStringExtra("languages");
        spnS = i.getStringExtra("spn");

        fname.setText(fnameS);
        email.setText(emailS);
        pass.setText(passS);
        date.setText(dateS);
        gen.setText(gender);
        lan.setText(languages);
        spn.setText(spnS);

    }
}
