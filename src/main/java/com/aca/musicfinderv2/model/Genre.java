package com.aca.musicfinderv2.model;

public enum Genre {

    Country("Country"), Electronic("Electronic"), HipHop("Hip Hop"), Rock("Rock"), RB("R&B"), Pop("Pop");

    private String genre;

    private Genre(String genre) {
        this.genre = genre;
    }
    public String toString() {
        return genre;
    }

    public static Genre convertStringToGenre(String value) {
        Genre myGenre = null;

        for (Genre genre : Genre.values()) {
            if (genre.toString().equalsIgnoreCase(value)) {
                myGenre = genre;
                break;
            }
        }
        return myGenre;
    }
}
