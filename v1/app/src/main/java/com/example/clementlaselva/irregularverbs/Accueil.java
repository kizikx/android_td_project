package com.example.clementlaselva.irregularverbs;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


public class Accueil extends AppCompatActivity {
    Button fadeOutEnlargeButton;
    Animation fadeOutEnlargeAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

       // p = getPreferences(Context.MODE_PRIVATE);
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

    }
}