package com.arnav.memorygames;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TilesFragment_Game extends Fragment {

    private static final String TAG = "TilesFragment_Game";

    final int[] tileColours = new int[]{R.color.tile_blue, R.color.tile_cyan,
            R.color.tile_green, R.color.tile_maroon, R.color.tile_orange,
            R.color.tile_purple, R.color.tile_red, R.color.tile_yellow};

    final int[] tileDrawables = new int[]{R.drawable.tile_blue, R.drawable.tile_cyan,
            R.drawable.tile_green, R.drawable.tile_maroon, R.drawable.tile_orange,
            R.drawable.tile_purple, R.drawable.tile_red, R.drawable.tile_yellow};

    final int[] position = new int[]
            {11, 12, 13, 14, 21, 22, 23, 24,
                    31, 32, 33, 34, 41, 42, 43, 44};

    Button tile11, tile12, tile13, tile14, tile21, tile22, tile23, tile24,
            tile31, tile32, tile33, tile34, tile41, tile42, tile43, tile44;

    ArrayList<Button> tiles;
    ArrayList<Button> tilesOpened;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView: Moved to " + TAG);
        return inflater.inflate(R.layout.fragment_tiles_game, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tile11 = requireView().findViewById(R.id.tile11);
        tile12 = requireView().findViewById(R.id.tile12);
        tile13 = requireView().findViewById(R.id.tile13);
        tile14 = requireView().findViewById(R.id.tile14);
        tile21 = requireView().findViewById(R.id.tile21);
        tile22 = requireView().findViewById(R.id.tile22);
        tile23 = requireView().findViewById(R.id.tile23);
        tile24 = requireView().findViewById(R.id.tile24);
        tile31 = requireView().findViewById(R.id.tile31);
        tile32 = requireView().findViewById(R.id.tile32);
        tile33 = requireView().findViewById(R.id.tile33);
        tile34 = requireView().findViewById(R.id.tile34);
        tile41 = requireView().findViewById(R.id.tile41);
        tile42 = requireView().findViewById(R.id.tile42);
        tile43 = requireView().findViewById(R.id.tile43);
        tile44 = requireView().findViewById(R.id.tile44);
        tiles = new ArrayList<>();
        tilesOpened = new ArrayList<>();
        Button[] tilesArray = new Button[]{tile11, tile12, tile13, tile14, tile21, tile22, tile23, tile24, tile31, tile32, tile33, tile34, tile41, tile42, tile43, tile44};
        tiles.addAll(Arrays.asList(tilesArray));
        Collections.shuffle(tiles);

        View.OnClickListener tileClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Flipping Tile");
                flipTile((Button) v);
                Log.d(TAG, "onClick: Tile Flipped");
            }
        };

        for (Button button : tiles) {
            button.setOnClickListener(tileClickListener);
        }

    }

//    private void makeArrayList(Button[] array, ArrayList<Button> arrayList) {
//        for (Button button : array) {
//            arrayList.add(button);
//        }
//    }


    void flipTile(Button tile) {
        int index = (int) tiles.indexOf(tile);
        if (index >= 8) {
            index = index - 8;
        }
        Log.d(TAG, "flipTile: " + index);

        if (tilesOpened.size() < 2) {
            tile.setBackgroundResource(tileDrawables[index]);
            tilesOpened.add(tile);
        }

        if (tilesOpened.size() == 2) {
            if (match(tilesOpened)) {
                for (Button button : tilesOpened) {
                    button.setVisibility(View.INVISIBLE);
                    button.setEnabled(false);
                }
            } else {
                for (Button button : tilesOpened) {
                    button.setBackgroundResource(R.drawable.hidden_tile);
                }
            }
            tilesOpened.clear();
        }
    }

    boolean match(ArrayList<Button> arr) {
        boolean bool = false;
        if ((arr.get(0).getBackground()) == (arr.get(1).getBackground())) {
            bool = true;
            Log.d(TAG, "match: tile Matched!");
        }
        return bool;
    }

}
