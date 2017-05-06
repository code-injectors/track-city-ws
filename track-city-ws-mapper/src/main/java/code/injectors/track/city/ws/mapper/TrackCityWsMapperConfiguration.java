package code.injectors.track.city.ws.mapper;

import code.injectors.track.city.ws.domain.TrackCityWsDomainConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Chatzakis Nikolaos
 */
@Import(TrackCityWsDomainConfiguration.class)
@ComponentScan
@Configuration
public class TrackCityWsMapperConfiguration {
}
