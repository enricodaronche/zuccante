package com.drdre.dado;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    float x1,x2,y1,y2;

    final static float MIN_DISTANCE = 150.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentStart fragmentStart=new FragmentStart();
        FragmentTransaction ft=getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment,fragmentStart);
        ft.commit();
    }

    public boolean onTouchEvent(MotionEvent event){
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1=event.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                y2=event.getY();
                float deltaX = Math.abs(x2 - x1),deltaY=Math.abs(y2-y1);
                if(deltaX>MIN_DISTANCE&&deltaX>deltaY){
                    changeFragment(x2>x1?1:2);
                }else if(deltaY>MIN_DISTANCE&&deltaY>deltaX){
                    changeFragment(y2>y1?3:4);
                }
        }
        return super.onTouchEvent(event);
    }

public void changeFragment(int cod){
            FragmentManager fm=getFragmentManager();
            Fragment currentFragment=fm.findFragmentById(R.id.fragment);
            int x=0;
            if(currentFragment instanceof FragmentFaccia){
                x = ((FragmentFaccia)currentFragment).getN();
            }
            FragmentFaccia nextFragment=FragmentFaccia.newInstance(x);
            FragmentTransaction ft = fm.beginTransaction();
            switch(cod){
                case 1:
                    ft.setCustomAnimations(R.animator.slide_linear_left_in,R.animator.slide_linear_right_out);
                    break;
                case 2:
                    ft.setCustomAnimations(R.animator.slide_linear_right_in,R.animator.slide_linear_left_out);
                    break;
                case 3:
                    ft.setCustomAnimations(R.animator.slide_linear_down_in,R.animator.slide_linear_up_out);
                    break;
                case 4:
                    ft.setCustomAnimations(R.animator.slide_linear_up_in,R.animator.slide_linear_down_out);
            }
            ft.replace(R.id.fragment,nextFragment);
            ft.commit();
    }
}
