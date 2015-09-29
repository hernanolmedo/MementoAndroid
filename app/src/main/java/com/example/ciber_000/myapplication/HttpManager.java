package com.example.ciber_000.myapplication;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class HttpManager {

    public String getData(String uri) {

        BufferedReader reader=null;

        try{
            URL url = new URL(uri);
            HttpURLConnection con= (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");

            Log.d("Content type " , con.getContentType());
            Log.d("Content encoding " , con.getContentEncoding());
            Log.d("Date " , new Date(con.getDate()).toString());
            Log.d("Last modified " , new Date(con.getLastModified()).toString());
            Log.d("Expiration date " , new Date(con.getExpiration()).toString());
            Log.d("Content length ", "Content length "+con.getContentLength());

            con.getResponseCode();
            con.getResponseMessage();
            con.setRequestMethod("GET");

            StringBuilder sb=new StringBuilder();
            reader=new BufferedReader( new InputStreamReader(con.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line+"\n");
            }
            return sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally{
            if(reader!=null){
                try {
                    reader.close();
                }catch(IOException e){
                    e.printStackTrace();
                    return null;
                }
            }
        }

    }
}
