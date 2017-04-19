package com.example.android.musicapp;

import java.util.HashMap;

/**
 * Distributes songs based on all genres, maps ids to songs.
 */

public class SongsDistrubution {

    HashMap<Integer, String> allSongs = new HashMap<Integer, String>();
    HashMap<Integer, String> genreSong = new HashMap<Integer, String>();
    HashMap<Integer, String> albumSong = new HashMap<Integer, String>();
    HashMap<Integer, String> artistSong = new HashMap<Integer, String>();
    HashMap<Integer, String> artists = new HashMap<Integer, String>();
    HashMap<Integer, String> albums = new HashMap<Integer, String>();
    HashMap<Integer, Integer> rawIds = new HashMap<Integer, Integer>();

    private final String sadSong = "SadSong";
    private final String happySong = "HappySong";

    private final String romanticSong = "RomanticSong";
    private final String partySong = "partySong";
    private final String song1 = "Lets Break Up";
    private final String song2 = "Ae Zindagi Gale Laga Le - club mix";
    private final String song3 = "Ae Zindagi Gale Laga Le";
    private final String song4 = "Just Go To Hell";
    private final String song5 = "Love u Zindagi";
    private final String song6 = "Love u Zindagi- club mix";
    private final String song7 = "Taarefon se";
    private final String song8 = "Tu Hi Hai";
    private final String album1 = "Dear Zindagi";
    private final String singer1 = "Amit Trivedi";
    private final String singer2 = "Illayaraja";

    public HashMap getSongsPlaylist() {
        allSongs.put(1, song1);
        allSongs.put(2, song2);
        allSongs.put(3, song3);
        allSongs.put(4, song4);
        allSongs.put(5, song5);
        allSongs.put(6, song6);
        allSongs.put(7, song7);
        allSongs.put(8, song8);

        return allSongs;
    }

    public HashMap getRawIds() {
        rawIds.put(1, R.raw.letsbreakup);
        rawIds.put(2, R.raw.aezindagiclubmix);
        rawIds.put(3, R.raw.aezindagi);
        rawIds.put(4, R.raw.justgotohell);
        rawIds.put(5, R.raw.loveuzindagi);
        rawIds.put(6, R.raw.loveuzindagiclubmix);
        rawIds.put(7, R.raw.taarefonse);
        rawIds.put(8, R.raw.tuhihai);

        return rawIds;
    }

    public HashMap getSongsGenrelist() {
        genreSong.put(1, sadSong);
        genreSong.put(2, happySong);
        genreSong.put(3, happySong);
        genreSong.put(4, sadSong);
        genreSong.put(5, partySong);
        genreSong.put(6, partySong);
        genreSong.put(7, romanticSong);
        genreSong.put(8, romanticSong);

        return genreSong;
    }

    public HashMap getAlbumSongs() {
        albumSong.put(1, album1);
        albumSong.put(2, album1);
        albumSong.put(3, album1);
        albumSong.put(4, album1);
        albumSong.put(5, album1);
        albumSong.put(6, album1);
        albumSong.put(7, album1);
        albumSong.put(8, album1);

        return albumSong;
    }

    public HashMap getArtistSongs() {
        artistSong.put(1, singer1);
        artistSong.put(2, singer1);
        artistSong.put(3, singer1);
        artistSong.put(4, singer1);
        artistSong.put(5, singer2);
        artistSong.put(6, singer2);
        artistSong.put(7, singer2);
        artistSong.put(8, singer2);

        return artistSong;
    }

    public HashMap getAlbumsSongs() {
        albumSong.put(1, album1);
        albumSong.put(2, album1);
        albumSong.put(3, album1);
        albumSong.put(4, album1);
        albumSong.put(5, album1);
        albumSong.put(6, album1);
        albumSong.put(7, album1);
        albumSong.put(8, album1);

        return albumSong;
    }

    public HashMap getArtistNames() {
        artists.put(1,singer1);
        artists.put (2,singer2);
        return  artists;
    }

    public HashMap getAlbumNames() {
        albums.put(1,album1);

        return  albums;
    }
}
