package code.injectors.track.city.ws.service.media;

import code.injectors.track.city.ws.domain.entity.media.Media;
import code.injectors.track.city.ws.domain.repository.GenericRepository;
import code.injectors.track.city.ws.domain.repository.media.MediaRepository;
import code.injectors.track.city.ws.service.config.TrackCityConfigurationProperties;
import code.injectors.track.city.ws.service.multipart.MultipartService;
import javaslang.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * @author Chrisostomos Bakouras
 */
@Service
public class MediaServiceImpl implements MediaService {

    private final MediaRepository mediaRepository;
    private final TrackCityConfigurationProperties configurationProperties;
    private final MultipartService multipartService;

    @Autowired
    public MediaServiceImpl(MediaRepository mediaRepository, TrackCityConfigurationProperties configurationProperties, MultipartService multipartService) {
        this.mediaRepository = mediaRepository;
        this.configurationProperties = configurationProperties;
        this.multipartService = multipartService;
    }

    @Override
    public GenericRepository<Media> getRepository() {
        return mediaRepository;
    }

    @Override
    public Try<Void> upload(String mediaId, Try.CheckedSupplier<InputStream> multipartInputStream, String type) {
        final String fullPath = configurationProperties.getFileSystemImagePathWithSeparator()
                + mediaId + "." + type;

        return multipartService.uploadMultipart(fullPath, multipartInputStream);
    }
}
