package com.example.user.listviewimagenes;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String listaNombres[] = {"Java", "PHP", "Python", "JavaScript", "Ruby", "C"};
    private String listaImagenes[] = {
                                    "http://progra2.herokuapp.com/imgs-lang/java.png",
                                    "http://progra2.herokuapp.com/imgs-lang/php.png",
                                    "http://progra2.herokuapp.com/imgs-lang/python.png",
                                    "http://progra2.herokuapp.com/imgs-lang/javascript.png",
                                    "http://progra2.herokuapp.com/imgs-lang/ruby.png",
                                    "http://progra2.herokuapp.com/imgs-lang/c.png"
                                    };

    ListView lvListado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Funciones.habilitarDirectivasInternet();

        lvListado = (ListView) findViewById(R.id.lvListado);
        AdaptadorListado adaptadorListado = new AdaptadorListado(this,listaNombres,listaImagenes);
        lvListado.setAdapter(adaptadorListado);


        lvListado.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView v = (TextView)view.findViewById(R.id.txtTitulo);

        //Toast.makeText(MainActivity.this, v.getText() + "  ",Toast.LENGTH_SHORT).show();
        if (v.getText().equals("Java")){
            Intent pantalla2 = new Intent(this, Main2Activity.class);
            Bundle parametros = new Bundle();
            parametros.putString("titulo",v.getText().toString());
            pantalla2.putExtras(parametros);
            startActivity(pantalla2);
        }else if (v.getText().equals("PHP")){
            Intent pantalla2 = new Intent(this, Main3Activity.class);
            Bundle parametros = new Bundle();
            parametros.putString("titulo",v.getText().toString());
            pantalla2.putExtras(parametros);
            startActivity(pantalla2);
        }else if (v.getText().equals("Python")){
            Intent pantalla2 = new Intent(this, Main4Activity.class);
            Bundle parametros = new Bundle();
            parametros.putString("titulo",v.getText().toString());
            pantalla2.putExtras(parametros);
            startActivity(pantalla2);
        }else if (v.getText().equals("JavaScript")){
            Intent pantalla2 = new Intent(this, Main5Activity.class);
            Bundle parametros = new Bundle();
            parametros.putString("titulo",v.getText().toString());
            pantalla2.putExtras(parametros);
            startActivity(pantalla2);
        }else if (v.getText().equals("Ruby")){
            Intent pantalla2 = new Intent(this, Main6Activity.class);
            Bundle parametros = new Bundle();
            parametros.putString("titulo",v.getText().toString());
            pantalla2.putExtras(parametros);
            startActivity(pantalla2);
        }else if (v.getText().equals("C")){
            Intent pantalla2 = new Intent(this, Main7Activity.class);
            Bundle parametros = new Bundle();
            parametros.putString("titulo",v.getText().toString());
            pantalla2.putExtras(parametros);
            startActivity(pantalla2);
        }
    }

    /*
    private class cargarImagenes extends AsyncTask<Void,Void,AdaptadorListado>{

        ProgressDialog pDialog ;

        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Descargando imagenes...");
            pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pDialog.show();
        }

        @Override
        protected AdaptadorListado doInBackground(Void... voids) {
            AdaptadorListado adaptadorListado = new AdaptadorListado(MainActivity.this,listaNombres,listaImagenes);
            return adaptadorListado;
        }

        @Override
        protected void onPostExecute(AdaptadorListado adaptadorListado) {
            lvListado.setAdapter(adaptadorListado);

            pDialog.dismiss();
        }
    }
    */


}
