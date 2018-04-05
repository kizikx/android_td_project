package com.example.clementlaselva.irregularverbs;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LOUIS on 04/04/2018.
 */

public class ReponseFrag extends Fragment {

    String s;

    private String saisie = null;

    private String TAG =reponse.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;


    private static String url = "http://www.clement-laselva.com/android/assets/verbes.json";

    private List<Verb> verbList;

    @Override //Création de la vue du fragement
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        /*Bundle b = this.getArguments();
        if(b != null){
            s = b.getString("arg");
            System.out.println(s);
        }*/

        return inflater.inflate(R.layout.activity2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

    }

    @Override //Destrucion du frag
    public void onDestroy(){
        super.onDestroy();
    }

   /* private class GetVerbs extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(reponse.this);
            pDialog.setMessage("Connexion en cours...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override

        // appeler automatiquement après onPreExecute
        protected Void doInBackground(Void... arg0) {

            for (int progress = 0; progress  < 1000000000; progress++){
                // Ne fait rien mais fait juste passer du temps
            }


            HttpHandler sh = new HttpHandler();


            String jsonStr = sh.makeServiceCall(url);
            //Log.d("MainActivity",jsonStr);


            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    JSONArray verbes = jsonObj.getJSONArray("verbes");

                    for (int i = 0; i < verbes.length(); i++) {
                        JSONObject c = verbes.getJSONObject(i);
                        String bv = c.getString("bv");
                        String preterit = c.getString("preterit");

                        //JSONObject geometry = c.getJSONObject("geometry");
                        //JSONObject coordonnes = geometry.getString("coordinates");
                        String pp = c.getString("pp");


                        // String coordinates = geometry.getString("coordinates");

                        Verb verb = new Verb(bv,preterit,pp);

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

           */
   /*
            for(Verb list : verbList) {
                if (saisie.equals(list.getBv()) ) {
                    System.out.println(list.toString());
                    liste.add(list.toString());
                }
            }
            if((liste.isEmpty()) && (saisie != "vide")){
                for(Verb list : verbList) {
                    if(!saisie.equals(list.getBv())){
                        System.out.println(saisie + "ed");
                        liste.add(saisie + "ed");
                        break;
                    }
                }
            }


            ArrayAdapter<String> adapter = new ArrayAdapter<String>(reponse.this,android.R.layout.simple_list_item_1, liste);

            lv.setAdapter(adapter);

        }

    }*/
}
