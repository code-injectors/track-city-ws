package code.injectors.track.city.ws.mapper.user;

import code.injectors.track.city.ws.domain.entity.user.User;
import code.injectors.track.city.ws.dto.user.UserDTO;
import code.injectors.track.city.ws.mapper.GenericMapper;
import code.injectors.track.city.ws.mapper.municipality.MunicipalityMapper;
import org.mapstruct.Mapper;

/**
 * @author Chatzakis Nikolaos
 */
@Mapper(uses = {
        RoleMapper.class,
        MunicipalityMapper.class
})
public interface UserMapper extends GenericMapper<User, UserDTO> {
}
