package com.example.a6_17vote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView[] image = new ImageView[3];
    Integer[] id = {R.id.imageView1, R.id.imageView2, R.id.imageView3};
    String[] name = {"사과", "수박" , "오렌지"};
    Button btn1;
    final int[] count = new int[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.button1);
        for (int i=0; i < count.length; i++){
            count[i]=0;
        }
        for(int i=0; i<id.length; i++){
            final int result;
            result = i;
            image[result] = (ImageView) findViewById(id[result]);
            image[result].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    count[result]++;
                    Toast.makeText(getApplicationContext(),
                            name[result]+" : "+count[result] + "표",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        Second.class);
                intent.putExtra("count",count);
                startActivity(intent);
            }
        });
    }
}