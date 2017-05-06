package code.injectors.track.city.ws.mapper.review;

import code.injectors.track.city.ws.domain.entity.review.Review;
import code.injectors.track.city.ws.dto.review.ReviewLazyDTO;
import code.injectors.track.city.ws.mapper.PageMapper;
import code.injectors.track.city.ws.mapper.ReferenceMapper;
import org.mapstruct.Mapper;

/**
 * @author Chatzakis Nikolaos
 */
@Mapper(uses = ReferenceMapper.class)
public interface ReviewLazyMapper extends PageMapper<Review, ReviewLazyDTO> {
}
