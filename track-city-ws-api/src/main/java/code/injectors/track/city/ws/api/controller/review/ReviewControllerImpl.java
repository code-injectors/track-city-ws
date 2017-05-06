package code.injectors.track.city.ws.api.controller.review;

import code.injectors.track.city.ws.commons.constant.EndPoint;
import code.injectors.track.city.ws.domain.entity.review.Review;
import code.injectors.track.city.ws.dto.review.ReviewDTO;
import code.injectors.track.city.ws.dto.review.ReviewLazyDTO;
import code.injectors.track.city.ws.mapper.PageMapper;
import code.injectors.track.city.ws.mapper.review.ReviewLazyMapper;
import code.injectors.track.city.ws.mapper.review.ReviewMapper;
import code.injectors.track.city.ws.service.PageableCrudService;
import code.injectors.track.city.ws.service.review.ReviewService;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chatzakis Nikolaos
 */
@RestController
@RequestMapping(EndPoint.REVIEWS)
public class ReviewControllerImpl implements ReviewController {

    private final ReviewMapper reviewMapper;
    private final ReviewLazyMapper reviewLazyMapper;
    private final ReviewService reviewService;

    public ReviewControllerImpl(ReviewMapper reviewMapper, ReviewLazyMapper reviewLazyMapper, ReviewService reviewService) {
        this.reviewMapper = reviewMapper;
        this.reviewLazyMapper = reviewLazyMapper;
        this.reviewService = reviewService;
    }

    @Override
    public PageMapper<Review, ReviewDTO> getMapper() {
        return reviewMapper;
    }

    @Override
    public PageMapper<Review, ReviewLazyDTO> getReferenceMapper() {
        return reviewLazyMapper;
    }

    @Override
    public PageableCrudService<Review> getService() {
        return reviewService;
    }

    @Override
    public ResponseEntity<Page<ReviewDTO>> getAll(@QuerydslPredicate(root = Review.class) Predicate predicate, Pageable pageable) {
        return getAllDefaultImplementation(predicate, pageable);
    }
}
