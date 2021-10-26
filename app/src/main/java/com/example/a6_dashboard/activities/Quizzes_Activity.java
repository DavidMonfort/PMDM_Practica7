package com.example.a6_dashboard.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a6_dashboard.R;

import java.util.ArrayList;

public class Quizzes_Activity extends AppCompatActivity {

    Button button;
    TextView txtEnunciado;
    RadioButton txtResultado1;
    RadioButton txtResultado2;
    TextView txtNumPreguntas;
    boolean respuestaNoSeleccionada = true;
    boolean respuestaSeleccionada;
    int respuestasCorrectas = 0;
    ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
    Pregunta pregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizzes);

        //Controla si ha jugado ya o no o si le ha dado a nuevo juego
        if (getIntent().getExtras()!=null) {
            Bundle extras = getIntent().getExtras();
            if (extras.getBoolean("nuevo")){
                respuestasCorrectas = 0;
            }else{
                //Recuperar el número de aciertos.
                respuestasCorrectas = extras.getInt("numeroAcertadas");
            }
        }
        preguntas.add(new Pregunta("3x^2", "3", "-3", true));
        preguntas.add(new Pregunta("-2x^2+4x-2", "18", "-18", false));
        preguntas.add(new Pregunta("2x+3x=5x", "2", "-2", true));


        button = findViewById(R.id.btnAcceptar);
        txtNumPreguntas = findViewById(R.id.txtNumPreguntas);
        txtEnunciado = findViewById(R.id.txtEcuacion);
        txtResultado1 = findViewById(R.id.rbRespuesta1);
        txtResultado2 = findViewById(R.id.rbRespuesta2);
        RadioGroup rg = findViewById(R.id.rgRespuestas);
        RadioButton respuesta1 = findViewById(R.id.rbRespuesta1);
        RadioButton respuesta2 = findViewById(R.id.rbRespuesta2);

        pregunta = preguntas.get(respuestasCorrectas);
        txtNumPreguntas.setText(respuestasCorrectas+1+"/3");
        txtEnunciado.setText(pregunta.getEnunciado());
        txtResultado1.setText(pregunta.getRespuesta1());
        txtResultado2.setText(pregunta.getRespuesta2());

        button.setOnClickListener(v -> {
            juego();

        });

    }


    /**
     * Método que permite jugar
     */
    public void juego() {

        Intent intent = new Intent(this, ResultadoActivity.class);
        // comprueba que no se ha seleccionado una respuesta
        if (respuestaNoSeleccionada) {
            Toast.makeText(this, "Respuesta no seleccionada", Toast.LENGTH_SHORT).show();
        } else {
            // comprueba si la respuesta correcta a la pregunta ha sido seleccionada.
            if (pregunta.isRespuestaCorrecta() == respuestaSeleccionada) {
                respuestasCorrectas += 1;
                intent.putExtra("numeroAcertadas",  respuestasCorrectas);
                if (respuestasCorrectas >= 3) {
                    intent.putExtra("terminado", true);
                } else {

                    intent.putExtra("terminado", false);
                }
                startActivity(intent);

            } else {
                Toast.makeText(this, "Respuesta Incorrecta", Toast.LENGTH_SHORT).show();
            }

        }
    }


    public void respuestas(View view) {

        switch (view.getId()) {
            case R.id.rbRespuesta1:
                respuestaSeleccionada = true;
                respuestaNoSeleccionada = false;
                break;
            case R.id.rbRespuesta2:
                respuestaSeleccionada = false;
                respuestaNoSeleccionada = false;
                break;
            default:
                respuestaNoSeleccionada = true;
                break;
        }
    }
}