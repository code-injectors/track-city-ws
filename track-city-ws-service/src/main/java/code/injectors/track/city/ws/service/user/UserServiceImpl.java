package code.injectors.track.city.ws.service.user;

import code.injectors.track.city.ws.domain.entity.user.User;
import code.injectors.track.city.ws.domain.repository.GenericRepository;
import code.injectors.track.city.ws.domain.repository.user.UserRepository;
import javaslang.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Chrisostomos Bakouras
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public GenericRepository<User> getRepository() {
        return userRepository;
    }

    @Override
    public Try<User> save(User entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));

        return Try.of(() -> userRepository.save(entity));
    }

    @Override
    public Try<User> create(User entity) {
        entity.setCreatedAt(new Date());

        return Try.of(() -> userRepository.save(entity));
    }
}
