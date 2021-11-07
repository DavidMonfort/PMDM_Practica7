package com.example.a6_dashboard;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a6_dashboard.adapter.MyDiscoRecyclerViewAdapter;
import com.example.a6_dashboard.model.Disco;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class DiscoFragment extends Fragment {
    RecyclerView recyclerView;
    MyDiscoRecyclerViewAdapter adapterDisco;

    List<Disco> discoList;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public DiscoFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static DiscoFragment newInstance(int columnCount) {
        DiscoFragment fragment = new DiscoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_disco_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            //Lista de disco
            discoList = new ArrayList<>();
            //añadir discos
            discoList.add(new Disco("Mercury-Act 1","Imagine Dragons","https://m.media-amazon.com/images/I/B1ejX5F4lgS._SL1500_.jpg",2021, 13));
            discoList.add(new Disco("The Beautiful Liar","X Ambassadors","https://m.media-amazon.com/images/I/71-bs+w90pL._SY355_.jpg",2021, 16));
            discoList.add(new Disco("Solar Power","Lorde","https://m.media-amazon.com/images/I/41vzsg9LbhL.jpg",2021, 13));
            discoList.add(new Disco("Hurry up, We´re Dreaming","M83","https://canary.contestimg.wish.com/api/webimage/5b41e5f66670e634ec37de70-large.jpg?cache_buster=8ac97f3f2ef70aa1eafea3ccdf96e452",2021, 22));
            discoList.add(new Disco("racine carrée","Stromae","https://m.media-amazon.com/images/I/71-Hl5P0A2L._SL1200_.jpg",2021, 13));
            adapterDisco = new MyDiscoRecyclerViewAdapter(getActivity(), discoList);
            recyclerView.setAdapter(adapterDisco);
        }
        return view;
    }
}