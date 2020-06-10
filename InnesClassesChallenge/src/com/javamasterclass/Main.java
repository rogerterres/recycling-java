package com.javamasterclass;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Blue Album", "Lukas Graham");
        album.addSong("7 Years", 3.57);
        album.addSong("Take the World by Storm", 3.11);
        album.addSong("Mama Said", 3.26);
        album.addSong("Happy Home", 3.37);
        album.addSong("Hayo", 2.52);
        album.addSong("When I Woke Up...", 0.49);
        album.addSong("Don't You Worry 'Bout Me", 3.10);
        album.addSong("Playtime", 3.56);
        album.addSong("Strip No More", 3.27);
        album.addSong("You're Not There", 3.21);
        album.addSong("Funeral", 4.04);
        albums.add(album);

        album = new Album("Sing to Me Instead", "Ben Platt");
        album.addSong("Bad Habit", 4.22);
        album.addSong("Ease My Mind", 4.37);
        album.addSong("Temporary Love", 3.37);
        album.addSong("Grow as We Go", 4.09);
        album.addSong("Honest Man", 3.49);
        album.addSong("Hurt Me Once", 4.00);
        album.addSong("New", 3.10);
        album.addSong("Better", 3.11);
        album.addSong("Share Your Address", 3.02);
        album.addSong("In Case You Don't Live Forever", 3.48);
        album.addSong("Older", 3.27);
        album.addSong("Run Away", 3.37);
        albums.add(album);


        LinkedList<Song> playlist = new LinkedList<>();
        albums.get(0).addToPlaylist("Mama Said", playlist);
        albums.get(0).addToPlaylist("You're Not There", playlist);
        albums.get(0).addToPlaylist("8 Years", playlist); // Does not exist
        albums.get(0).addToPlaylist(2, playlist);
        albums.get(1).addToPlaylist(4, playlist);
        albums.get(1).addToPlaylist(11, playlist);
        albums.get(1).addToPlaylist(18, playlist); // There is no track 18

        play(playlist);
    }

    private static void play(LinkedList<Song> playlist) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        if (playlist.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playlist.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }

    private static void printList(LinkedList<Song> playlist) {
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("=================================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
        System.out.println("=================================");
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play the next song\n" +
                "2 - to play the previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions\n" +
                "6 - delete current song from playlist");
    }

    //
    // Modify the playlist challenge so that the Album class uses an inner class.
    // Instead of using an ArrayList to hold its tracks, it will use an inner class called SongList
    // The inner SongList class will use an ArrayList and will provide a method to add a song.
    // It will also provide findSong() methods which will be used by the containing Album class
    // to add songs to the playlist.
    // Neither the Song class or the Main class should be changed.
    //

}
