package com.example.ciber_000.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;


public class Menu extends Activity{

    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Bundle b = getIntent().getExtras();
        String mensaje = b.getString("msj");
        output.append(mensaje+"\n");
    }
}
