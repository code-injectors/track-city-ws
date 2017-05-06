package code.injectors.track.city.ws.api;

import code.injectors.track.city.ws.domain.TrackCityWsDomainConfiguration;
import code.injectors.track.city.ws.mapper.TrackCityWsMapperConfiguration;
import code.injectors.track.city.ws.security.TrackCityWsSecurityConfiguration;
import code.injectors.track.city.ws.service.TrackCityWsServiceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

/**
 * @author Chatzakis Nikolaos
 */
@SpringBootApplication
@Import({
        TrackCityWsDomainConfiguration.class,
        TrackCityWsSecurityConfiguration.class,
        TrackCityWsServiceConfiguration.class,
        TrackCityWsMapperConfiguration.class,
})
public class TrackCityWsApiConfiguration extends SpringBootServletInitializer {

    public static void main(String... args) {
        SpringApplication.run(TrackCityWsApiConfiguration.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TrackCityWsApiConfiguration.class);
    }

}