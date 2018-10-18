package com.example.user.listviewimagenes;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;

/**
 * Created by USER on 13/09/2016.
 */
public class AdaptadorListado extends ArrayAdapter<String> {

    /*Metodo 1*/
    /*
    private Activity activity;
    private String listaNombres[];
    private String listaImagenes[];
    private LayoutInflater layoutInflater;

    public AdaptadorListado(Activity activity, String listaNombres[], String listaImagenes[]) {
        super(activity, R.layout.item_lista, listaNombres);

        this.activity = activity;
        this.listaNombres = listaNombres;
        this.listaImagenes = listaImagenes;

        layoutInflater = LayoutInflater.from(activity);
    }

    @Override
    public View getView(int posicion, View vista, ViewGroup parent) {
        ViewHolder holder;
        if (vista == null) {
            vista = layoutInflater.inflate(R.layout.item_lista, null);
            holder = new ViewHolder();
            holder.imgImagen = (ImageView) vista.findViewById(R.id.imgImagen);
            holder.txtTitulo = (TextView) vista.findViewById(R.id.txtTitulo);
            holder.txtDescripcion = (TextView) vista.findViewById(R.id.txtDescripcion);
            vista.setTag(holder);
        } else {
            holder = (ViewHolder) vista.getTag();
        }

        if (holder.imgImagen != null) {
            holder.txtTitulo.setText(listaNombres[posicion]);
            new cargarImagen(holder.imgImagen).execute(listaImagenes[posicion]);
        }
        return vista;
    }

    class ViewHolder {
        ImageView imgImagen;
        TextView txtTitulo;
        TextView txtDescripcion;
    }
    */
    /*Metodo 1*/

     /*Metodo 2*/
     private Activity activity;
    private String listaNombres[];
    private String listaImagenes[];

    public AdaptadorListado(Activity activity, String listaNombres[], String listaImagenes[]) {
        super(activity, R.layout.item_lista, listaNombres);

        this.activity = activity;
        this.listaNombres = listaNombres;
        this.listaImagenes = listaImagenes;
    }

    @Override
    public View getView(int posicion, View vista, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View rootView = inflater.inflate(R.layout.item_lista, null);

        TextView txtTitulo = (TextView)rootView.findViewById(R.id.txtTitulo);
        TextView txtDescripcion = (TextView)rootView.findViewById(R.id.txtDescripcion);
        ImageView imgImagen = (ImageView) rootView.findViewById(R.id.imgImagen);

        txtTitulo.setText(listaNombres[posicion]);
        txtDescripcion.setText("Descripcion de " + listaNombres[posicion]);

        new cargarImagen(imgImagen).execute(listaImagenes[posicion]);

        return rootView;
    }
     /*Metodo 2*/

    private class cargarImagen extends AsyncTask<String, Void, Bitmap> {

        private final WeakReference<ImageView> imageViewReference;
        ProgressDialog pDialog;

        public cargarImagen(ImageView imageView) {
            // Use a WeakReference to ensure the ImageView can be garbage
            // collected
            imageViewReference = new WeakReference<ImageView>(imageView);
        }

        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(getContext());
            pDialog.setMessage("Descargando imagen...");
            pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            String imagenDescargar = params[0];
            Bitmap imagenDescargada = new Funciones().descargarImagen(imagenDescargar);
            return imagenDescargada;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            if (imageViewReference != null && result != null) {
                final ImageView imageView = imageViewReference.get();
                if (imageView != null) {
                    imageView.setImageBitmap(result);
                    pDialog.dismiss();
                }
            }
        }
    }
}
