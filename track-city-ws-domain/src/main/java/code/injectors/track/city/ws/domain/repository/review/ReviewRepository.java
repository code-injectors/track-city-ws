package code.injectors.track.city.ws.domain.repository.review;

import code.injectors.track.city.ws.domain.entity.review.Review;
import code.injectors.track.city.ws.domain.repository.GenericRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Chrisostomos Bakouras
 */
@Repository
public interface ReviewRepository extends GenericRepository<Review> {
}
