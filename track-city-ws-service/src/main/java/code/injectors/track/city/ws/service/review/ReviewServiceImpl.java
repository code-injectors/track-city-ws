package code.injectors.track.city.ws.service.review;

import code.injectors.track.city.ws.commons.exceptions.TooManyReviewsException;
import code.injectors.track.city.ws.domain.entity.review.QReview;
import code.injectors.track.city.ws.domain.entity.review.Review;
import code.injectors.track.city.ws.domain.repository.GenericRepository;
import code.injectors.track.city.ws.domain.repository.review.ReviewRepository;
import code.injectors.track.city.ws.service.user.UserService;
import javaslang.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

/**
 * @author Chrisostomos Bakouras
 */
@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserService userService;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, UserService userService) {
        this.reviewRepository = reviewRepository;
        this.userService = userService;
    }

    @Override
    public GenericRepository<Review> getRepository() {
        return reviewRepository;
    }

    @Override
    public Try<Review> save(Review entity) {

        final QReview review = QReview.review;

        Iterator<Review> iterator = reviewRepository.findAll(review.user.id.eq(entity.getUser().getId())
                .and(review.id.eq(entity.getId()))).iterator();

        if (iterator.hasNext()) {
            throw new TooManyReviewsException("One user cannot review one Report more than on times.");
        }

        return Try.of(() -> reviewRepository.save(entity));
    }
}
