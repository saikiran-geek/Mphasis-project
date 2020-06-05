package com.MovieReview.Movie;

import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Integer>{

	User findByUserNameAndPassword(String userName,String password);
	void deleteById(Integer id);
	
}