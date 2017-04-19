package com.example.android.musicapp;

import android.content.Context;
import android.media.MediaPlayer;

import java.util.ArrayList;

/**
 * Singleton class which handles all the media player related queries.
 */

public class SingletonMediaPlayer {
    private static MediaPlayer mPlayer;
    private static int currentSong = -1;
    private static int prevSongId = -1;
    private static SingletonMediaPlayer instance = null;
    private ArrayList<Integer> userPlayList = new ArrayList<>();


    protected SingletonMediaPlayer() {
        // Exists only to defeat instantiation.
    }

    public static SingletonMediaPlayer getInstance(boolean nowPlaying) {

        if (instance == null) {
            instance = new SingletonMediaPlayer();
            currentSong = 0;
            mPlayer = null;
        } else {
            if (mPlayer != null) {
                if (!nowPlaying) {
                    mPlayer.stop();
                    mPlayer.release();
                    mPlayer = null;
                }
            }
        }
        return instance;
    }

    public ArrayList<Integer> getaddPlayList() {
        return userPlayList;
    }

    public void addPlayList(int songId) {
        if (!userPlayList.contains(songId)) {
            userPlayList.add(songId);
        }
    }

    public int getPrevSongId() {
        return prevSongId;
    }

    public void setPrevSongId(int songId) {
        prevSongId = songId;
    }

    public int getCurrentSong() {
        return currentSong;
    }

    public void setmPlayer(Context context, int uri, boolean resume) {
        if (!resume) {
            if (mPlayer != null && mPlayer.isPlaying()) {
                mPlayer.pause();
            }
            mPlayer = MediaPlayer.create(context, uri);
            currentSong = uri;
            mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {

                    mediaPlayer.start();
                }
            });
        }
    }

    public MediaPlayer getmPlayer() {
        return mPlayer;
    }

    public void play(Context context) {
        if (mPlayer == null) {
            mPlayer = MediaPlayer.create(context, currentSong);
        }
        mPlayer.start();
    }

    public void pause(Context context) {
        if (mPlayer != null && mPlayer.isPlaying()) {
            mPlayer.pause();
        }

        mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });
    }

}

