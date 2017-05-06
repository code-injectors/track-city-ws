package code.injectors.track.city.ws.service.media;

import code.injectors.track.city.ws.domain.entity.media.Media;
import code.injectors.track.city.ws.domain.repository.GenericRepository;
import code.injectors.track.city.ws.domain.repository.media.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Chrisostomos Bakouras
 */
@Service
public class MediaServiceImpl implements MediaService {

    private final MediaRepository mediaRepository;

    @Autowired
    public MediaServiceImpl(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    @Override
    public GenericRepository<Media> getRepository() {
        return mediaRepository;
    }
}
