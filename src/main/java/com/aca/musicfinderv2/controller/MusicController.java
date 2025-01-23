package com.aca.musicfinderv2.controller;

import com.aca.musicfinderv2.model.Artist;
import com.aca.musicfinderv2.model.Genre;
import com.aca.musicfinderv2.service.MusicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/artists", produces = "application/json")
@CrossOrigin("*")
public class MusicController {

    private MusicService service = new MusicService();

    @RequestMapping(method = RequestMethod.GET)
    public List<Artist> getArtists() {
        return service.getArtists();
    }
    @RequestMapping(value = "/genre/{genreValue}",
            method =  RequestMethod.GET)
    public List<Artist> getArtistsByGenre(@PathVariable Genre genreValue) {
        return service.getArtistsByGenre(genreValue);
    }
/*    @RequestMapping(value = "/releaseyear/{releaseYearValue}",
            method =  RequestMethod.GET)
    public List<Artist> getArtistsByReleaseYear(@PathVariable Integer releaseYearValue) {
        return service.getArtistsByReleaseYear(releaseYearValue);
    } */
    @RequestMapping(value = "/name/{nameValue}",
            method =  RequestMethod.GET)
    public List<Artist> getArtistsByName(@PathVariable String nameValue) {
        return service.getArtistsByName(nameValue);
    }
    @RequestMapping(value = "/{artistIdValue}",
            method =  RequestMethod.GET)
    public List<Artist> getArtistsById(@PathVariable Integer artistIdValue) {
        return service.getArtistsById(artistIdValue);
    }
/*    @RequestMapping(value = "/album/{albumValue}",
            method =  RequestMethod.GET)
    public List<Artist> getArtistsByAlbum(@PathVariable String albumValue) {
        return service.getArtistsByAlbum(albumValue);
    } */
/*    @RequestMapping(value = "/title/{titleValue}",
            method =  RequestMethod.GET)
    public List<Artist> getArtistsByTitle(@PathVariable String titleValue) {
        return service.getArtistsByTitle(titleValue);
    } */
    @RequestMapping(consumes = "application/json",
            method =  RequestMethod.POST)
    public Artist createArtist(@RequestBody Artist newArtist) {
        System.out.println(newArtist.toString());
        return service.createArtist(newArtist);
    }
    @RequestMapping(consumes = "application/json",
            method =  RequestMethod.PUT)
    public Artist updateArtist(@RequestBody Artist updateArtist) {
        System.out.println(updateArtist);
        return service.updateArtist(updateArtist);
    }
    @RequestMapping(value = "/{artistIdValue}",
            method =  RequestMethod.DELETE)
    public Artist deleteArtistById(@PathVariable Integer artistIdValue) {
        System.out.println("delete move id: " + artistIdValue);
        return service.deleteArtistById(artistIdValue);
    }
/*    @RequestMapping(value = "/report",
            method =  RequestMethod.GET)
    public List<Artist> getReleaseYearReport(@RequestParam Integer startReleaseYear,
                                             @RequestParam Integer endReleaseYear) {
        System.out.println("start: " + startReleaseYear + ", end: " + endReleaseYear);
        return service.getReleaseYearReport(startReleaseYear, endReleaseYear);
    } */

}
