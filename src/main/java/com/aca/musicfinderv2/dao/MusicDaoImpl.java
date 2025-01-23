package com.aca.musicfinderv2.dao;

import com.aca.musicfinderv2.model.Artist;
import com.aca.musicfinderv2.model.Genre;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MusicDaoImpl implements MusicDao {

    private static String selectAllArtists =
            "SELECT id, name, spotifyId, genreId, updateDateTime, createDateTime " +
            "FROM artists";
    private static String selectArtistsByGenre =
            "SELECT id, name, spotifyId, genreId, updateDateTime, createDateTime " +
            "FROM artists " +
            "WHERE genreId = ? ";
/*    private static String selectArtistsByReleaseYear =
            "SELECT id, name, title, album, releaseYear, genreId, updateDateTime, createDateTime " +
            "FROM artists " +
            "WHERE releaseYear = ? "; */
    private static String selectArtistsByArtistId =
            "SELECT id, name, spotifyId, genreId, updateDateTime, createDateTime " +
            "FROM artists " +
            "WHERE id = ? ";
/*    private static String selectArtistsByTitle =
            "SELECT id, name, title, album, releaseYear, genreId, updateDateTime, createDateTime " +
            "FROM artists " +
            "WHERE title LIKE ? "; */
    private static String selectArtistsByName =
            "SELECT id, name, spotifyId, genreId, updateDateTime, createDateTime " +
            "FROM artists " +
            "WHERE name LIKE ? ";
/*    private static String selectArtistsByAlbum =
            "SELECT id, name, title, album, releaseYear, genreId, updateDateTime, createDateTime " +
            "FROM artists " +
            "WHERE album LIKE ? "; */
    private static String deleteArtistById =
            "DELETE FROM ARTISTS " +
            "WHERE id = ? ";
    private static String updateArtistById =
            "UPDATE artists " +
            "SET name = ?, " +
            "    spotifyId = ?, " +
            "    genreId = ? " +
            "WHERE id = ? ";
/*    private static String selectArtistsByRangeOfReleaseYear =
            "SELECT id, name, title, album, releaseYear, genreId, updateDateTime, createDateTime " +
            "FROM artists " +
            "WHERE releaseYear >= ? " +
            "AND releaseYear <= ? "; */
    private static String insertArtist =
            "INSERT INTO artists (name, spotifyId, genreId) " +
            "VALUES " +
            "(?,?,?) ";


    @Override
    public List<Artist> getArtists() {
        List<Artist> myArtists = new ArrayList<>();
        ResultSet result = null;  //resultset - object that contains a table or rows & columns of data in MariaDB that comes back from the database
        Statement statement = null;  //statement - object that we build up & send to the database

        Connection connection = MariaDbUtil.getConnection(); //code that connects us to the database

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(selectAllArtists);
            myArtists = makeArtists(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return myArtists;
    }

    private List<Artist> makeArtists(ResultSet result) throws SQLException {
        List<Artist> myArtists = new ArrayList<>();
                                    //don't want to handle checked exception here, but send it back to method that called us to be caught in the getArtists try-catch
        while(result.next()) {   //next returns a boolean: true if there is another row otherwise returns false so you know you don't have anymore rows of data
            Artist artist = new Artist();
//            artist.setTitle(result.getString("title"));
            artist.setName(result.getString("name"));
//            artist.setAlbum(result.getString("album"));
            artist.setId(result.getInt("id"));
            artist.setSpotifyId(result.getString("spotifyId"));
//            artist.setReleaseYear(result.getInt("releaseYear"));
            String genreString = result.getString("genreId");
            artist.setGenre(Genre.convertStringToGenre(genreString));
            artist.setCreateDateTime(result.getObject("createDateTime", LocalDateTime.class));
            artist.setUpdateDateTime(result.getObject("updateDateTime", LocalDateTime.class));
            myArtists.add(artist);
        }
        return myArtists;
    }

    @Override
    public List<Artist> getArtistsByGenre(Genre genre) {
        List<Artist> myArtists = new ArrayList<>();
        ResultSet result = null;
        PreparedStatement ps = null;

        Connection connection = MariaDbUtil.getConnection();

        try {
            ps = connection.prepareStatement(selectArtistsByGenre);
            ps.setString(1, genre.toString());
            result = ps.executeQuery();
            myArtists = makeArtists(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return myArtists;
    }

/*    @Override
    public List<Artist> getArtistsByReleaseYear(Integer releaseYear) {
        List<Artist> myArtists = new ArrayList<>();
        ResultSet result = null;
        PreparedStatement ps = null;

        Connection connection = MariaDbUtil.getConnection();

        try {
            ps = connection.prepareStatement(selectArtistsByReleaseYear);
            ps.setInt(1, releaseYear);
            result = ps.executeQuery();
            myArtists = makeArtists(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return myArtists;
    } */

    @Override
    public List<Artist> getArtistsByName(String name) {
        List<Artist> myArtists = new ArrayList<>();
        ResultSet result = null;
        PreparedStatement ps = null;

        Connection connection = MariaDbUtil.getConnection();

        try {
            ps = connection.prepareStatement(selectArtistsByName);
            name = "%" + name + "%";
            ps.setString(1, name);
            result = ps.executeQuery();
            myArtists = makeArtists(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return myArtists;
    }

    @Override
    public List<Artist> getArtistsById(Integer artistId) {
        List<Artist> myArtists = new ArrayList<>();
        ResultSet result = null;
        PreparedStatement ps = null;

        Connection connection = MariaDbUtil.getConnection();

        try {
            ps = connection.prepareStatement(selectArtistsByArtistId);
            ps.setInt(1, artistId);
            result = ps.executeQuery();
            myArtists = makeArtists(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return myArtists;
    }

/*    @Override
    public List<Artist> getArtistsByAlbum(String album) {
        List<Artist> myArtists = new ArrayList<>();
        ResultSet result = null;
        PreparedStatement ps = null;

        Connection connection = MariaDbUtil.getConnection();

        try {
            ps = connection.prepareStatement(selectArtistsByAlbum);
            album = "%" + album + "%";
            ps.setString(1, album);
            result = ps.executeQuery();
            myArtists = makeArtists(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return myArtists;
    } */

/*    @Override
    public List<Artist> getArtistsByTitle(String title) {
        List<Artist> myArtists = new ArrayList<>();
        ResultSet result = null;
        PreparedStatement ps = null;

        Connection connection = MariaDbUtil.getConnection();

        try {
            ps = connection.prepareStatement(selectArtistsByTitle);
            title = "%" + title + "%";
            ps.setString(1, title);
            result = ps.executeQuery();
            myArtists = makeArtists(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return myArtists;
    } */

    @Override
    public Artist createArtist(Artist newArtist) {
        PreparedStatement ps = null;
        Connection connection = MariaDbUtil.getConnection();

        try {
            ps = connection.prepareStatement(insertArtist);
            ps.setString(1, newArtist.getName());
            ps.setString(2, newArtist.getSpotifyId());
//            ps.setString(2, newArtist.getTitle());
//            ps.setString(3, newArtist.getAlbum());
//            ps.setInt(4, newArtist.getReleaseYear());
            ps.setString(3, newArtist.getGenre().toString());
            int rowCount = ps.executeUpdate();
            System.out.println("insert count: " + rowCount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newArtist;
    }

    @Override
    public Artist updateArtist(Artist updateArtist) {
        List<Artist> artists = this.getArtistsById(updateArtist.getId());

        if (artists.size() > 0) {
            PreparedStatement ps = null;
            Connection connection = MariaDbUtil.getConnection();
            try {
                ps = connection.prepareStatement(updateArtistById);
                ps.setString(1, updateArtist.getName());
                ps.setString(2, updateArtist.getSpotifyId());
//                ps.setString(2, updateArtist.getTitle());
//                ps.setString(3, updateArtist.getAlbum());
//                ps.setInt(4, updateArtist.getReleaseYear());
                ps.setString(3, updateArtist.getGenre().toString());
                ps.setInt(4, updateArtist.getId());
                int rowCount = ps.executeUpdate();
                System.out.println("rows updated: " + rowCount);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return updateArtist;
    }

    @Override
    public Artist deleteArtistById(Integer artistId) {
        List<Artist> artists = this.getArtistsById(artistId);
        Artist artistToDelete = null;

        if (artists.size() > 0) {
            artistToDelete = artists.get(0);
            PreparedStatement ps = null;
            Connection connection = MariaDbUtil.getConnection();
            try {
                ps = connection.prepareStatement(deleteArtistById);
                ps.setInt(1, artistId);
                int rowCount = ps.executeUpdate();
                System.out.println("rows deleted: " + rowCount);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return artistToDelete;
    }

/*    @Override
    public List<Artist> getReleaseYearReport(Integer startReleaseYear, Integer endReleaseYear) {
        List<Artist> myArtists = new ArrayList<>();
        ResultSet result = null;
        PreparedStatement ps = null;

        Connection connection = MariaDbUtil.getConnection();

        try {
            ps = connection.prepareStatement(selectArtistsByRangeOfReleaseYear);
            ps.setInt(1, startReleaseYear);
            ps.setInt(2, endReleaseYear);
            result = ps.executeQuery();
            myArtists = makeArtists(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return myArtists;
    } */
}
