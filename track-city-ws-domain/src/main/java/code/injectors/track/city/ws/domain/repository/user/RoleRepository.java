package code.injectors.track.city.ws.domain.repository.user;

import code.injectors.track.city.ws.domain.entity.user.QRole;
import code.injectors.track.city.ws.domain.entity.user.Role;
import code.injectors.track.city.ws.domain.repository.GenericRepository;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

/**
 * @author Chrisostomos Bakouras
 */
public interface RoleRepository extends GenericRepository<Role>, QuerydslBinderCustomizer<QRole> {

    @Override
    default void customize(QuerydslBindings bindings, QRole root) {
        bindings.bind(root.id)
                .first((stringPath, s) -> stringPath.in(s.split(",")));
    }
}
