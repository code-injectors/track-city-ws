package code.injectors.track.city.ws.mapper.user;

import code.injectors.track.city.ws.domain.entity.user.User;
import code.injectors.track.city.ws.dto.user.UserDTO;
import code.injectors.track.city.ws.mapper.PageMapper;
import code.injectors.track.city.ws.mapper.municipality.MunicipalityMapper;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Chatzakis Nikolaos
 */
@Mapper(uses = {
        RoleMapper.class,
        MunicipalityMapper.class
}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
@DecoratedWith(UserMapperDecorator.class)
public interface UserMapper extends PageMapper<User, UserDTO> {
}
