package code.injectors.track.city.ws.mapper.user;

import code.injectors.track.city.ws.domain.entity.user.User;
import code.injectors.track.city.ws.dto.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.DigestUtils;

/**
 * @author Chatzakis Nikolaos
 */
public abstract class UserMapperDecorator implements UserMapper {

    @Autowired
    @Qualifier("delegate")
    private UserMapper delegate;

    @Override
    public UserDTO toDTO(User object) {
        final UserDTO user = delegate.toDTO(object);

        user.setEmailHash(DigestUtils.md5DigestAsHex(user.getEmail().getBytes()));

        return user;
    }
}
