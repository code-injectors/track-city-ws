package code.injectors.track.city.ws.service;

import code.injectors.track.city.ws.domain.entity.BaseEntity;
import code.injectors.track.city.ws.domain.entity.user.User;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Chrisostomos Bakouras.
 */
public interface PageableCrudService<T extends BaseEntity> extends CrudService<T> {

    Page<T> findAll(User user, Predicate dynamicPredicate, Pageable pageable);
}
