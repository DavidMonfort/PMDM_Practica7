package com.example.a6_dashboard.adapter;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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

        return new ViewHolder(FragmentDiscoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

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