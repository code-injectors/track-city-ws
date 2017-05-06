package code.injectors.track.city.ws.api.controller;

import code.injectors.track.city.ws.domain.entity.BaseEntity;
import code.injectors.track.city.ws.dto.AbstractDTO;
import code.injectors.track.city.ws.mapper.GenericMapper;
import code.injectors.track.city.ws.service.CrudService;
import javaslang.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static javaslang.API.$;
import static javaslang.API.Case;
import static javaslang.API.Match;
import static javaslang.Patterns.None;
import static javaslang.Patterns.Some;
import static javaslang.Predicates.is;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * @author Chrisostomos Bakouras
 */
public interface CrudController<E extends BaseEntity, D extends AbstractDTO, RD extends AbstractDTO> {

    default Logger getLogger() {
        return LoggerFactory.getLogger(getClass());
    }

    GenericMapper<E, D> getMapper();

    GenericMapper<E, RD> getReferenceMapper();

    CrudService<E> getService();

    @GetMapping("/{id}")
    default ResponseEntity<D> getOne(@PathVariable("id") final String id) {
        return getService().findOne(id)
                .map(optionalEntity -> Match(optionalEntity).<ResponseEntity<D>>of(
                        Case(Some($()), entity -> ResponseEntity
                                .status(HttpStatus.OK)
                                .body(getMapper().toDTO(entity))),
                        Case(None(), ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .build())))
                .onFailure(throwable -> getLogger().error("Error occurred while processing GET/{id} request", throwable))
                .getOrElse(() -> ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .build());
    }

    @PostMapping
    default ResponseEntity<D> post(@RequestBody final RD dto) {
        return Try
                .of(() -> {
                    final E entity = getReferenceMapper().fromDTO(dto);
                    entity.setId(null);
                    return entity;
                })
                .flatMap(entity -> getService().create(entity))
                .map(createdEntity -> getMapper().toDTO(createdEntity))
                .map(createdDto -> ResponseEntity
                        .created(linkTo(getClass()).slash(createdDto.getId()).toUri())
                        .body(createdDto))
                .onFailure(throwable -> getLogger().error("Error occurred while processing POST request", throwable))
                .getOrElse(() -> ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .build());
    }

    @PutMapping("/{id}")
    default ResponseEntity<D> put(@PathVariable("id") final String id, @RequestBody final RD dto) {
        return Try
                .of(() -> {
                    final E entity = getReferenceMapper().fromDTO(dto);
                    entity.setId(id);
                    return entity;
                })
                .flatMap(entity -> getService().exists(entity.getId())
                        .flatMap(exists -> Match(exists).of(
                                Case(is(TRUE), () -> getService().update(entity)
                                        .map(persistedEntity -> getMapper().toDTO(persistedEntity))
                                        .map(persistedDto -> ResponseEntity
                                                .status(HttpStatus.OK)
                                                .body(persistedDto))),
                                Case(is(FALSE), () -> getService().create(entity)
                                        .map(persistedEntity -> getMapper().toDTO(persistedEntity))
                                        .map(persistedDto -> ResponseEntity
                                                .status(HttpStatus.CREATED)
                                                .body(persistedDto))))))
                .onFailure(throwable -> getLogger().error("Error occurred while processing PUT request", throwable))
                .getOrElse(() -> ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .build());
    }

    @DeleteMapping("/{id}")
    default ResponseEntity<Void> delete(@PathVariable("id") final String id) {
        return getService().delete(id)
                .map(ignored -> ResponseEntity
                        .noContent()
                        .<Void>build())
                .onFailure(throwable -> getLogger().error("Error occurred while processing DELETE request", throwable))
                .getOrElse(() -> ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .build());
    }
}
