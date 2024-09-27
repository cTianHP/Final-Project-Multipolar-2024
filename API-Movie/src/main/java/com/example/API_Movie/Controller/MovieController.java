package com.example.API_Movie.Controller;

import com.example.API_Movie.DTO.MovieDTO;
import com.example.API_Movie.Service.MovieService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie-api/v1")
public class MovieController {
    private final MovieService movieService;
    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @PostMapping(value = "/add-movie")
    public String add(@RequestBody MovieDTO moviereq){
        return movieService.save(moviereq);
    }

    @GetMapping(value = "/get-movie/{id}")
    public String getMovieById(@PathVariable Long id){
        return movieService.get(id);
    }

//    @GetMapping(value = "get-movie/genre/{genre}")
//    public String getMovieByGenre(@PathVariable String genre){
//        return movieService.getGenre(genre);
//    }

}
