package com.arnav.memorygames;

import android.os.Bundle;
import android.os.Handler;
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

    final int[] tileDrawables = new int[]{R.drawable.tile_blue, R.drawable.tile_cyan,
            R.drawable.tile_green, R.drawable.tile_maroon, R.drawable.tile_orange,
            R.drawable.tile_purple, R.drawable.tile_red, R.drawable.tile_yellow};

    final int[] position = new int[]
            {11, 12, 13, 14, 21, 22, 23, 24,
                    31, 32, 33, 34, 41, 42, 43, 44};

    Button tile11, tile12, tile13, tile14, tile21, tile22, tile23, tile24,
            tile31, tile32, tile33, tile34, tile41, tile42, tile43, tile44;

    ArrayList<Integer> tileDrawablesRes;

    ArrayList<Button> tiles;
    ArrayList<Button> tilesOpened;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
        tileDrawablesRes = new ArrayList<>();

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
            button.setBackgroundResource(R.drawable.hidden_tile);
            tileDrawablesRes.add(R.drawable.hidden_tile);
        }
    }

/*    TODO :
       Error Resolution:
            => Toast not working in Start Fragment
       Feature Implementations
            => Timer
       General Feature Implementations
            => stop bottomNav for ongoing Game
            => onClick for start page layout which give toast saying click on start button ...
            => (maybe) animated start button page
    */

    void flipTile(Button tile) {
        int index = tiles.indexOf(tile);
        if (index >= 8) {
            index = index - 8;
        }
        Log.d(TAG, "flipTile: " + index);

        // For the situation when 2 tiles are open and a 3rd is clicked on
        if (tilesOpened.size() == 2) {
            // closing the first two tiles
            if (match(tilesOpened)) {
                for (Button tile_ : tilesOpened) {
                    tile_.setVisibility(View.INVISIBLE);
                    tile_.setEnabled(false);
                    Log.d(TAG, "run: Tiles matched and made invisible");
                }
            } else {
                for (Button tile_ : tilesOpened) {
                    setBackgroundRes(tile_, R.drawable.hidden_tile);
                    Log.d(TAG, "run: Tiles not matched and hidden");
                }
            }
            tilesOpened.clear();
            // opening the 3rd tile
            setBackgroundRes(tile, tileDrawables[index]);
            tilesOpened.add(tile);
        }

        if (tilesOpened.size() < 2) {
            // Opening a closed tile
            if (!tilesOpened.contains(tile)) {
                setBackgroundRes(tile, tileDrawables[index]);
                tilesOpened.add(tile);
            }
            // Closing an open tile
            else {
                setBackgroundRes(tile, R.drawable.hidden_tile);
                tilesOpened.remove(tile);
            }
        }

        if (tilesOpened.size() == 2) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    for (Button tile : tiles) {
                        tile.setEnabled(false);
                    }
                    Log.d(TAG, "run: Running the Handler");
                    if (match(tilesOpened)) {
                        for (Button tile : tilesOpened) {
                            tile.setVisibility(View.INVISIBLE);
                            tile.setEnabled(false);
                        }
                        Log.d(TAG, "run: Tiles matched and made invisible");
                    } else {
                        for (Button tile : tilesOpened) {
                            setBackgroundRes(tile, R.drawable.hidden_tile);
                        }
                        Log.d(TAG, "run: Tiles not matched and hidden");
                    }
                    tilesOpened.clear();
                    for (Button tile : tiles) {
                        tile.setEnabled(true);
                    }
                }
            }, 400);
        }
    }

    boolean match(ArrayList<Button> arr) {
        boolean bool = false;
        if ((arr.size() >= 2) && (arr.get(0) != arr.get(1))) {
            if (getBackgroundResource(arr.get(0)) == getBackgroundResource(arr.get(1))) {
                bool = true;
                Log.d(TAG, "match: tile Matched!");
            } else {
                Log.d(TAG, "match: tile not Matched!");
            }
        } else {
            Log.d(TAG, "match: same tile clicked");
        }
        return bool;
    }

    void setBackgroundRes(Button tile, int res) {
        tile.setBackgroundResource(res);
        tileDrawablesRes.set(tiles.indexOf(tile), res);
    }

    int getBackgroundResource(Button tile) {
        return tileDrawablesRes.get(tiles.indexOf(tile));
    }

}
