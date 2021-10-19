package com.example.a6_dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.a6_dashboard.activities.Amigos_Activity;
import com.example.a6_dashboard.activities.Calculadora_Activity;
import com.example.a6_dashboard.activities.EdadCanina_Activity;
import com.example.a6_dashboard.activities.Gallery_Activity;
import com.example.a6_dashboard.activities.Maps_Activity;
import com.example.a6_dashboard.activities.Quizzes_Activity;
import com.example.a6_dashboard.activities.Restaurants_Activity;
import com.example.a6_dashboard.activities.Settings_Activity;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rellay_Calculadora, rellay_amigos, rellay_perrete, rellay_quizzes, rellay_galery, rellay_maps, rellay_restaurants, rellay_settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rellay_Calculadora = findViewById(R.id.rellay_calculadora);
        rellay_amigos = findViewById(R.id.rellay_amigos);
        rellay_perrete = findViewById(R.id.rellay_perrete);
        rellay_quizzes = findViewById(R.id.rellay_quizzes);
        rellay_galery = findViewById(R.id.rellay_galery);
        rellay_maps = findViewById(R.id.rellay_maps);
        rellay_restaurants = findViewById(R.id.rellay_restaurants);
        rellay_settings = findViewById(R.id.rellay_settings);

        rellay_Calculadora.setOnClickListener(v -> {
            Intent intent = new Intent(this, Calculadora_Activity.class);
            startActivity(intent);
        });

        rellay_amigos.setOnClickListener(v -> {
            Intent intent = new Intent(this, Amigos_Activity.class);
            startActivity(intent);
        });

        rellay_perrete.setOnClickListener(v -> {
            Intent intent = new Intent(this, EdadCanina_Activity.class);
            startActivity(intent);
        });

        rellay_quizzes.setOnClickListener(v -> {
            Intent intent = new Intent(this, Quizzes_Activity.class);
            startActivity(intent);
        });

        rellay_galery.setOnClickListener(v -> {
            Intent intent = new Intent(this, Gallery_Activity.class);
            startActivity(intent);
        });

        rellay_maps.setOnClickListener(v -> {
            Intent intent = new Intent(this, Maps_Activity.class);
            startActivity(intent);
        });

        rellay_restaurants.setOnClickListener(v -> {
            Intent intent = new Intent(this, Restaurants_Activity.class);
            startActivity(intent);
        });
        rellay_settings.setOnClickListener(v -> {
            Intent intent = new Intent(this, Settings_Activity.class);
            startActivity(intent);
        });


    }
}