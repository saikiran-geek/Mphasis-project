package com.MovieReview.Movie;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
	List<Movie> findByStatus(String status);

}
