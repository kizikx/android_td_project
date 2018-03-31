package com.example.clementlaselva.irregularverbs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * Created by LOUIS on 29/03/2018.
 */


public class FragmentTableSaisie extends Fragment {


    Fragment frag;
    FragmentTransaction fragTransaction;


    @Override
    public void setTargetFragment(Fragment fragment, int requestCode) {
        //TODO
    }



    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_accueil, container, false);


        final EditText valeur = (EditText) rootView.findViewById(R.id.editText);


        valeur.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) { }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int longueur = valeur.getText().length();
                if (longueur != 0) {
                    String saisie = valeur.getText().toString();
                    int table = Integer.parseInt(saisie);

                    //frag = new FragmentTableAffichee(table);
                    frag = new FragmentTableAffiche();
                    Bundle args = new Bundle();
                    args.putInt("table", table);
                    frag.setArguments(args);

                    fragTransaction = getFragmentManager().beginTransaction().replace(R.id.fragAffiche, frag);
                    fragTransaction.commit();
                }
            }
        });

        return rootView;
    }








}