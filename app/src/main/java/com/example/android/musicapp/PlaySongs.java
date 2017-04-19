package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Activity that plays songs, displays playlist selected by user.
 */
public class PlaySongs extends AppCompatActivity {

    HashMap<Integer, String> allSongs = new HashMap<Integer, String>();
    HashMap<Integer, Integer> rawSongIds = new HashMap<Integer, Integer>();
    int rawSongId = 0;
    int songId;
    boolean noSongsYet = false;
    boolean calledFromOthers = false;
    private SongsDistrubution helper = new SongsDistrubution();
    private SingletonMediaPlayer mediaHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_playsongs);
        Intent intent = getIntent();
        boolean nowPlaying = intent.getBooleanExtra("NowPlaying", false);
        allSongs = helper.getSongsPlaylist();
        rawSongIds = helper.getRawIds();
        mediaHelper = SingletonMediaPlayer.getInstance(nowPlaying);

        if (intent.getIntExtra("SongId", -1) == -1) {
            if (mediaHelper.getPrevSongId() != -1) {
                songId = mediaHelper.getPrevSongId();
                calledFromOthers = true;
            } else {
                noSongsYet = true;
            }
        } else {
            songId = intent.getIntExtra("SongId", -1);
        }

        if (!noSongsYet) {
            rawSongId = rawSongIds.get(songId);
            mediaHelper.addPlayList(songId);
            mediaHelper.setPrevSongId(songId);

            ArrayList<Integer> playlist = new ArrayList();
            playlist = mediaHelper.getaddPlayList();

            LinearLayout playSongs = (LinearLayout) findViewById(R.id.nowPlayingList);

            if (playlist.size() != 0) {
                for (int i = 0; i < playlist.size(); i++) {

                    final int id = playlist.get(i);

                    Button albumList = new Button(this);
                    albumList.setText(allSongs.get(id));
                    albumList.setId(rawSongIds.get(id));
                    final int buttonrawsongid = rawSongIds.get(id);

                    albumList.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            play(buttonrawsongid, calledFromOthers);
                        }
                    });

                    playSongs.addView(albumList);
                }
            }

            Button play = (Button) findViewById(R.id.play);
            play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaHelper.play(PlaySongs.this);

                }
            });

            Button pause = (Button) findViewById(R.id.pause);
            pause.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaHelper.pause(PlaySongs.this);
                }
            });

            if (calledFromOthers) {
                play(rawSongId, calledFromOthers);
            } else {
                play(rawSongId, calledFromOthers);
            }

        } else {
            TextView songView = (TextView) findViewById(R.id.songview);
            songView.setText("No Songs Selected");
        }
    }

    public void play(int rawSongId, boolean calledFromOthers) {
        mediaHelper.setPrevSongId(songId);
        mediaHelper.setmPlayer(PlaySongs.this, rawSongId, calledFromOthers);
    }

}