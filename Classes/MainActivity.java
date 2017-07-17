package com.example.chawach.valeurc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public static final String MY_TAG = "The_Custom_message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(MY_TAG,"onCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(MY_TAG,"onCreate");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(MY_TAG,"onPause");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(MY_TAG,"onResume");
    }
    public void bonbuttonClick(View V){

        EditText e1 = (EditText)findViewById(R.id.editText2);
        EditText msg = (EditText)findViewById(R.id.messagetext);
        EditText e2 = (EditText)findViewById(R.id.editText3);
        TextView t1 = (TextView)findViewById(R.id.textView);
        if  (e1.getText().toString()==""  || e2.getText().toString()==""){
            msg.setText("Please insert number");

       }
       else {
        int num1    = Integer.parseInt(e1.getText().toString());
        int num2    = Integer.parseInt(e2.getText().toString());
        int sum     = num1 + num2;
        t1.setText(Integer.toString(sum));
       }

    }

}
