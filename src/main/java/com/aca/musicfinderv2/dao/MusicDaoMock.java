package com.aca.musicfinderv2.dao;

import com.aca.musicfinderv2.model.Artist;
import com.aca.musicfinderv2.model.Genre;

import java.util.ArrayList;
import java.util.List;

public class MusicDaoMock implements MusicDao {

    private static List<Artist> artists = new ArrayList<>();

    private static Integer lastArtistId = 0;

    private static Integer getNextArtistId() {
        lastArtistId++;
        return lastArtistId;
    }

    static {
        Artist juiceWrld = new Artist();
        juiceWrld.setName("Juice Wrld");
//        juiceWrld.setTitle("Wishing Well");
//        juiceWrld.setAlbum("Legends Never Die");
//        juiceWrld.setReleaseDate(LocalDate.of(2020, 7, 28));
//        juiceWrld.setReleaseYear(2020);
        juiceWrld.setGenre(Genre.HipHop);
        juiceWrld.setId(getNextArtistId());

        Artist fredAgain = new Artist();
        fredAgain.setName("Fred Again");
//        fredAgain.setTitle("Places to Be");
//        fredAgain.setAlbum("Ten Days");
//        fredAgain.setReleaseDate(LocalDate.of(2024, 9, 6));
//        fredAgain.setReleaseYear(2024);
        fredAgain.setGenre(Genre.Electronic);
        fredAgain.setId(getNextArtistId());

        Artist polyphia = new Artist();
        polyphia.setName("Polyphia");
//        polyphia.setTitle("Ego Death");
//        polyphia.setAlbum("Remember That You Will Die");
//        polyphia.setReleaseDate(LocalDate.of(2022, 9, 28));
//        polyphia.setReleaseYear(2022);
        polyphia.setGenre(Genre.Rock);
        polyphia.setId(getNextArtistId());

        Artist willieNelson = new Artist();
        willieNelson.setName("Willie Nelson");
//        willieNelson.setTitle("On the Road Again");
//        willieNelson.setAlbum("Honeysuckle Rose");
//        willieNelson.setReleaseYear(1980);
        willieNelson.setGenre(Genre.Country);
        willieNelson.setId(getNextArtistId());

        artists.add(juiceWrld);
        artists.add(fredAgain);
        artists.add(polyphia);
        artists.add(willieNelson);
    }

    @Override
    public List<Artist> getArtists() {
        List<Artist> myArtists = new ArrayList<>();
        myArtists.addAll(MusicDaoMock.artists);
        return myArtists;
    }

    @Override
    public List<Artist> getArtistsByGenre(Genre genre) {
        List<Artist> myArtists = new ArrayList<>();

        for (Artist artist : artists) {
            if (artist.getGenre().equals(genre)) {
                myArtists.add(artist);
            }
        }
        return myArtists;
    }

/*    @Override
    public List<Artist> getArtistsByReleaseYear(Integer releaseYear) {
        List<Artist> myArtists = new ArrayList<>();

        for (Artist artist : artists) {
            if (artist.getReleaseYear().intValue() == releaseYear.intValue()) {
                myArtists.add(artist);
            }
        }
        return myArtists;
    } */

    @Override
    public List<Artist> getArtistsByName(String name) {
        List<Artist> myArtists = new ArrayList<>();

        for (Artist artist : artists) {
            if (artist.getName().equals(name)) {
                myArtists.add(artist);
            }
        }
        return myArtists;
    }

    @Override
    public List<Artist> getArtistsById(Integer artistId) {
        List<Artist> myArtists = new ArrayList<>();

        for (Artist artist : artists) {
            if (artist.getId().intValue() == artistId.intValue()) {
                myArtists.add(artist);
            }
        }
        return myArtists;
    }

/*    @Override
    public List<Artist> getArtistsByAlbum(String album) {
        List<Artist> myArtists = new ArrayList<>();

        for (Artist artist : artists) {
            if (artist.getAlbum().equals(album)) {
                myArtists.add(artist);
            }
        }
        return myArtists;
    } */

/*    @Override
    public List<Artist> getArtistsByTitle(String title) {
        List<Artist> myArtists = new ArrayList<>();

        for (Artist artist : artists) {
            if (artist.getTitle().equals(title)) {
                myArtists.add(artist);
            }
        }
        return myArtists;
    } */

    @Override
    public Artist createArtist(Artist newArtist) {
        newArtist.setId(getNextArtistId());
        artists.add(newArtist);
        return newArtist;
    }

    @Override
    public Artist updateArtist(Artist updateArtist) {
        for (Artist artist : artists) {
            if (artist.getId().intValue() == updateArtist.getId().intValue()) {
                artist.setName(updateArtist.getName());
            /*    artist.setTitle(updateArtist.getTitle());
                artist.setAlbum(updateArtist.getAlbum());
                artist.setReleaseYear(updateArtist.getReleaseYear()); */
                artist.setGenre(updateArtist.getGenre());
                break;
            }
        }
        return updateArtist;
    }

    @Override
    public Artist deleteArtistById(Integer artistId) {
        List<Artist> artists = getArtistsById(artistId);
        Artist artist = null;
        if (artists.size() > 0) {
            artist = artists.get(0);
            MusicDaoMock.artists.remove(artist);
        }
        return artist;
    }

/*    @Override
    public List<Artist> getReleaseYearReport(Integer startReleaseYear, Integer endReleaseYear) {
        List<Artist> myArtists = new ArrayList<>();
        for (Artist artist : artists) {
            if (artist.getReleaseYear().intValue() >= startReleaseYear &&
                artist.getReleaseYear().intValue() <= endReleaseYear) {
                myArtists.add(artist);
            }
        }
        return myArtists;
    } */

}
