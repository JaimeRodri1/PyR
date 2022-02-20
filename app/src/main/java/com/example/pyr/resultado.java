package com.example.pyr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class resultado extends AppCompatActivity {

    private TextView puntaj;
    private TextView A;
    private TextView F;
    private Button salir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        puntaj=(TextView) findViewById(R.id.result);
        salir=(Button) findViewById(R.id.exit);
        A = (TextView) findViewById(R.id.acier);
        F = (TextView) findViewById(R.id.Fails);


        Bundle extras = getIntent().getExtras();
        int n1 = extras.getInt("puntaje");
        int n2 = extras.getInt("aciertos");
        int n3 = extras.getInt("fallos");
        puntaj.setText(String.valueOf(n1));
        A.setText(String.valueOf(n2));
        F.setText(String.valueOf(n3));
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}