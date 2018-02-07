package com.example.enrico.tris;

import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Enrico on 04/02/2018.
 */

public class StatoTris implements Observer{

    enum StatoCasellaTris {

        Vuoto, X, O
    };

    private StatoCasellaTris[][] griglia;

    public StatoTris(){
        griglia=new StatoCasellaTris[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                griglia[i][j]=StatoCasellaTris.Vuoto;
            }
        }
    }

    public boolean isEmpty(int i,int j){
        return griglia[i][j]==StatoCasellaTris.Vuoto;
    }

    public boolean isX(int i,int j){
        return griglia[i][j]==StatoCasellaTris.X;
    }

    public boolean isO(int i,int j){
        return griglia[i][j]==StatoCasellaTris.O;
    }

    public HashMap<Integer,Character>getColorate(){
        HashMap<Integer,Character>ris=new HashMap<>();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(griglia[i][j]==StatoCasellaTris.X)ris.put(3*i+j,'X');
                else if(griglia[i][j]==StatoCasellaTris.O)ris.put(3*i+j,'O');
            }
        }
        return ris;
    }

    public boolean isVittoria(String g) {
        boolean vinto = false;
        StatoCasellaTris giocatore=(g.equals("X")?StatoCasellaTris.X:StatoCasellaTris.O);
        for (int i = 0; i < 3 && !vinto; i++) {
            int j = 0;
            while (griglia[i][j] == giocatore && j < 2) {
                j++;
            }
            vinto = j == 2 && griglia[i][2] == giocatore;
            j = 0;
            while (griglia[j][i] == giocatore && j < 2 && !vinto) {
                j++;
            }
            vinto = j == 2 && griglia[2][i] == giocatore || vinto;
        }
        int i = 0;
        while (griglia[i][i] == giocatore && !vinto && i < 2) {
            i++;
        }
        vinto = (i == 2 && griglia[2][2] == giocatore) || vinto;
        i = 0;
        while (griglia[i][2 - i] == giocatore && !vinto && i < 2) {
            i++;
        }
        vinto = (i == 2 && griglia[2][0] == giocatore) || vinto;
        return vinto;
    }

    @Override
    public void update(Observable observable, Object o) {
        String op=(String)o;
        if(op.charAt(0)=='X'||op.charAt(0)=='O'){
            StatoCasellaTris stato=(op.charAt(0)=='X'?StatoCasellaTris.X:StatoCasellaTris.O);
            int pos=op.charAt(1)-'0';
            int i=pos/3,j=pos%3;
            griglia[i][j]=stato;
        }
    }

}
