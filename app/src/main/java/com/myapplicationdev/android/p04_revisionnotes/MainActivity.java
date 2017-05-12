package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNote;
    RadioGroup rgStars;
    Button btnInsert, btnShowList;
    RadioButton rb1,rb2,rb3,rb4,rb5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNote = (EditText) findViewById(R.id.editTextNote);
        rgStars = (RadioGroup) findViewById(R.id.radioGroupStars);
        rb1 = (RadioButton) findViewById(R.id.radio1);
        rb2 = (RadioButton) findViewById(R.id.radio2);
        rb3 = (RadioButton) findViewById(R.id.radio3);
        rb4 = (RadioButton) findViewById(R.id.radio4);
        rb5 = (RadioButton) findViewById(R.id.radio5);
        btnInsert = (Button) findViewById(R.id.buttonInsertNote);
        btnShowList = (Button) findViewById(R.id.buttonShowList);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String noteContent = etNote.getText().toString();
                if(noteContent != "" && rgStars.getCheckedRadioButtonId() != -1){
                    DBHelper db = new DBHelper(MainActivity.this);


                    int stars = -1;

                    if(rb1.isChecked()){
                        stars = 1;
                    } else if (rb2.isChecked()){
                        stars = 2;
                    } else if (rb3.isChecked()){
                        stars = 3;
                    } else if (rb4.isChecked()){
                        stars = 4;
                    } else if (rb5.isChecked()){
                        stars = 5;
                    }



                    db.insertNote(noteContent, stars);

                    Toast.makeText(getApplicationContext(),"Inserted Successfully",Toast.LENGTH_SHORT).show();

                    db.close();
                } else {
                    Toast.makeText(getApplicationContext(),"Failed to insert data",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }
}
