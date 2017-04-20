package com.example.sierra.databaseoperations;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText fname ;
    EditText lname ;
    EditText roll;
    Button btnIns;
    Button btnSel;
    Button btnUpd;
    Button btnDel;
    DBStuff dbStuff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIns = (Button) findViewById(R.id.insBtn);
        btnSel = (Button) findViewById(R.id.selBtn);
        btnUpd = (Button) findViewById(R.id.updBtn);
        btnDel = (Button) findViewById(R.id.delBtn);

        fname = (EditText) findViewById(R.id.fname);
        lname = (EditText) findViewById(R.id.lname);
        roll = (EditText) findViewById(R.id.roll);

        dbStuff = new DBStuff(this);



        btnIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dbStuff.insert(Integer.parseInt(roll.getText().toString()),fname.getText().toString(),lname.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rollS = Integer.parseInt(roll.getText().toString());
                Cursor res = dbStuff.select(rollS);
                String str = "";
                res.moveToFirst();
                do{
                    str += res.getInt(0);
                    str += " " + res.getString(1)+" ";
                    str += " " + res.getString(2) + "\n";
                }while (res.moveToNext());

                final AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
                alert.setTitle("Result");
                alert.setMessage(str);
                alert.setButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        alert.cancel();
                    }
                });
                alert.show();
            }
        });


        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rollS = Integer.parseInt(roll.getText().toString());
                if(dbStuff.delete(rollS)) Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_LONG).show();
                else Toast.makeText(getApplicationContext(),"Not deleted",Toast.LENGTH_LONG).show();
            }
        });

        btnUpd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbStuff.update(Integer.parseInt(roll.getText().toString()),fname.getText().toString(),lname.getText().toString());
                Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_LONG).show();
            }
        });



    }
}
