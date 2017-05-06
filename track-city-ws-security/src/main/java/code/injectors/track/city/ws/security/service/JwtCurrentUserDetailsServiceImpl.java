package code.injectors.track.city.ws.security.service;

import code.injectors.track.city.ws.domain.repository.user.UserRepository;
import code.injectors.track.city.ws.security.domain.JwtCurrentUser;
import javaslang.control.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtCurrentUserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public JwtCurrentUserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return Option.of(userRepository.findByEmail(email))
                .map(JwtCurrentUser::new)
                .getOrElseThrow(() -> new UsernameNotFoundException(String.format("No user found with username '%s'.", email)));
    }
}
