package com.example.clementlaselva.irregularverbs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class Accueil extends AppCompatActivity {
    private static final String ANIM_LEGNTH_PREF = "dureeanimation";
    private int dureeanimation;



    protected void creerEcouterDuBouton(Button b, final int animationAjouter ) {
        b.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(
                        Accueil.this, animationAjouter));
                v.setVisibility(View.INVISIBLE);
            }
        });
    }
}