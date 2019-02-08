//C'est le projet non terminé javais dévéloppé un projet complet mais je l'ai perdu
package com.example.myapplication;

import android.util.Log;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by Salim loudement on 11/02/2016.
 */
public class sms extends Thread implements Runnable {

    public void run() {


        URL url;
        HttpURLConnection urlConnection = null;
        try {
            Log.d("coucou","coucou");
            url = new URL("http://172.17.0.40/html/a2mm/salim.loudement/sms/test.php");

            urlConnection = (HttpURLConnection) url
                    .openConnection();

            InputStream in = urlConnection.getInputStream();

          DataInputStream di=new DataInputStream(in);
          String l=di.readLine();
            System.out.println(l);


            Log.d("resu", "fin");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                Log.d("oups","fin");
                urlConnection.disconnect();
            }
        }

    }
}