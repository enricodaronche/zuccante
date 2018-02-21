package com.drdre.dado;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentFaccia extends Fragment {

    private int n;

    public static FragmentFaccia newInstance(int x){
        int n=0;
        do{
            n=(int)(Math.random()*6+1);
        }while(n==x);
        Bundle bundle=new Bundle();
        bundle.putInt("n",n);
        FragmentFaccia ris=new FragmentFaccia();
        ris.setArguments(bundle);
        return ris;
    }

    public int getN(){
        return n;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View ris= inflater.inflate(R.layout.fragment_fragment_faccia, container, false);

        Bundle args=getArguments();
        n=args.getInt("n");
        switch(n){
            case 1:
                ris.findViewById(R.id.c1).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c2).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c3).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c4).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c5).setVisibility(View.VISIBLE);
                ris.findViewById(R.id.c6).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c7).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c8).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c9).setVisibility(View.INVISIBLE);
                break;
            case 2:
                ris.findViewById(R.id.c1).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c2).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c3).setVisibility(View.VISIBLE);
                ris.findViewById(R.id.c4).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c5).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c6).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c7).setVisibility(View.VISIBLE);
                ris.findViewById(R.id.c8).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c9).setVisibility(View.INVISIBLE);
                break;
            case 3:
                ris.findViewById(R.id.c1).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c2).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c3).setVisibility(View.VISIBLE);
                ris.findViewById(R.id.c4).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c5).setVisibility(View.VISIBLE);
                ris.findViewById(R.id.c6).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c7).setVisibility(View.VISIBLE);
                ris.findViewById(R.id.c8).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c9).setVisibility(View.INVISIBLE);
                break;
            case 4:
                ris.findViewById(R.id.c1).setVisibility(View.VISIBLE);
                ris.findViewById(R.id.c2).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c3).setVisibility(View.VISIBLE);
                ris.findViewById(R.id.c4).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c5).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c6).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c7).setVisibility(View.VISIBLE);
                ris.findViewById(R.id.c8).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c9).setVisibility(View.VISIBLE);
                break;
            case 5:
                ris.findViewById(R.id.c1).setVisibility(View.VISIBLE);
                ris.findViewById(R.id.c2).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c3).setVisibility(View.VISIBLE);
                ris.findViewById(R.id.c4).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c5).setVisibility(View.VISIBLE);
                ris.findViewById(R.id.c6).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c7).setVisibility(View.VISIBLE);
                ris.findViewById(R.id.c8).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c9).setVisibility(View.VISIBLE);
                break;
            case 6:
                ris.findViewById(R.id.c1).setVisibility(View.VISIBLE);
                ris.findViewById(R.id.c2).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c3).setVisibility(View.VISIBLE);
                ris.findViewById(R.id.c4).setVisibility(View.VISIBLE);
                ris.findViewById(R.id.c5).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c6).setVisibility(View.VISIBLE);
                ris.findViewById(R.id.c7).setVisibility(View.VISIBLE);
                ris.findViewById(R.id.c8).setVisibility(View.INVISIBLE);
                ris.findViewById(R.id.c9).setVisibility(View.VISIBLE);
                break;
        }
        return ris;
    }
}
