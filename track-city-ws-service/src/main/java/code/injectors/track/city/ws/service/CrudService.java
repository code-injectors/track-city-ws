package code.injectors.track.city.ws.service;

import code.injectors.track.city.ws.domain.entity.BaseEntity;
import code.injectors.track.city.ws.domain.repository.GenericRepository;
import com.querydsl.core.types.Predicate;
import javaslang.control.Option;
import javaslang.control.Try;

/**
 * @author Chrisostomos Bakouras.
 */
public interface CrudService<E extends BaseEntity> {

    GenericRepository<E> getRepository();

    default Try<Option<E>> findOne(String id) {
        return Try.of(() -> Option.of(getRepository().findOne(id)));
    }

    default Try<Option<E>> findOne(Predicate predicate) {
        return Try.of(() -> Option.of(getRepository().findOne(predicate)));
    }

    default Try<E> save(E entity) {
        return Try.of(() -> getRepository().save(entity));
    }

    default Try<E> update(E entity) {
        return save(entity);
    }

    default Try<E> create(E entity) {
        return save(entity);
    }

    default Try<Void> delete(String id) {
        return Try.run(() -> getRepository().delete(id));
    }

    default Try<Boolean> exists(String id) {
        return Try.of(() -> getRepository().exists(id));
    }
}
