package code.injectors.track.city.ws.mapper.review;

import code.injectors.track.city.ws.domain.entity.review.Review;
import code.injectors.track.city.ws.dto.review.ReviewDTO;
import code.injectors.track.city.ws.mapper.PageMapper;
import code.injectors.track.city.ws.mapper.user.UserMapper;
import org.mapstruct.Mapper;

/**
 * @author Chatzakis Nikolaos
 */
@Mapper(uses = UserMapper.class)
public interface ReviewMapper extends PageMapper<Review, ReviewDTO> {
}
