package com.Luke;

import java.util.LinkedList;
import java.util.List;

public class Playlist {
    private String name;
    private List<Song> playlist;

    public Playlist(String name) {
        this.name = name;
        this.playlist = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public List<Song> getPlaylist() {
        return playlist;
    }

    public boolean addSongFromAlbum(Album album, String name) {
        Song song = album.findSong(name);
        if (song != null) {
            if (!findSongInPlaylist(name)) {
                System.out.println("Added " + name + " to playlist");
                playlist.add(song);
                return true;

            } else if (findSongInPlaylist(name)) {
                System.out.println(name + " is already in the playlist");
                return false;
            }
        }

        System.out.println("Could not find " + name + " in " + album.getName());
        return false;
    }

    public boolean addSong(Song song) {
        if (!findSongInPlaylist(song.getName())) {
            System.out.println("Added " + song.getName() + " to your playlist");
            playlist.add(song);
            return true;
        } else {
            System.out.println(song.getName() + " is already in your playlist");
            return false;
        }
    }

    private boolean findSongInPlaylist(String name) {
        for (Song songName : playlist) {
            if (songName.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    public void printPlaylist() {
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ". " + playlist.get(i).getName());
        }
    }
}