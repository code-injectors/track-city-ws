package code.injectors.track.city.ws.domain.repository.system;

import code.injectors.track.city.ws.domain.entity.user.User;
import code.injectors.track.city.ws.domain.repository.GenericRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Chrisostomos Bakouras
 */
@Repository
public interface UserRepository extends GenericRepository<User> {
}
