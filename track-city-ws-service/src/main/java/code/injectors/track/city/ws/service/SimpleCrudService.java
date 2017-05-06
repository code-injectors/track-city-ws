package code.injectors.track.city.ws.service;

import code.injectors.track.city.ws.domain.entity.BaseEntity;

import java.util.List;

/**
 * @author Chrisostomos Bakouras.
 */
public interface SimpleCrudService<T extends BaseEntity> extends CrudService<T> {

    List<T> findAll();
}
