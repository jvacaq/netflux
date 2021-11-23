package guru.springframework.bootstrap;

import guru.springframework.domain.Movie;
import guru.springframework.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class InitMovies implements CommandLineRunner {

    private final MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        movieRepository.deleteAll()
                .thenMany(Flux.just("Siles of the Lambdas", "AEon Flux", "Enter the Mono<Void>", "The Fluxxinator",
                                "BAck to the future", "Meet the fluxes", "Lord of the fluxes")
                        .map(Movie::new)
                        .flatMap(movieRepository::save))
                .subscribe(null, null, () -> movieRepository.findAll().subscribe(System.out::println));
    }
}
