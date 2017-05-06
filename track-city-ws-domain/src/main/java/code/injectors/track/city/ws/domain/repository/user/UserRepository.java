package code.injectors.track.city.ws.domain.repository.user;

import code.injectors.track.city.ws.domain.entity.user.QUser;
import code.injectors.track.city.ws.domain.entity.user.User;
import code.injectors.track.city.ws.domain.repository.GenericRepository;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;

/**
 * @author Chrisostomos Bakouras
 */
@Repository
public interface UserRepository extends GenericRepository<User>, QuerydslBinderCustomizer<QUser> {

    @Override
    default void customize(QuerydslBindings bindings, QUser root) {
        bindings.bind(root.role.id)
                .first((stringPath, s) -> stringPath.in(s.split(",")));

        bindings.bind(root.firstName)
                .first((stringPath, s) -> stringPath.containsIgnoreCase(s).or(root.lastName.containsIgnoreCase(s)));

        bindings.bind(root.lastName)
                .first((stringPath, s) -> stringPath.containsIgnoreCase(s).or(root.firstName.containsIgnoreCase(s)));
    }

    User findByEmail(String username);
}
