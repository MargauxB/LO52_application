package com.example.margaux.test04menulattral;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by margaux on 23/12/2016.
 */

public class FilmsDisplayActivity extends Activity{
    public ListView listMedia;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.films_display);
        listMedia = (ListView)findViewById(R.id.list_media);
        List<FilmRow> filmRowList= new ArrayList<FilmRow>();
        filmRowList.add(
                new FilmRow("Imitation Game",
                            getResources().getDrawable(R.drawable.imitation_game),
                            "2014",
                            "Morten Tyldum",
                            new String[] {"Benedict Cumberbatch", "Keira Knightley", "Matthew Goode", "Mark Strong", "Rory Kinnear", "Charles Dance", "Allen Leech", "Matthew Beard"},
                            new String[]{"Drame", "Biopic"},
                            "1940 : Alan Turing, mathématicien, cryptologue, est chargé par le gouvernement Britannique de percer le secret de la célèbre machine de cryptage allemande Enigma, réputée inviolable."));

        FilmAdapter filmAdapter = new FilmAdapter(this, filmRowList);
        listMedia.setAdapter(filmAdapter);
    }
}
