package com.Luke;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String name;
    private List<Song> albumSongs;

    public Album(String name) {
        this.name = name;
        this.albumSongs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Song> getAlbumSongs() {
        return albumSongs;
    }

    public boolean add(String name, double duration) {
        if (findSong(name) == null) {
            this.albumSongs.add(Song.addSong(name, duration));
            return true;
        }

        return false;
    }

    public Song findSong(String name) {
        for (Song songName : albumSongs) {
            if ((songName.getName().equals(name))) {
                return songName;
            }
        }

        return null;
    }

    public void printAlbum() {
        System.out.println(getName() + ": ");
        for(int i = 0; i < albumSongs.size(); i++) {
            System.out.println((i+1) + ". " + albumSongs.get(i).getName());
        }
    }
}

