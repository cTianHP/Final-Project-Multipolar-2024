package com.example.API_Movie.Service;

import com.example.API_Movie.DTO.MovieDTO;

public interface MovieService {
    String save(MovieDTO movieDTO);
    String get(Long id);
}
