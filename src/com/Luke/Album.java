package com.Luke;

import java.util.ArrayList;

public class Album {
    private String name;
    private ArrayList<Song> albumSongs;

    public Album(String name) {
        this.name = name;
        this.albumSongs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getAlbumSongs() {
        return albumSongs;
    }

    public boolean add(String name, double duration) {
        if (findSong(name) == null) {
            this.albumSongs.add(Song.addSong(name, duration));
            return true;
        }

        return false;
    }

    public Song findSong(String songName) {
        for (int i = 0; i < albumSongs.size(); i++) {
            if ((albumSongs.get(i).getName().equals(songName))) {
                return albumSongs.get(i);
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

