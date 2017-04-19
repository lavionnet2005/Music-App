package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Main Activity that displays different categories:
 * 1.Albums
 * 2.Artists
 * 3.PlayLists (pre defined ones)
 * 4.All Songs
 *
 * After selecting a category the appropriate list will be displayed.
 * Once a song is selected it will be added to the playlist and you can reach it by clicking
 * Now Playing button from any activity.
 */
public class MainActivity extends AppCompatActivity {

    private final String callingFromSongs = "Songs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playlist = (Button) findViewById(R.id.playlists);

        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PlaylistsActivity.class);
                startActivity(i);
            }
        });

        Button album = (Button) findViewById(R.id.albums);

        album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AlbumsActivity.class);
                startActivity(i);
            }
        });

        Button artist = (Button) findViewById(R.id.artists);

        artist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ArtistsActiivity.class);
                startActivity(i);
            }
        });

        Button song = (Button) findViewById(R.id.songs);

        song.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllSongsActivity.class);
                intent.putExtra("Calling From", callingFromSongs);
                startActivity(intent);
            }
        });
    }

    public void nowPlaying(View view){
        Intent intent = new Intent(MainActivity.this,PlaySongs.class);
        intent.putExtra("SongId", -1);
        intent.putExtra("NowPlaying", true);
        startActivity(intent);
    }
}
