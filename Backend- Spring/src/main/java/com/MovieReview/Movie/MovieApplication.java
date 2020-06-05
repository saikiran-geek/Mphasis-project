package com.MovieReview.Movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class MovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/moviereview/signin").allowedOrigins("http://localhost:4200");
				registry.addMapping("/moviereview/signin").allowCredentials(true);
				
				registry.addMapping("/moviereview/signup").allowedOrigins("http://localhost:4200");
				registry.addMapping("/moviereview/signup").allowCredentials(true);
				
				registry.addMapping("/moviereview/signout").allowedOrigins("http://localhost:4200");
				registry.addMapping("/moviereview/signout").allowCredentials(true);
				
				registry.addMapping("/moviereview/users/all").allowedOrigins("http://localhost:4200");
				registry.addMapping("/moviereview/users/all").allowCredentials(true);
				
				registry.addMapping("/moviereview/movies/all").allowedOrigins("http://localhost:4200");
				registry.addMapping("/moviereview/movies/all").allowCredentials(true);
				
				registry.addMapping("/moviereview/movies/now-showing/all").allowedOrigins("http://localhost:4200");
				registry.addMapping("/moviereview/movies/now-showing/all").allowCredentials(true);

				registry.addMapping("/moviereview/movies/coming-soon/all").allowedOrigins("http://localhost:4200");
				registry.addMapping("/moviereview/movies/coming-soon/all").allowCredentials(true);
				
				registry.addMapping("/moviereview/movies/most-popular/all").allowedOrigins("http://localhost:4200");
				registry.addMapping("/moviereview/movies/most-popular/all").allowCredentials(true);
				
				registry.addMapping("/moviereview/movies/save").allowedOrigins("http://localhost:4200");
				registry.addMapping("/moviereview/movies/save").allowCredentials(true);
				
				registry.addMapping("/moviereview/movies/edit").allowedOrigins("http://localhost:4200");
				registry.addMapping("/moviereview/movies/edit").allowCredentials(true);

				registry.addMapping("/moviereview/movies/delete/*").allowedOrigins("http://localhost:4200");
				registry.addMapping("/moviereview/movies/delete/*").allowCredentials(true);
				
				registry.addMapping("/moviereview/reviews/search/*").allowedOrigins("http://localhost:4200");
				registry.addMapping("/moviereview/reviews/search/*").allowCredentials(true);

				registry.addMapping("/moviereview/reviews/save").allowedOrigins("http://localhost:4200");
				registry.addMapping("/moviereview/reviews/save").allowCredentials(true);

				registry.addMapping("/moviereview/reviews/edit").allowedOrigins("http://localhost:4200");
				registry.addMapping("/moviereview/reviews/edit").allowCredentials(true);

				registry.addMapping("/moviereview/reviews/delete/*").allowedOrigins("http://localhost:4200");
				registry.addMapping("/moviereview/reviews/delete/*").allowCredentials(true);
				
				registry.addMapping("/moviereview/movies/details/*").allowedOrigins("http://localhost:4200");
				registry.addMapping("/moviereview/movies/details/*").allowCredentials(true);
				
				registry.addMapping("/moviereview/reviews/search/users/*").allowedOrigins("http://localhost:4200");
				registry.addMapping("/moviereview/reviews/search/users/*").allowCredentials(true);

			
			}
		};
	}
}



