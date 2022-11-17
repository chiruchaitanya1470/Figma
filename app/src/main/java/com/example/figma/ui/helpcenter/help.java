package com.example.figma.ui.helpcenter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.figma.R;

import java.util.ArrayList;

public class help extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        spinner=findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayList<String> list=new ArrayList<String>();
        list.add("india");
        list.add("germany");
        list.add("newyork");
        list.add("itely");
        list.add("washington");
        ArrayAdapter<String> li=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
        spinner.setAdapter(li);

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}