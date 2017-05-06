package code.injectors.track.city.ws.api.controller.review;

import code.injectors.track.city.ws.api.controller.PageableController;
import code.injectors.track.city.ws.domain.entity.review.Review;
import code.injectors.track.city.ws.dto.review.ReviewDTO;
import code.injectors.track.city.ws.dto.review.ReviewLazyDTO;

/**
 * @author Chrisostomos Bakouras
 */
public interface ReviewController extends PageableController<Review, ReviewDTO, ReviewLazyDTO> {
}
