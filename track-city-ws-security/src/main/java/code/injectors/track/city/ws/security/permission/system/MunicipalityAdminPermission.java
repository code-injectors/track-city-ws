package code.injectors.track.city.ws.security.permission.system;

import code.injectors.track.city.ws.domain.entity.municipality.Municipality;
import code.injectors.track.city.ws.domain.entity.user.User;
import code.injectors.track.city.ws.security.permission.Permission;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Chatzakis Nikolaos
 */
@Component
public class MunicipalityAdminPermission implements Permission {

    @Override
    public boolean isAllowed(Authentication authentication, Object targetDomainObject) {
        final User user = (User) authentication.getPrincipal();

        final Municipality municipality = (Municipality) targetDomainObject;

        return Optional.of(user.getMunicipality())
                .filter(userMunicipality -> userMunicipality.getId().equals(municipality.getId()))
                .isPresent();
    }
}
