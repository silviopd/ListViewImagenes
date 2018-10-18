package com.example.user.listviewimagenes;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener {

    TextView titulo;
    WebView wvSitioWeb;
    Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Bundle parametros = this.getIntent().getExtras();
        final String titu = parametros.getString("titulo");
        wvSitioWeb = (WebView) findViewById(R.id.wvSitioWeb);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);

        titulo = (TextView) findViewById(R.id.lblTitulo);
        titulo.setText(titu);

        //wvSitioWeb.loadUrl("http://definicion.mx/java/");

        new cargarPagina().execute("http://www.desarrolloweb.com/articulos/1325.php");

        this.setTitle(titu);
        btnRegresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent pantalla2 = new Intent(this, MainActivity.class);
        startActivity(pantalla2);
    }


    private class cargarPagina extends AsyncTask<String, Void, String> {

        ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(Main4Activity.this);
            pDialog.setTitle("Cargando pagina...");
            pDialog.setMessage("espere por favor...");
            pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            return params[0];
        }

        @Override
        protected void onPostExecute(String result) {
            wvSitioWeb.loadUrl(result);

            pDialog.dismiss();
        }
    }

}