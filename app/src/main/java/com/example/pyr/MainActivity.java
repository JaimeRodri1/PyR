package com.example.pyr;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ImageView band;
    private ImageView ini;
    private TextView Pre;
    private RadioButton p1;
    private RadioButton p2;
    private RadioButton p3;
    private Button emp;
    private Button btnS;
    private RadioGroup selec;
    int contador = 1;
    int puntaje = 0;
    int N;
    int F;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        band = (ImageView) findViewById(R.id.Bandera);
        ini= (ImageView) findViewById(R.id.IVinicio);
        Pre = (TextView) findViewById(R.id.pregunta);
        emp = (Button) findViewById(R.id.empezar);
        btnS = (Button) findViewById(R.id.btnsigue);
        selec = findViewById(R.id.selec);



        p1= findViewById(R.id.RB1);
        p2= findViewById(R.id.RB2);
        p3= findViewById(R.id.RB3);


        imprimir();


        p1.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.white));
        p2.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.white));
        p3.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.white));

        Pre.setVisibility(View.GONE);
        p1.setVisibility(View.GONE);
        p2.setVisibility(View.GONE);
        p3.setVisibility(View.GONE);
        band.setVisibility(View.GONE);
        btnS.setVisibility(View.GONE);


        btnS.setEnabled(false);

        emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pre.setVisibility(View.VISIBLE);
                p1.setVisibility(View.VISIBLE);
                p2.setVisibility(View.VISIBLE);
                p3.setVisibility(View.VISIBLE);
                band.setVisibility(View.VISIBLE);
                btnS.setVisibility(View.VISIBLE);
                emp.setVisibility(View.GONE);
                ini.setVisibility(View.GONE);
            }
        });
        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                evaluarRespuestas();
                contador++;
                imprimir();


            }
        });
        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (p1.isChecked()){
                    btnS.setEnabled(true);
                }
                else{
                    btnS.setEnabled(false);
                }
            }
        });
        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (p2.isChecked()){
                    btnS.setEnabled(true);
                }
                else{
                    btnS.setEnabled(false);
                }
            }
        });
        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (p3.isChecked()){
                    btnS.setEnabled(true);
                }
                else{
                    btnS.setEnabled(false);
                }
            }
        });
    }




    public void evaluarRespuestas(){

        if (contador==1){
            if (p2.isChecked()==true){
                puntaje = puntaje + 1;
                N++;
            }
            else{
                puntaje= puntaje-2;
                F++;
            }
        }

        if (contador==2){
            if (p3.isChecked()==true){
                puntaje = puntaje+1;
                N++;
            }
            else{
                puntaje= puntaje - 2;
                F++;
            }
        }
        if (contador==3){
            if (p2.isChecked()==true){
                puntaje = puntaje + 1;
                N++;
            }
            else{
                puntaje= puntaje - 2;
                F++;
            }
        }
        if (contador==4){
            if (p3.isChecked()==true){
                puntaje = puntaje + 1;
                N++;
            }
            else{
                puntaje= puntaje - 2;
                F++;
            }
        }

    }
    public void imprimir() {

        if (contador==1){
            selec.clearCheck();
            p1.setText("China");
            p2.setText("Alemania");
            p3.setText("Brazil");
            band.setImageResource(R.drawable.ale);
        }

        if (contador==2){
            selec.clearCheck();
            p1.setText("Chile");
            p2.setText("Dinamarca");
            p3.setText("Belice");
            band.setImageResource(R.drawable.belic);
            btnS.setEnabled(false);
        }
        if (contador==3){
            selec.clearCheck();
            p1.setText("Argentina");
            p2.setText("Brazil");
            p3.setText("China");
            band.setImageResource(R.drawable.bra);
            btnS.setEnabled(false);
        }
        if (contador==4){
            selec.clearCheck();
            p1.setText("Chile");
            p2.setText("Dinamarca");
            p3.setText("Argentina");
            band.setImageResource(R.drawable.arge);
            btnS.setEnabled(false);
        }
        if (contador>4){
            selec.clearCheck();
            Intent d = new Intent(getApplicationContext(),resultado.class);
            d.putExtra("puntaje",puntaje);
            d.putExtra("aciertos",N);
            d.putExtra("fallos",F);
            startActivity(d);
            finish();
        }
    }
}