package com.example.figma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.*;

public class details_page extends AppCompatActivity {
    Button countinue;
    TextView dbtext;
    public static String driver="oracle.jdbc.driver.OracleDriver";
    static String url="jdbc:oracle:thin:@192.168.1.198:1521:xe";
    public static String user="hr";
    static String password="manager";
    public static Connection connection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_page);
        countinue=(Button) findViewById(R.id.continuebtn);
        dbtext=(TextView) findViewById(R.id.dbtext);
        StrictMode.ThreadPolicy threadPolicy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);

        countinueAction();
    }


    /*
    * Action of the Button
    * */
    void countinueAction(){

        Log.i("Details Page ","Error in ");

     countinue.setOnClickListener(view -> {
         try{
             Class.forName(driver);
             connection=DriverManager.getConnection(url,user,password);
             Toast.makeText(details_page.this,"connection established",Toast.LENGTH_SHORT).show();
             Statement statement=connection.createStatement();
             String quary="select * from chiru1";
             ResultSet result=statement.executeQuery(quary);
             ResultSetMetaData rsmd=result.getMetaData();
             int column=rsmd.getColumnCount();
             StringBuffer stringBuffer=new StringBuffer();

             while(result.next()){
                 for(int i=1;i<=column;i++){
                     stringBuffer.append(result.getString(i)+"   ");
                 }
                 stringBuffer.append("\n");
             }
             dbtext.setText(stringBuffer);

         }
         catch(Exception e){
             dbtext.setText(e.getMessage());

         }
      /*   Intent nagivation=new Intent(getApplicationContext(),nagavation_drawer.class);
         startActivity(nagivation);*/

     });
    }
}