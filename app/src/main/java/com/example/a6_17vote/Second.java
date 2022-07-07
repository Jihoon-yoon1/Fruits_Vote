package com.example.a6_17vote;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Second extends AppCompatActivity {
    TextView[] text = new TextView[3];
    Integer[] id = {R.id.textView1, R.id.textView2, R.id.textView3};
    String[] name = {"사과", "수박", "오렌지"};
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        btn1 = (Button)findViewById(R.id.button1);
        Intent intent = getIntent();
        int[] result=intent.getIntArrayExtra("count");
        for(int i=0; i<text.length; i++){
            text[i] = (TextView) findViewById(id[i]);
        }
        for(int i=0; i<text.length; i++){
            text[i].setText(name[i]+" : "+result[i]+"표");
        }
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
