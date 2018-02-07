package com.example.enrico.tris;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.button1);
        Button btn2=findViewById(R.id.button2);


        btn1.setOnClickListener((view)-> {
            Intent i = new Intent(this,CampoTrisActivity.class);
            i.putExtra("is1vs1", false);
            startActivity(i);
        });

        btn2.setOnClickListener((view)-> {
            Intent i = new Intent(this,CampoTrisActivity.class);
            i.putExtra("is1vs1", true);
            startActivity(i);
        });

    }
}
