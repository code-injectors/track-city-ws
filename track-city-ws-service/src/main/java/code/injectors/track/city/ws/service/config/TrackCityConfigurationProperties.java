package code.injectors.track.city.ws.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author Chatzakis Nikolaos
 */
@Component
@ConfigurationProperties("track-city-ws")
public class TrackCityConfigurationProperties {

    private String fileSystemImagePath;

    public String getFileSystemImagePath() {
        return this.fileSystemImagePath;
    }

    public String getFileSystemImagePathWithSeparator() {
        return fileSystemImagePath.endsWith(File.separator)
                ? fileSystemImagePath : fileSystemImagePath + File.separator;
    }
}
