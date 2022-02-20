package com.example.pyr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class resultado extends AppCompatActivity {

    private TextView puntaj;
    private Button salir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        puntaj=(TextView) findViewById(R.id.result);
        salir=(Button) findViewById(R.id.exit);


        Bundle extras = getIntent().getExtras();
        int n1 = extras.getInt("puntaje");
        puntaj.setText(String.valueOf(n1));
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}