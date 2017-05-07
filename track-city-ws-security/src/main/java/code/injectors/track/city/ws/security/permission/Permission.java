package code.injectors.track.city.ws.security.permission;

import org.springframework.security.core.Authentication;

/**
 * @author Chrisostomos Bakouras.
 */
public interface Permission {

    boolean isAllowed(Authentication authentication, Object targetDomainObject);
}
