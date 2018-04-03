package com.example.clementlaselva.irregularverbs;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import android.app.ProgressDialog;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.*;


public class Accueil extends AppCompatActivity {
    Button fadeOutEnlargeButton;

    Animation fadeOutEnlargeAnimation;
    private String TAG = Accueil.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        final EditText saisie =  findViewById(R.id.editText);
        /*Appel des fragments
        if (savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragAffiche, new FragmentTableSaisie()) .commit();
        }*/

        // ANIMATION
        fadeOutEnlargeAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out_enlarge);
        fadeOutEnlargeButton = findViewById(R.id.fadeOutEnlargeButton);
        fadeOutEnlargeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fadeOutEnlargeAnimation.setDuration(2000);
                fadeOutEnlargeButton.startAnimation(fadeOutEnlargeAnimation);
                fadeOutEnlargeButton.setVisibility(View.INVISIBLE);
            }
        });

        fadeOutEnlargeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Accueil.this , reponse.class);
                intent.putExtra("saisie", "saisie");
                startActivity(intent);
            }
        });
    }

}

