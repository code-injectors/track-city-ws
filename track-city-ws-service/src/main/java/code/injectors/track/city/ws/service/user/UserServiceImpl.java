package code.injectors.track.city.ws.service.user;

import code.injectors.track.city.ws.domain.entity.user.User;
import code.injectors.track.city.ws.domain.repository.GenericRepository;
import code.injectors.track.city.ws.domain.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Chrisostomos Bakouras
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public GenericRepository<User> getRepository() {
        return userRepository;
    }
}
