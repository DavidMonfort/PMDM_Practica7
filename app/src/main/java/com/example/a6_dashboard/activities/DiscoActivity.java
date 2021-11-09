package com.example.a6_dashboard.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a6_dashboard.R;

import org.w3c.dom.Text;

public class DiscoActivity extends AppCompatActivity {

    TextView tvTitulo;
    TextView tvArtist;
    TextView tvYearSongs;
    ImageView ivFoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disco);
        Bundle extras = getIntent().getExtras();

        tvTitulo = findViewById(R.id.textViewAlbum);
        tvArtist = findViewById(R.id.textViewArtista);
        tvYearSongs = findViewById(R.id.textViewYearSongs);
        ivFoto = findViewById(R.id.imageViewFoto);

        tvTitulo.setText(extras.getString("titulo"));
        tvArtist.setText(extras.getString("artista"));
        String texto = "."+ Integer.toString((int)extras.getInt("anyo")) +"."+ Integer.toString((int)extras.get("numCanciones"));
        tvYearSongs.setText(texto);
        Glide.with(this).load(extras.getString("portada")).into(ivFoto);
    }

}