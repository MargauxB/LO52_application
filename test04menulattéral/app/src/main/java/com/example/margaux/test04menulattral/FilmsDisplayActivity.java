package com.example.margaux.test04menulattral;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by margaux on 23/12/2016.
 */

public class FilmsDisplayActivity extends Activity{
    public Context context;
    public ListView listMedia;
    private static final String TAG = FilmsDisplayActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "OnCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.films_display);
        Log.d(TAG, "OnCreate() -- setcontent(film_display)");

        listMedia = (ListView)findViewById(R.id.list_media);
        Log.d(TAG, "OnCreate() -- listMedia <-- listView");

        Media myMedia = new Media(this);
        Log.d(TAG, "OnCreate()-- Media(this)");

        List<FilmRow> filmRowList= new ArrayList<FilmRow>();
        Log.d(TAG, "OnCreate() -- ");

        filmRowList.addAll(myMedia.getFilms());
        Log.d(TAG, "OnCreate() -- filmListRow.addAll()");

        FilmAdapter filmAdapter = new FilmAdapter(this, filmRowList);
        listMedia.setAdapter(filmAdapter);
        Log.d(TAG, "OnCreate() -- adapter");

    }
}
