package com.aca.musicfinderv2.dao;

import com.aca.musicfinderv2.model.Artist;
import com.aca.musicfinderv2.model.Genre;

import java.util.List;

public interface MusicDao {
    public abstract List<Artist> getArtists();
    public abstract List<Artist> getArtistsByGenre(Genre genre);
//   public abstract List<Artist> getArtistsByReleaseYear(Integer releaseYear);
    public abstract List<Artist> getArtistsByName(String name);
    public abstract List<Artist> getArtistsById(Integer artistId);
//    public abstract List<Artist> getArtistsByAlbum(String album);
//    public abstract List<Artist> getArtistsByTitle(String title);
    public abstract Artist createArtist(Artist newArtist);
    public abstract Artist updateArtist(Artist updateArtist);
    public abstract Artist deleteArtistById(Integer artistId);
//    public abstract List<Artist> getReleaseYearReport(Integer startReleaseYear, Integer endReleaseYear);
}
