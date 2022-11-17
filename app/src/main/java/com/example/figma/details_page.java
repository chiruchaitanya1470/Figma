package com.example.figma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class details_page extends AppCompatActivity {
    Button countinue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_page);
        countinue=(Button) findViewById(R.id.continuebtn);


        countinueAction();
    }
    void countinueAction(){
     countinue.setOnClickListener(view -> {
         Intent nagivation=new Intent(getApplicationContext(),nagavation_drawer.class);
         startActivity(nagivation);

     });
    }
}