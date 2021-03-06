package code.injectors.track.city.ws.mapper.media;

import code.injectors.track.city.ws.domain.entity.media.Media;
import code.injectors.track.city.ws.dto.media.MediaDTO;
import code.injectors.track.city.ws.mapper.PageMapper;
import org.mapstruct.Mapper;

/**
 * @author Chatzakis Nikolaos
 */
@Mapper
public interface MediaMapper extends PageMapper<Media, MediaDTO> {
}
