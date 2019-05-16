package com.Luke;

import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static Playlist newPlaylist = new Playlist("Soul");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Album album = new Album("Jonas.L.A.");
        album.add("Feelin' Alive", 3.15);
        album.add("Your Biggest Fan", 3.01);
        album.add("Critical", 3.35);
        album.add("Hey you", 2.49);
        album.add("Fall", 3.25);

        Song song = new Song("Random song", 3.23);

        newPlaylist.addSongFromAlbum(album, "Critical");
        newPlaylist.addSongFromAlbum(album, "asdf");
        newPlaylist.addSong(song);

        options();

    }

    private static void options() {
        printOptions();
        boolean quit = false;
        boolean playNext = true;
        ListIterator<Song> listIterator = newPlaylist.getPlaylist().listIterator();

        if (newPlaylist.getPlaylist().isEmpty()) {
            System.out.println("No songs in the playlist");
            return;
        } else {
            System.out.println("Now playing: " + listIterator.next().getName());
        }

        while (!quit) {
            System.out.println("Please enter a number:");
            int number = scanner.nextInt();
            scanner.nextLine();

            switch (number) {
                case 0:
                    newPlaylist.printPlaylist();
                    break;
                case 1:
                    // "Replays" the song
                    if (playNext) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing: " + listIterator.previous().getName());
                            playNext = false;
                        } else {
                            System.out.println("We are at the start of the playlist");
                        }

                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing: " + listIterator.next().getName());
                            playNext = true;
                        } else {
                            System.out.println("We are at the end of the playlist");

                        }
                    }
                    break;
                case 2:
                    // Checking to see if the ListIterator is going forward, if not then the direction is changed to
                    // going forward
                    if (!playNext) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        playNext = true;
                    }
                    // Checking to see if there is an available field in the ListIterator
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().getName());
                    } else {
                        System.out.println("Reached the end of the playlist");
                        playNext = false;
                    }
                    break;
                case 3:
                    // Checking to see if the ListIterator is going backwards
                    if (playNext) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }

                        playNext = false;
                    }
                    //Checking to see if there is an available field in the previous
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing: " + listIterator.previous().getName());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        playNext = true;
                    }
                    break;
                case 4:
                    printOptions();
                    break;
                case 5:
                    // Removes current song and then automatically plays the next song,
                    // if it is at the end of the playlist, it will play the previous song
                    if(newPlaylist.getPlaylist().size() > 0) {
                        listIterator.remove();
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().getName());
                        } else if(listIterator.hasPrevious()) {
                            System.out.println("Now playing + " + listIterator.previous().getName());
                        }
                    }
                    break;
                case 6:
                    quit = true;
                    break;

            }
        }
    }

    private static void printOptions() {
        System.out.println("0 - Prints playlist");
        System.out.println("1 - To replay the song");
        System.out.println("2 - To play the next song");
        System.out.println("3 - To play the previous song");
        System.out.println("4 - To print these options again");
        System.out.println("5 - To remove the current song from the playlist");
        System.out.println("6 - To exit the music player");
    }
}

