package com.arnav.memorygames;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TilesFragment_Game extends Fragment {

    final int[] tileColours = new int[] {R.color.tile_blue,R.color.tile_cyan,
            R.color.tile_green, R.color.tile_maroon, R.color.tile_orange,
            R.color.tile_purple, R.color.tile_red, R.color.tile_yellow};

    final int[] tiles = new int[] {R.drawable.tile_blue, R.drawable.tile_cyan,
            R.drawable.tile_green, R.drawable.tile_maroon, R.drawable.tile_orange,
            R.drawable.tile_purple, R.drawable.tile_red, R.drawable.tile_yellow};

    final int[] position = new int[]
            {11, 12, 13, 14,
                    21, 22, 23, 24,
                    31, 32, 33, 34,
                    41, 42, 43, 44};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tiles_game, container, false);
    }
}
