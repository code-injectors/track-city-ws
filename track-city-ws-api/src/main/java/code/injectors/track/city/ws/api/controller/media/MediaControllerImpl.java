package code.injectors.track.city.ws.api.controller.media;

import code.injectors.track.city.ws.domain.entity.media.Media;
import code.injectors.track.city.ws.dto.media.MediaDTO;
import code.injectors.track.city.ws.mapper.PageMapper;
import code.injectors.track.city.ws.mapper.media.MediaMapper;
import code.injectors.track.city.ws.service.PageableCrudService;
import code.injectors.track.city.ws.service.media.MediaService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chrisostomos Bakouras
 */
@RestController
public class MediaControllerImpl implements MediaController {

    private final MediaService mediaService;
    private final MediaMapper mediaMapper;

    @Autowired
    public MediaControllerImpl(MediaService mediaService, MediaMapper mediaMapper) {
        this.mediaService = mediaService;
        this.mediaMapper = mediaMapper;
    }

    @Override
    public PageMapper<Media, MediaDTO> getMapper() {
        return mediaMapper;
    }

    @Override
    public PageMapper<Media, MediaDTO> getReferenceMapper() {
        return mediaMapper;
    }

    @Override
    public PageableCrudService<Media> getService() {
        return null;
    }

    @Override
    public ResponseEntity<Page<MediaDTO>> getAll(Predicate predicate, Pageable pageable) {
        return getAllDefaultImplementation(predicate, pageable);
    }
}
