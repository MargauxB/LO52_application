package com.example.margaux.test04menulattral;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by margaux on 24/12/2016.
 */

public class Media {

    private static final String TAG = Media.class.getSimpleName();

    List<FilmRow> films = new ArrayList<FilmRow>() ;

    Media(Context context){
        Log.d(TAG, "Media() début ");

        films.add(
            new FilmRow(
                    "The Imitation Game",
                    getPoster(context,R.drawable.imitation_game),
                    "2014",
                    "Morten Tyldum",
                    "<li>Benedict Cumberbatch</li>"+
                    "<li>Keira Knightley</li>"+
                    "<li>Matthew Goode</li>"+
                    "<li>Mark Strong</li>"+
                    "<li>Rory Kinnear</li>"+
                    "<li>Charles Dance</li>"+
                    "<li>Allen Leech</li>"+
                    "<li>Matthew Beard</li>",
                    new String[]{
                            "Drame",
                            "Biopic"},
                    "1940 : Alan Turing, mathématicien, cryptologue, est chargé par le gouvernement Britannique de percer le secret de la célèbre machine de cryptage allemande Enigma, réputée inviolable."
            )
        );
        films.add(
                new FilmRow(
                        "The Imitation Game",
                        getPoster(context,R.drawable.imitation_game),
                        "2014",
                        "Morten Tyldum",
                        "<li>Benedict Cumberbatch</li>"+
                                "<li>Keira Knightley</li>"+
                                "<li>Matthew Goode</li>"+
                                "<li>Mark Strong</li>"+
                                "<li>Rory Kinnear</li>"+
                                "<li>Charles Dance</li>"+
                                "<li>Allen Leech</li>"+
                                "<li>Matthew Beard</li>",
                        new String[]{
                                "Drame",
                                "Biopic"},
                        "1940 : Alan Turing, mathématicien, cryptologue, est chargé par le gouvernement Britannique de percer le secret de la célèbre machine de cryptage allemande Enigma, réputée inviolable."
                )
        );
        Log.d(TAG, "Media() film ajouté ");

    }

    private Drawable getPoster(Context context, int id){
        return ContextCompat.getDrawable(context,id);
    }

    public List<FilmRow> getFilms(){
        Log.d(TAG, "getFilms() début ");

        return films;
    }

    public static String fromMyHtml(String html){

        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(html,Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(html);
        }
        Log.d(TAG, "transfo de :"+html+" en :"+result);
        return result.toString();
    }
}
