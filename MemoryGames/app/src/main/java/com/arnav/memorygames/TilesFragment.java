package com.arnav.memorygames;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class TilesFragment extends Fragment {


    ImageView curView;
    int countPair;
    final int[] tileColours = new int[] {R.color.tile_blue,R.color.tile_cyan,
            R.color.tile_green,R.color.tile_maroon,R.color.tile_orange,
            R.color.tile_purple,R.color.tile_red,R.color.tile_yellow,};

    final int[] position = new int[] {};

    public TilesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_tiles, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}