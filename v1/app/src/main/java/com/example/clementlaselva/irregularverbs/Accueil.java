package com.example.clementlaselva.irregularverbs;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import android.app.ProgressDialog;
import android.database.DataSetObserver;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;


public class Accueil extends AppCompatActivity {
    Button fadeOutEnlargeButton;
    Animation fadeOutEnlargeAnimation;
    EditText bv1 =null ;
    //EditText bv;
    private String TAG = Accueil.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;


    private static String url = "http://www.clement-laselva.com/android/assets/verbes.json";

    private List<Verb> verbList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

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
        //list of verbs
        verbList = new ArrayList<Verb>();

        lv = (ListView) findViewById(R.id.list);
        bv1 = (EditText)findViewById(R.id.editText);
        //new GetVerbs().execute(); // méthode classe AsynTask
    }

    /**
     * Tache asynchrone

    private class GetVerbs extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(Accueil.this);
            pDialog.setMessage("Connexion en cours...");
            pDialog.setCancelable(false);
            pDialog.show();

        }
    }
    @Override
*/
    // appeler automatiquement après onPreExecute
    protected Void doInBackground(Void... arg0) {

        for (int progress = 0; progress  < 1000000000; progress++){
            // Ne fait rien mais fait juste passer du temps
        }


        HttpHandler sh = new HttpHandler();


        String jsonStr = sh.makeServiceCall(url);
        Log.d("Accueil",jsonStr);


        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                JSONArray verbs = jsonObj.getJSONArray("verbs");

                for (int i = 0; i < verbs.length(); i++) {
                    JSONObject c = verbs.getJSONObject(i);
                    String preterit = c.getString("preterit");
                    String pp = c.getString("pp");


                    Verb verb = new Verb(bv1,preterit,pp);

                    verbList.add(verb);
                }
            } catch (final JSONException e) {
                Log.e(TAG, "Erreur Json: " + e.getMessage());

            }
        } else {
            Log.e(TAG, "Pas de connexion.");
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);

        if (pDialog.isShowing())
            pDialog.dismiss();

        List<String> liste = new ArrayList<String>();
        for(int i= 0;i<verbList.size();i++)
            liste.add(verbList.get(i).toString());

        //PREVOIR UN ADAPTER AVEC list_item  PLUS JOLI !!!!!!!

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Accueil.this,android.R.layout.simple_list_item_1, liste);

        lv.setAdapter(adapter);

    }

}
