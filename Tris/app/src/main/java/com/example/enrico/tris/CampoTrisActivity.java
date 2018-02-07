package com.example.enrico.tris;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class CampoTrisActivity extends AppCompatActivity  implements Observer {

    private ViewGroup griglia;
    private TextView vX,vO;
    private int vittorieX,vittorieO;
    private boolean iniziaX,is1vs1;
    private GiocoTris gioco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campo_tris);

        HashMap<Integer,Character>colorate=new HashMap<>();
        if(savedInstanceState!=null){
            is1vs1=savedInstanceState.getBoolean("is1vs1");
            iniziaX=savedInstanceState.getBoolean("iniziaX");
            vittorieX=savedInstanceState.getInt("vittorieX");
            vittorieO=savedInstanceState.getInt("vittorieO");
            GiocoTris giocoTemp=(GiocoTris)savedInstanceState.getSerializable("gioco");
            colorate=giocoTemp.getStatoTris().getColorate();
            gioco=new GiocoTris(is1vs1,this);
            gioco.setContMosse(giocoTemp.getContMosse());
            gioco.setStatoTris(giocoTemp.getStatoTris());
            gioco.setTurnoX(giocoTemp.getTurnoX());
        }else{
            is1vs1=getIntent().getBooleanExtra("is1vs1",true);
            vittorieX=0;
            vittorieO=0;
            iniziaX=Math.random()<0.5;
            gioco=new GiocoTris(is1vs1,this);
        }

        griglia=findViewById(R.id.griglia);

        vX=findViewById(R.id.vittorieX);
        vO=findViewById(R.id.vittorieO);

        vX.setText("Vittorie X:"+vittorieX);
        vO.setText("Vittorie O:"+vittorieO);

        for(int i=0;i<9;i++){
            Button b= ((Button)griglia.findViewWithTag(i+""));
            b.setOnClickListener(gioco);
            if(colorate.containsKey(i))b.setBackgroundColor(colorate.get(i)=='X'? Color.parseColor("#FF0000"):Color.parseColor("#00FF00"));
        }
        if(savedInstanceState==null)gioco.gioca(iniziaX);


    }


    @Override
    public void update(Observable observable, Object o) {
        String op=(String)o;
        if(op.charAt(0)=='C'){
            ((Button)griglia.findViewWithTag(op.charAt(1)+"")).setBackgroundColor(op.charAt(2)=='X'? Color.parseColor("#FF0000"):Color.parseColor("#00FF00"));
        }else if(op.charAt(0)=='V'){
            if(op.charAt(1)=='X'){
                vittorieX++;
                Toast.makeText(CampoTrisActivity.this,"Vince X",Toast.LENGTH_LONG).show();
                vX.setText("Vittorie X:"+vittorieX);
            }
            else {
                vittorieO++;
                Toast.makeText(CampoTrisActivity.this,"Vince O",Toast.LENGTH_LONG).show();
                vO.setText("Vittorie O:"+vittorieO);
            }
            iniziaX=!iniziaX;
            inizializzaGriglia();
            gioco.gioca(iniziaX);
        }else if(op.charAt(0)=='P'){
            Toast.makeText(CampoTrisActivity.this,"Pareggio",Toast.LENGTH_LONG).show();
            iniziaX=!iniziaX;
            inizializzaGriglia();
            gioco.gioca(iniziaX);
        }
    }

    public void inizializzaGriglia(){
        for(int i=0;i<9;i++){
            ((Button)griglia.findViewWithTag(i+"")).setBackgroundResource(R.drawable.background_button);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putBoolean("is1vs1", is1vs1);
        savedInstanceState.putBoolean("iniziaX",iniziaX);
        savedInstanceState.putInt("vittorieX",vittorieX);
        savedInstanceState.putInt("vittorieO",vittorieO);
        savedInstanceState.putSerializable("gioco",gioco);
    }
}
