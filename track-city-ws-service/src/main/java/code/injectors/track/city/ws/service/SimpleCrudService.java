package code.injectors.track.city.ws.service;

import code.injectors.track.city.ws.domain.entity.BaseEntity;
import javaslang.control.Try;

import java.util.List;

/**
 * @author Chrisostomos Bakouras.
 */
public interface SimpleCrudService<T extends BaseEntity> extends CrudService<T> {

    default Try<List<T>> findAll() {
        return Try.of(() -> getRepository().findAll());
    }
}
