package com.aca.musicfinderv2.model;

import java.time.LocalDateTime;



public class Artist {
    private String name;
    private String spotifyId;
    private Genre genre;
    private Integer id;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpotifyId() { return spotifyId; }

    public void setSpotifyId(String spotifyId) { this.spotifyId = spotifyId; }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "name: " + getName() + ", genre: " + getGenre() + ", id: " + getId() + ", spotifyId: " + getSpotifyId();
    }
}
