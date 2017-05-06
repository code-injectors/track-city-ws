package code.injectors.track.city.ws.service;

import code.injectors.track.city.ws.domain.entity.BaseEntity;

/**
 * @author Chrisostomos Bakouras.
 */
public interface CrudService<T extends BaseEntity> {

    T findOne(String id);

    T update(T entity, String id);

    T create(T entity);

    void delete(String id);
}
