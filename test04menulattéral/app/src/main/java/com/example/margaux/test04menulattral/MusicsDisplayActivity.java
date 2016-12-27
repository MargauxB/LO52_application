package com.example.margaux.test04menulattral;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by margaux on 23/12/2016.
 */

public class MusicsDisplayActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    public Context context;
    public ListView listMedia;

    public static final String API_KEY = "YOUR API KEY";
    public static final String VIDEO_ID = "YOUR VIDEO ID";

    private static final String TAG = MusicsDisplayActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "OnCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medias_display);
        Log.d(TAG, "OnCreate() -- setcontent(music_display)");

        listMedia = (ListView)findViewById(R.id.list_media);
        Log.d(TAG, "OnCreate() -- listMedia <-- listView");

        Media myMedia = new Media(this);
        Log.d(TAG, "OnCreate()-- Media(this)");

        List<MusicRow> musicRowList= new ArrayList<MusicRow>();
        Log.d(TAG, "OnCreate() -- ");

        musicRowList.addAll(myMedia.getMusics());
        Log.d(TAG, "OnCreate() -- filmListRow.addAll()");

        MusicAdapter musicAdapter = new MusicAdapter(this, musicRowList);
        listMedia.setAdapter(musicAdapter);
        Log.d(TAG, "OnCreate() -- adapter");

    }
}
