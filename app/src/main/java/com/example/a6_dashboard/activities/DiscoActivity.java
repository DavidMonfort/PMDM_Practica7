package com.example.a6_dashboard.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a6_dashboard.R;
import com.example.a6_dashboard.model.Disco;

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


        tvTitulo = findViewById(R.id.textViewAlbum);
        tvArtist = findViewById(R.id.textViewArtist);
        tvYearSongs = findViewById(R.id.textViewYearSongs);
        ivFoto = findViewById(R.id.imageViewFoto);

        Disco disco = (Disco) getIntent().getSerializableExtra("disco");
        tvTitulo.setText(disco.getTitulo());
        tvArtist.setText(disco.getArtista());
        tvYearSongs.setText(Integer.toString(disco.getAnyo()));
        Glide.with(this).load(disco.getUrlPortada()).into(ivFoto);

    }

}