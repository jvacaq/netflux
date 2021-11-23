package guru.springframework.service;

import guru.springframework.domain.Movie;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {
    Mono<Movie> getMoviById(String id);
    Flux<Movie> getAllMovies();
}
