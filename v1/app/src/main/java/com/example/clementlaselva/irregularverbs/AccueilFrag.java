package com.example.clementlaselva.irregularverbs;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by LOUIS on 04/04/2018.
 */

public class AccueilFrag extends Fragment {

    @Override //Création de la vue du fragement
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.activity_accueil, container, false);
    }

    //Sauvegarde
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

    }

    @Override //Destrucion du frag
    public void onDestroy(){
        super.onDestroy();
    }
}
