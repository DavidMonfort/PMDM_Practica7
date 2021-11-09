package com.example.a6_dashboard.adapter;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.a6_dashboard.DiscoFragment;
import com.example.a6_dashboard.activities.DiscoActivity;
import com.example.a6_dashboard.model.Disco;
import com.example.a6_dashboard.databinding.FragmentDiscoBinding;

import java.util.List;


public class MyDiscoRecyclerViewAdapter extends RecyclerView.Adapter<MyDiscoRecyclerViewAdapter.ViewHolder> {

    private final List<Disco> mValues;
    private final Context ctx;

    public MyDiscoRecyclerViewAdapter(Context context, List<Disco> items) {
        mValues = items;
        this.ctx = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final ViewHolder holder = new ViewHolder(FragmentDiscoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ctx,"Elemento "+mValues.get(holder.getAbsoluteAdapterPosition()).getArtista(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ctx, DiscoActivity.class);
                intent.putExtra("artista", mValues.get(holder.getAbsoluteAdapterPosition()).getArtista());
                intent.putExtra("titulo", mValues.get(holder.getAbsoluteAdapterPosition()).getTitulo());
                intent.putExtra("portada", mValues.get(holder.getAbsoluteAdapterPosition()).getUrlPortada());
                intent.putExtra("anyo", mValues.get(holder.getAbsoluteAdapterPosition()).getAnyo());
                intent.putExtra("numCanciones", mValues.get(holder.getAbsoluteAdapterPosition()).getNum_canciones());
                ctx.startActivity(intent);

            }
        });
        return holder;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.textViewTituloDisco.setText(mValues.get(position).getTitulo());
        holder.textViewArtistaDisco.setText(mValues.get(position).getArtista());

        Glide.with(ctx).load(mValues.get(position).getUrlPortada()).into(holder.imageViewPortadaDisco);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView textViewTituloDisco;
        public final TextView textViewArtistaDisco;
        public final ImageView imageViewPortadaDisco;
        public Disco mItem;

        public ViewHolder(FragmentDiscoBinding binding) {
            super(binding.getRoot());
            textViewTituloDisco = binding.textViewTitulo;
            textViewArtistaDisco = binding.textViewArtista;
            imageViewPortadaDisco = binding.imageViewDisco;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewArtistaDisco.getText() + "'";
        }
    }
}