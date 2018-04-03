package com.example.clementlaselva.irregularverbs;



/**
 * Created by clementlaselva on 19/03/2018.
 */

        import android.app.ProgressDialog;
        import android.database.DataSetObserver;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ListAdapter;
        import android.widget.ListView;
        import android.widget.SimpleAdapter;
        import android.widget.Toast;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.ArrayList;
        import java.util.List;

public class reponse extends AppCompatActivity {
    String saisie = "be";
    private String TAG =reponse.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;


    private static String url = "http://www.clement-laselva.com/android/assets/verbes.json";

    private List<Verb> verbList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        verbList = new ArrayList<Verb>();

        lv = (ListView) findViewById(R.id.list);

        new GetVerbs().execute(); // méthode classe AsynTask
    }

    /**
     * Tache asynchrone
     */
    private class GetVerbs extends AsyncTask<Void, Void, Void> {

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


            /*for(int i= 0;i<verbList.size();i++){

                if (saisie ==  (verbList.get(i).getBv())){

                    liste.add(verbList.get(i).toString());

                }
               // liste.add(verbList.get(i).toString());

            }*/

            for(Verb list : verbList) {
                if (saisie.equals(list.getBv())) {
                    System.out.println(list.toString());
                }
            }




            ArrayAdapter<String> adapter = new ArrayAdapter<String>(reponse.this,android.R.layout.simple_list_item_1, liste);

            lv.setAdapter(adapter);

        }

    }
}