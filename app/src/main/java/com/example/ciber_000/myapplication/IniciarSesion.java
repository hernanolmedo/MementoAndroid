package com.example.ciber_000.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class IniciarSesion extends Activity {

    EditText txtUsuario,txtClave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUsuario=(EditText)findViewById(R.id.txtUsuario);
        txtClave=(EditText)findViewById(R.id.txtClave);
        registrarButton();
        ingresarButton();
    }

    private void registrarButton(){
        Button regButton=(Button)findViewById(R.id.registrar);
        regButton.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             startActivity(new Intent(IniciarSesion.this, Registro.class));
                                         }
                                     }
        );

    }

    private void ingresarButton(){
        Button regButton=(Button)findViewById(R.id.ingresar);
        regButton.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             MyTask task = new MyTask();
                                             task.execute("http://localhost:8080/tdb-java-master/inicio/" + txtUsuario.getText().toString() + "/" + txtClave.getText().toString());
                                         }
                                     }
        );
    }

    private class MyTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            HttpManager hm=new HttpManager();
            return hm.getData(params[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            Intent intent = new Intent(IniciarSesion.this, Menu.class);
            Bundle b = new Bundle();
            b.putString("msj", result);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }
    }
}
