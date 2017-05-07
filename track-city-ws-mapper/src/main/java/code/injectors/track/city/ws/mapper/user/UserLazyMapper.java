package code.injectors.track.city.ws.mapper.user;

import code.injectors.track.city.ws.domain.entity.user.User;
import code.injectors.track.city.ws.dto.user.UserLazyDTO;
import code.injectors.track.city.ws.mapper.PageMapper;
import code.injectors.track.city.ws.mapper.ReferenceMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Chatzakis Nikolaos
 */
@Mapper(uses = ReferenceMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserLazyMapper extends PageMapper<User, UserLazyDTO> {
}
