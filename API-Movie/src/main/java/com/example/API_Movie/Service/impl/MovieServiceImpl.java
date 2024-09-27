package com.example.API_Movie.Service.impl;

import com.example.API_Movie.DTO.MovieDTO;
import com.example.API_Movie.Entity.MovieEntity;
import com.example.API_Movie.Repository.MovieRepository;
import com.example.API_Movie.Service.MovieService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;
    public MovieServiceImpl(MovieRepository mvr){
        this.movieRepository = mvr;
    }

    @Override
    public String save(MovieDTO md){
        saveToDB(md);
        return "Success";
    }

    @Override
    public String get(Long id) {
        Optional<MovieEntity> movie = movieRepository.findById(id);
        if (movie.isPresent()){
            return "Success";
        } else {
            return "Data not Found";
        }
    }

    private void saveToDB(MovieDTO md){
        MovieEntity movie = new MovieEntity();

        movie.setTitle(md.getTitle());
        movie.setGenre(md.getGenre());
        movie.setDuration(md.getDuration());
        movie.setDirector(md.getDirector());
        movie.setRating(md.getRating());

        this.movieRepository.save(movie);
    }
}
