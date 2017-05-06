package code.injectors.track.city.ws.mapper.user;

import code.injectors.track.city.ws.domain.entity.user.User;
import code.injectors.track.city.ws.dto.user.UserLazyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.DigestUtils;

/**
 * @author Chatzakis Nikolaos
 */
public abstract class UserLazyMapperDecorator implements UserLazyMapper {

    @Autowired
    @Qualifier("delegate")
    private UserLazyMapper delegate;

    @Override
    public UserLazyDTO toDTO(User object) {
        final UserLazyDTO user = delegate.toDTO(object);

        user.setEmailHash(DigestUtils.md5DigestAsHex(user.getEmail().getBytes()));

        return user;
    }
}
