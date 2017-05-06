package code.injectors.track.city.ws.mapper.user;

import code.injectors.track.city.ws.domain.entity.user.User;
import code.injectors.track.city.ws.dto.user.UserLazyDTO;
import code.injectors.track.city.ws.mapper.GenericMapper;
import code.injectors.track.city.ws.mapper.ReferenceMapper;
import org.mapstruct.Mapper;

/**
 * @author Chatzakis Nikolaos
 */
@Mapper(uses = ReferenceMapper.class)
public interface UserLazyMapper extends GenericMapper<User, UserLazyDTO> {
}
