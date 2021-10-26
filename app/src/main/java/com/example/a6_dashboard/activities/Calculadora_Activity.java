package com.example.a6_dashboard.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a6_dashboard.R;

public class Calculadora_Activity extends AppCompatActivity implements View.OnClickListener{

    Button btnSum;
    Button btnMin;
    Button btnMult;
    Button btnDiv;
    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        btnMin = findViewById(R.id.btnRestar);
        btnSum = findViewById(R.id.btnSumar);
        btnMult = findViewById(R.id.btnMult);
        btnDiv = findViewById(R.id.btnDiv);

        btnMin.setOnClickListener(this);
        btnSum.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        int buttonId = view.getId();
        EditText numero1 = (EditText)findViewById(R.id.numberImput1);
        EditText numero2 = (EditText) findViewById(R.id.numberImput2);
        TextView result = (TextView) findViewById(R.id.txtResult);
        double n1 = Integer.parseInt(numero1.getText().toString());
        double n2 = Integer.parseInt(numero2.getText().toString());
        double resultado =0;
        if (numero1.equals("")){
            Context context = getApplicationContext();
            CharSequence text = "@string/number1Empty";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        if (numero2.equals("")){
            Context context = getApplicationContext();
            CharSequence text = "@string/number2Empty";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }


        switch (buttonId){
            case R.id.btnRestar:
                resultado =  n1 - n2;
                break;
            case R.id.btnSumar:
                resultado = n1 + n2;
                break;
            case R.id.btnMult:
                resultado = n1 * n2;
                break;
            case R.id.btnDiv:
                if (n2 == 0.0){
                    Context context = getApplicationContext();
                    CharSequence text = "@string/divAlert";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else{
                    resultado = n1 / n2;
                    break;
                }

            default:
                return;
        }
        String res = String.valueOf(resultado);
        result.setText(res);


    }
}