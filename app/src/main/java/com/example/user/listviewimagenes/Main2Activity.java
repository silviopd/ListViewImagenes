package com.example.user.listviewimagenes;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    TextView titulo;
    WebView wvSitioWeb;
    Button btnRegresar;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle parametros = this.getIntent().getExtras();
        final String titu = parametros.getString("titulo");
        wvSitioWeb = (WebView) findViewById(R.id.wvSitioWeb);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);

        titulo = (TextView) findViewById(R.id.lblTitulo);
        titulo.setText(titu);

        //wvSitioWeb.loadUrl("http://definicion.mx/java/");

        //new cargarPagina().execute("http://www.desarrolloweb.com/articulos/497.php");

        dialog  = new ProgressDialog(Main2Activity.this);
        dialog.setMessage("Loading..Please wait.");
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        wvSitioWeb.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        });

        wvSitioWeb.loadUrl("http://www.desarrolloweb.com/articulos/497.php");
        WebSettings webSettings = wvSitioWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);

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
            pDialog = new ProgressDialog(Main2Activity.this);
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