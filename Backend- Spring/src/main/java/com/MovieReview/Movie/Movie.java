package com.MovieReview.Movie;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "movies")

public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String imageurl;
	private String movieName;
	private String storyLine;
	private String cast;
	private Integer rating;
	String status;

	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<Review> reviews;

	public Movie() {

	}

	public Movie(Integer movieId, String imageurl, String movieName, String storyLine, String cast, Integer rating,String status) {
		super();
		this.id = movieId;
		this.imageurl = imageurl;
		this.movieName = movieName;
		this.storyLine = storyLine;
		this.cast = cast;
		this.rating = rating;
		this.status=status;
	}

	public Movie(Integer id, String imageurl, String movieName, String storyLine, String cast, Integer rating,String status,
			List<Review> reviews) {
		super();
		this.id = id;
		this.imageurl = imageurl;
		this.movieName = movieName;
		this.storyLine = storyLine;
		this.cast = cast;
		this.rating = rating;
		this.reviews = reviews;
		this.status=status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getStoryLine() {
		return storyLine;
	}

	public void setStoryLine(String storyLine) {
		this.storyLine = storyLine;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@JsonIgnore
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", imageurl=" + imageurl + ", movieName=" + movieName + ", storyLine=" + storyLine
				+ ", cast=" + cast + ", rating=" + rating + ", reviews=" + reviews + "]";
	}

}