package com.example.a6_dashboard.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.a6_dashboard.R;

public class ResultadoActivity extends AppCompatActivity {

    Button button;
    int numeroAcertadas;
    boolean isNew = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("ERROR_APP", "LLEGA2");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        button = findViewById(R.id.button2);
        TextView txtResult = findViewById(R.id.txtResult);
        Bundle extras = getIntent().getExtras();
        numeroAcertadas = extras.getInt("numeroAcertadas");
        boolean finalizado = extras.getBoolean("terminado");
        // comprueba si ha finalizado o no

        if (finalizado) {
            txtResult.setText(R.string.txtEndGame);
            button.setText(R.string.txtVolverJugar);
            isNew = true;
        } else {
            txtResult.setText(R.string.txtCorrect);
       }

        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, Quizzes_Activity.class);
            intent.putExtra("numeroAcertadas", numeroAcertadas);
            intent.putExtra("nuevo", isNew);
            startActivity(intent);
        });
    }
}