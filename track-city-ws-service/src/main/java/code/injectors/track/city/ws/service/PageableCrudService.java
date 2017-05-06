package code.injectors.track.city.ws.service;

import code.injectors.track.city.ws.domain.entity.BaseEntity;
import code.injectors.track.city.ws.domain.entity.user.User;
import com.querydsl.core.types.Predicate;
import javaslang.control.Try;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Chrisostomos Bakouras.
 */
public interface PageableCrudService<T extends BaseEntity> extends CrudService<T> {

    default Try<Page<T>> findAll(Predicate predicate, Pageable pageable) {
        return Try.of(() -> getRepository().findAll(predicate, pageable));
    }
}
