package com.MovieReview.Movie;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RequestMapping("moviereview")
public class MovieController {

	@Autowired
	MovieRepository moviesRepo;

	@Autowired
	ReviewRepository reviewsRepo;

	@Autowired
	UsersRepository usersRepo;

	// Sign In
	@PostMapping("/signin")
	public User signIn(HttpServletRequest req, @RequestBody User user) {
		User temp = new User();
		temp = usersRepo.findByUserNameAndPassword(user.getUserName(), user.getPassword());

		if (temp.getId() > 0 && temp.getPassword().equals(user.getPassword())) {
			HttpSession session = req.getSession(true);
			session.setAttribute("userName", temp.getUserName());
		}

		return temp;
	}

	// Sign Up
	@PostMapping("/signup")
	public User signUp(HttpServletRequest req, @RequestBody User user) {

		User result = null;
		try {
			result = usersRepo.save(user);

			if (result == null)
				return null;

			HttpSession session = req.getSession(true);
			session.setAttribute("userName", result.getUserName());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Sign Out
	@PostMapping("/signout")
	public Status logout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);

		if (session != null && session.getAttribute("userName") != null) {
			session.invalidate();
			return new Status(true);
		}
		return new Status(false);
	}

	// Check if user has signed in already
	public boolean validate(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (session == null || session.getAttribute("userName") == null)
			return false;
		return true;
	}

	// Get All Users
	@GetMapping("/users/all")
	public List<User> findAllUsers(HttpServletRequest req) {
		if (!validate(req))
			return null;

		List<User> users = new ArrayList<User>();
		Iterable<User> iterable = usersRepo.findAll();
		for (User user : iterable) {
			users.add(user);
		}
		return users;
	}

	// Get All Movies
	@GetMapping("/movies/all")
	public List<Movie> getMovies(HttpServletRequest req) {
		if (!validate(req))
			return null;

		List<Movie> movies = new ArrayList<Movie>();

		Iterable<Movie> iterable = moviesRepo.findAll();
		for (Movie movie : iterable) {
			movies.add(movie);
		}
		return movies;
	}

	// Save a Movie
	@PostMapping("/movies/save")
	public Movie saveMovie(@RequestBody Movie movie, HttpServletRequest req) {
		if (!validate(req))
			return null;
		return moviesRepo.save(movie);
	}

	// Edit a Movie
	@PutMapping("/movies/edit")
	public Movie editMovie(@RequestBody Movie movie, HttpServletRequest req) {
		if (!validate(req))
			return null;
		System.out.println("Starting to edit");
		movie = moviesRepo.save(movie);
		System.out.println("Finishing to edit");
		return movie;
	}

	// Delete a Movie
	@DeleteMapping("/movies/delete/{id}")
	public Status deleteMovie(@PathVariable Integer id, HttpServletRequest req) {
		if (!validate(req))
			return null;

		moviesRepo.deleteById(id);
		return new Status(true);
	}

	// Get all reviews by movie
	@GetMapping("/reviews/search/{movieId}")
	public List<Review> getReviewsByMovie(@PathVariable Integer movieId, HttpServletRequest req) {
		if (!validate(req))
			return null;

		List<Review> reviews = new ArrayList<Review>();
		Movie movie = new Movie();
		movie.setId(movieId);
		Iterable<Review> iterable = reviewsRepo.findByMovie(movie);
		for (Review review : iterable) {
			reviews.add(review);
		}
		return reviews;
	}
	
	// Get all reviews by user
	@GetMapping("/reviews/search/users/{userId}")
	public List<Review> getReviewsByUser(@PathVariable Integer userId, HttpServletRequest req) {
		if (!validate(req))
			return null;

		List<Review> reviews = new ArrayList<Review>();
		User user = new User();
		user.setId(userId);
		Iterable<Review> iterable = reviewsRepo.findByUser(user);
		for (Review review : iterable) {
			reviews.add(review);
		}
		return reviews;
	}

	// Save a Review
	@PostMapping("/reviews/save")
	public Review saveReview(@RequestBody Review review, HttpServletRequest req) {
		if (!validate(req))
			return null;

		review.setMovie(new Movie());
		review.getMovie().setId(review.getMfk());
		review.setUser(new User());
		review.getUser().setId(review.getUfk());
		return reviewsRepo.save(review);
	}

	// Edit a Review
	@PostMapping("/reviews/edit")
	public Review editReview(@RequestBody Review review, HttpServletRequest req) {
		if (!validate(req))
			return null;

		review.setMovie(new Movie());
		review.getMovie().setId(review.getMfk());
		review.setUser(new User());
		review.getUser().setId(review.getUfk());
		return reviewsRepo.save(review);
	}

	// Delete a Review
	@DeleteMapping("/reviews/delete/{id}")
	public Status deleteReview(@PathVariable Integer id, HttpServletRequest req) {
		if (!validate(req))
			return null;

		reviewsRepo.deleteById(id);
		return new Status(true);
	}

	@GetMapping("/movies/details/{movieId}")
	public Movie Movies(@PathVariable int movieId) {
		return moviesRepo.findById(movieId).get();
	}
	@GetMapping("/movies/now-showing/all")
	public List<Movie> getNowShowing() {
		return moviesRepo.findByStatus("now-showing");
	}
	
	@GetMapping("/movies/coming-soon/all")
	public List<Movie> getComingSoon() {
		return moviesRepo.findByStatus("coming-soon");
	}
	
	@GetMapping("/movies/most-popular/all")
	public List<Movie> getMostpopular() {
		return moviesRepo.findByStatus("most-popular");
	}

}
