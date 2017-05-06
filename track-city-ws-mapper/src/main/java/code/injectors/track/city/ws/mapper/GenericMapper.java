package code.injectors.track.city.ws.mapper;

import java.util.List;

/**
 * @author Chatzakis Nikolaos
 */
public interface GenericMapper<T, D> {

    D toDTO(T object);

    List<D> toDTO(List<T> objects);

    T fromDTO(D DTO);

    List<T> fromDTO(List<D> DTOs);
}
