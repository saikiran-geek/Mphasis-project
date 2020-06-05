package com.MovieReview.Movie;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Integer> {

	List<Review> findByMovie(Movie movie);

	List<Review> findByUser(User user);
}