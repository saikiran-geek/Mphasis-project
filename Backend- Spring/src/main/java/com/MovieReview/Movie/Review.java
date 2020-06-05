package com.MovieReview.Movie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Transient;

@Entity(name = "review")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reviewId;

	@Transient
	private Integer ufk;

	@Transient
	private Integer mfk;

	private String reviewTitle;

	private String reviewDescription;

	@ManyToOne
	private Movie movie;

	@ManyToOne
	private User user;

	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(Integer reviewId, Integer ufk, Integer mfk, String reviewTitle,String reviewDescription, Movie movie, User user) {
		super();
		this.reviewId = reviewId;
		this.ufk = ufk;
		this.mfk = mfk;
		this.reviewTitle = reviewTitle;
		this.reviewDescription=reviewDescription;
		this.movie = movie;
		this.user = user;
	}

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	public Integer getUfk() {
		return ufk;
	}

	public void setUfk(Integer ufk) {
		this.ufk = ufk;
	}

	public Integer getMfk() {
		return mfk;
	}

	public void setMfk(Integer mfk) {
		this.mfk = mfk;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewDescription() {
		return reviewDescription;
	}

	public void setReviewDescription(String reviewDescription) {
		this.reviewDescription = reviewDescription;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", reviewTitle=" + reviewTitle + ", reviewDescription="
				+ reviewDescription + "]";
	}

}