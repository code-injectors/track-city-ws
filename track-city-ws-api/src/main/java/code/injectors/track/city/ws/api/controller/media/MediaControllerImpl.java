package code.injectors.track.city.ws.api.controller.media;

import code.injectors.track.city.ws.commons.constant.EndPoint;
import code.injectors.track.city.ws.domain.entity.media.Media;
import code.injectors.track.city.ws.dto.media.MediaDTO;
import code.injectors.track.city.ws.mapper.PageMapper;
import code.injectors.track.city.ws.mapper.media.MediaMapper;
import code.injectors.track.city.ws.service.PageableCrudService;
import code.injectors.track.city.ws.service.config.TrackCityConfigurationProperties;
import code.injectors.track.city.ws.service.media.MediaService;
import com.querydsl.core.types.Predicate;
import javaslang.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @author Chrisostomos Bakouras
 */
@RestController
@RequestMapping(EndPoint.MEDIA)
public class MediaControllerImpl implements MediaController {

    private final MediaService mediaService;
    private final MediaMapper mediaMapper;
    private final TrackCityConfigurationProperties configurationProperties;

    @Autowired
    public MediaControllerImpl(MediaService mediaService, MediaMapper mediaMapper, TrackCityConfigurationProperties configurationProperties) {
        this.mediaService = mediaService;
        this.mediaMapper = mediaMapper;
        this.configurationProperties = configurationProperties;
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
        return mediaService;
    }

    @Override
    public ResponseEntity<Page<MediaDTO>> getAll(@QuerydslPredicate(root = Media.class) Predicate predicate, Pageable pageable) {
        return getAllDefaultImplementation(predicate, pageable);
    }

    @PostMapping("/{mediaId}/upload")
    public ResponseEntity upload(@PathVariable("mediaId") final String mediaId,
                                 @RequestParam(value = "multipart", required = false) final MultipartFile multipartFile,
                                 @RequestParam(value = "type") final String type) {

        final Try.CheckedSupplier<InputStream> multipartIS = multipartFile.isEmpty() ? null : multipartFile::getInputStream;

        return mediaService.upload(mediaId, multipartIS, type)
                .map(aVoid -> ResponseEntity.noContent().build())
                .onFailure(throwable -> getLogger().error(String.format("Couldn't upload image for media with id %s", mediaId), throwable))
                .getOrElseGet(throwable -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @GetMapping("/{mediaId}/display")
    public FileSystemResource showImage(@PathVariable("mediaId") final String mediaId) {
        return new FileSystemResource(
                configurationProperties.getFileSystemImagePathWithSeparator() + mediaId
        );
    }
}
