package com.aca.musicfinderv2.service;

import com.aca.musicfinderv2.dao.MusicDao;
import com.aca.musicfinderv2.dao.MusicDaoImpl;
import com.aca.musicfinderv2.model.Artist;
import com.aca.musicfinderv2.model.Genre;

import java.util.List;

public class MusicService {

    private MusicDao musicDao = new MusicDaoImpl();

    public List<Artist> getArtists() {
        return musicDao.getArtists();
    }

    public List<Artist> getArtistsByGenre(Genre genre) {
        return musicDao.getArtistsByGenre(genre);
    }

/*    public List<Artist> getArtistsByReleaseYear(Integer releaseYear) {
        //TODO validate release year, e.g. -1200 is not valid; less than *** or more than *** is not valid
        return musicDao.getArtistsByReleaseYear(releaseYear);
    } */

    public List<Artist> getArtistsByName(String name) {
        return musicDao.getArtistsByName(name);
    }

    public List<Artist> getArtistsById(Integer artistId) {
        return musicDao.getArtistsById(artistId);
    }

/*    public List<Artist> getArtistsByAlbum(String album) {
        return musicDao.getArtistsByAlbum(album);
    } */

/*    public List<Artist> getArtistsByTitle(String title) {
        return musicDao.getArtistsByTitle(title);
    } */

    public Artist createArtist(Artist newArtist) {
        return musicDao.createArtist(newArtist);
    }

    public Artist updateArtist(Artist updateArtist) {
        return musicDao.updateArtist(updateArtist);
    }

    public Artist deleteArtistById(Integer artistIdValue) {
        return musicDao.deleteArtistById(artistIdValue);
    }

/*    public List<Artist> getReleaseYearReport(Integer startReleaseYear, Integer endReleaseYear) {
        return musicDao.getReleaseYearReport(startReleaseYear, endReleaseYear);
    } */
}
