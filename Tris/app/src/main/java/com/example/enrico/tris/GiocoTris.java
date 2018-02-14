package com.example.enrico.tris;

import android.view.View;
import java.io.Serializable;
import java.util.Observable;

/**
 * Created by Enrico on 04/02/2018.
 */

public class GiocoTris extends Observable implements View.OnClickListener,Serializable{

    private boolean is1vs1;
    private boolean turnoX;
    private StatoTris statoTris;
    private int contMosse;

    public GiocoTris(boolean is1vs1,CampoTrisActivity vista){
        this.is1vs1=is1vs1;
        addObserver(vista);
    }

    public boolean getTurnoX(){
        return turnoX;
    }

    public void setTurnoX(boolean turnoX){
        this.turnoX=turnoX;
    }

    public int getContMosse(){
        return contMosse;
    }

    public void setContMosse(int contMosse){
        this.contMosse=contMosse;
    }

    public StatoTris getStatoTris(){
        return statoTris;
    }

    public void setStatoTris(StatoTris statoTris){
        this.statoTris=statoTris;
        setChanged();
        addObserver(this.statoTris);
    }

    public void gioca(boolean iniziaX){
        this.turnoX=iniziaX;
        statoTris=new StatoTris();
        contMosse=0;
        addObserver(statoTris);
        if(!turnoX&&!is1vs1){
            int pos=mossaMacchina();
            setChanged();
            notifyObservers((turnoX?"X":"O")+pos);
            setChanged();
            notifyObservers("C"+pos+(turnoX?"X":"O"));
            contMosse++;
            turnoX=!turnoX;
        }
    }

    @Override
    public void onClick(View view) {
        int pos=Integer.parseInt((String)view.getTag());
        if(statoTris.isEmpty(pos/3,pos%3)) {
            setChanged();
            notifyObservers((turnoX?"X":"O")+pos);
            setChanged();
            notifyObservers("C"+pos+(turnoX?"X":"O"));
            contMosse++;
            if(statoTris.isVittoria(turnoX?"X":"O")){
                setChanged();
                notifyObservers("V"+(turnoX?"X":"O"));
            }else if(contMosse==9) {
                setChanged();
                notifyObservers("P");
            }else{
                turnoX=!turnoX;
                if(!is1vs1){
                    pos=mossaMacchina();
                    setChanged();
                    notifyObservers((turnoX?"X":"O")+pos);
                    setChanged();
                    notifyObservers("C"+pos+(turnoX?"X":"O"));
                    contMosse++;
                    if(statoTris.isVittoria(turnoX?"X":"O")){
                        setChanged();
                        notifyObservers("V"+(turnoX?"X":"O"));
                    }else if(contMosse==9){
                        setChanged();
                        notifyObservers("P");
                    }else turnoX=!turnoX;
                }
            }
        }
    }

    public int mossaMacchina(){
        int pos = -1;
        int contX, contO;
        for (int i = 0; i < 3 && pos < 0; i++) {
            contX = 0;
            contO = 0;
            for (int j = 0; j < 3; j++) {
                if (statoTris.isX(i,j)) {
                    contX++;
                }
                if (statoTris.isO(i,j)) {
                    contO++;
                }
            }
            if (contO == 2 && contX == 0) {
                for (int j = 0; j < 3 && pos < 0; j++) {
                    if (statoTris.isEmpty(i,j)) {
                        pos =  3*i+j;
                    }
                }
            }
        }
        for (int i = 0; i < 3 && pos < 0; i++) {
            contX = 0;
            contO = 0;
            for (int j = 0; j < 3; j++) {
                if (statoTris.isX(j,i)) {
                    contX++;
                }
                if (statoTris.isO(j,i)) {
                    contO++;
                }
            }
            if (contO == 2 && contX == 0) {
                for (int j = 0; j < 3 && pos < 0; j++) {
                    if (statoTris.isEmpty(j,i)) {
                        pos = 3*j+i;
                    }
                }
            }
        }
        contX = 0;
        contO = 0;
        for (int i = 0; i < 3 && pos < 0; i++) {
            if (statoTris.isX(i,i)) {
                contX++;
            }
            if (statoTris.isO(i,i)) {
                contO++;
            }
        }
        if (contO == 2 && contX == 0) {
            for (int i = 0; i < 3 && pos < 0; i++) {
                if (statoTris.isEmpty(i,i)) {
                    pos = 4*i;
                }
            }
        }
        contX = 0;
        contO = 0;
        for (int i = 0; i < 3 && pos < 0; i++) {
            if (statoTris.isX(i,2-i)) {
                contX++;
            }
            if (statoTris.isO(i,2-i)) {
                contO++;
            }
        }
        if (contO == 2 && contX == 0) {
            for (int i = 0; i < 3 && pos < 0; i++) {
                if (statoTris.isEmpty(i,2-i)) {
                    pos = 2*(i+1);
                }
            }
        }
        for (int i = 0; i < 3 && pos < 0; i++) {
            contX = 0;
            contO = 0;
            for (int j = 0; j < 3; j++) {
                if (statoTris.isX(i,j)) {
                    contX++;
                }
                if (statoTris.isO(i,j)) {
                    contO++;
                }
            }
            if (contX == 2 && contO == 0) {
                for (int j = 0; j < 3 && pos < 0; j++) {
                    if (statoTris.isEmpty(i,j)) {
                        pos = 3*i+j;
                    }
                }
            }
        }
        for (int i = 0; i < 3 && pos < 0; i++) {
            contX = 0;
            contO = 0;
            for (int j = 0; j < 3; j++) {
                if (statoTris.isX(j,i)) {
                    contX++;
                }
                if (statoTris.isO(j,i)) {
                    contO++;
                }
            }
            if (contX == 2 && contO == 0) {
                for (int j = 0; j < 3 && pos < 0; j++) {
                    if (statoTris.isEmpty(j,i)) {
                        pos = 3*j+i;
                    }
                }
            }
        }
        contX = 0;
        contO = 0;
        for (int i = 0; i < 3 && pos < 0; i++) {
            if (statoTris.isX(i,i)) {
                contX++;
            }
            if (statoTris.isO(i,i)) {
                contO++;
            }
        }
        if (contX == 2 && contO == 0) {
            for (int i = 0; i < 3 && pos < 0; i++) {
                if (statoTris.isEmpty(i,i)) {
                    pos =  4*i;
                }
            }
        }
        contX = 0;
        contO = 0;
        for (int i = 0; i < 3 && pos < 0; i++) {
            if (statoTris.isX(i,2-i)) {
                contX++;
            }
            if (statoTris.isO(i,2-i)) {
                contO++;
            }
        }
        if (contX == 2 && contO == 0) {
            for (int i = 0; i < 3 && pos < 0; i++) {
                if (statoTris.isEmpty(i,2-i)) {
                    pos = 2*(i+1);
                }
            }
        }
        while (pos < 0) {
            int i = (int)(Math.random()*3);
            int j = (int)(Math.random()*3);
            if (statoTris.isEmpty(i,j)) {
                pos = 3*i+j;
            }
        }
        return pos;
    }

}
