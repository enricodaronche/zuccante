package com.example.enrico.clientsocialz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class PraticantiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_praticanti);

        Intent i=getIntent();

        TextView tv=findViewById(R.id.nomeHobby);
        tv.setText(i.getStringExtra("nome"));

        ScrollView scrollView=findViewById(R.id.scroll2);
        scrollView.removeAllViews();
        int numPraticanti=i.getIntExtra("numPraticanti",0);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
        params.setMargins(40, 10, 10, 10);
        for(int j=0;j<numPraticanti;j++){
            TextView textView=new TextView(this);
            textView.setTextSize(20);
            textView.setLayoutParams(params);
            textView.setText(i.getStringExtra("praticante"+j));
            linearLayout.addView(textView);
        }
        scrollView.addView(linearLayout);

    }
}
