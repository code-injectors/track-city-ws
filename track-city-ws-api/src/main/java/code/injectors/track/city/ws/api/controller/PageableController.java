package code.injectors.track.city.ws.api.controller;

import code.injectors.track.city.ws.domain.entity.BaseEntity;
import code.injectors.track.city.ws.dto.AbstractDTO;
import code.injectors.track.city.ws.mapper.PageMapper;
import code.injectors.track.city.ws.service.PageableCrudService;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Chrisostomos Bakouras
 */
public interface PageableController<E extends BaseEntity, D extends AbstractDTO, RD extends AbstractDTO> extends CrudController<E, D, RD> {

    PageMapper<E, D> getMapper();

    PageMapper<E, RD> getReferenceMapper();

    PageableCrudService<E> getService();

    @GetMapping
    ResponseEntity<Page<D>> getAll(Predicate predicate, Pageable pageable);

    default ResponseEntity<Page<D>> getAllDefaultImplementation(final Predicate predicate, final Pageable pageable) {
        return getService().findAll(predicate, pageable)
                .map(page -> getMapper().toDTO(page))
                .map(ResponseEntity::ok)
                .onFailure(throwable -> getLogger().error("Error occurred while processing GET request", throwable))
                .getOrElse(() -> ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .build());
    }
}
