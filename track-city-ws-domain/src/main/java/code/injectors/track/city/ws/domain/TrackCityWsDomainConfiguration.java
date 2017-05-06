package code.injectors.track.city.ws.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Chatzakis Nikolaos
 */
@Configuration
@ComponentScan
@EntityScan
@EnableJpaRepositories
public class TrackCityWsDomainConfiguration {
}
