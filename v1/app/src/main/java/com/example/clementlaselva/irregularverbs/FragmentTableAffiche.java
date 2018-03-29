package com.example.clementlaselva.irregularverbs;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LOUIS on 29/03/2018.
 */

public class FragmentTableAffiche extends Fragment {
    View rootView;
    int valeurTable;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //récupération de la valeur de la table
        Bundle b = getArguments();
        //Log.d("FragmentTableAffichee()",".onCreate()=>   getArguments()="+getArguments());
        if(b!=null)
        {
            valeurTable = getArguments().getInt("table");
        }
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_affichage, null);
        afficherTable();
        return rootView;
    }

    public void afficherTable(){
        List<String> list = new ArrayList<String>();
        int resu;
        String s="";
        for(int i=1;i<=20;i++)
        {
            resu=valeurTable*i;
            s+= String.valueOf(i)+ " "+ "* " + String.valueOf(valeurTable)+" = "+String.valueOf(resu);
            list.add(s);
            s="";
        }

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>( getActivity(), android.R.layout.simple_list_item_1, list);

        ListView listV = (ListView) rootView.findViewById(R.id.list);

        //On passe nos données au composant ListView
        System.out.println("DEBUG avant SETADAPTER");
        listV.setAdapter(adapter);
    }
}

