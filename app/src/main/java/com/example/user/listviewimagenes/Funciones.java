package com.example.user.listviewimagenes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.StrictMode;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by hmera on 13/09/2016.
 */
public class Funciones {

    public Bitmap descargarImagen (String direccion){
        URL imageUrl = null;
        Bitmap imagen = null;
        try{
            imageUrl = new URL(direccion);
            HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
            conn.connect();
            imagen = BitmapFactory.decodeStream(conn.getInputStream());
        }catch(IOException ex){
            ex.printStackTrace();
        }

        return imagen;
    }

    public static void habilitarDirectivasInternet(){
        /*Si la versión del SO es superior a la versión de GINGERBARD, entonces habilita una politica especial para conectarse a internet*/
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        /*Si la versión del SO es superior a la versión de GINGERBARD, entonces habilita una politica especial para conectarse a internet*/
    }




}
