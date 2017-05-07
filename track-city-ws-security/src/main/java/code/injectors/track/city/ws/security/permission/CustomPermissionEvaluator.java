package code.injectors.track.city.ws.security.permission;

import code.injectors.track.city.ws.domain.entity.BaseEntity;
import code.injectors.track.city.ws.security.permission.exception.PermissionNotDefinedException;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Optional;

/**
 * @author Chrisostomos Bakouras.
 */
@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

    private final PermissionFactory permissionFactory;

    public CustomPermissionEvaluator(PermissionFactory permissionFactory) {
        this.permissionFactory = permissionFactory;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        return canHandle(authentication, targetDomainObject, permission) &&
                checkPermission(authentication, targetDomainObject, (String) permission);
    }

    private boolean canHandle(Authentication authentication, Object targetDomainObject, Object permission) {
        return targetDomainObject != null && authentication != null && permission instanceof String;
    }

    private boolean checkPermission(Authentication authentication, Object targetDomainObject, String permissionKey) {
        final Permission permission = Optional.ofNullable(permissionFactory.getPermission(permissionKey))
                .orElseThrow(() -> new PermissionNotDefinedException(targetDomainObject.getClass(), permissionKey));

        return permission.isAllowed(authentication, targetDomainObject);
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return canHandle(authentication, targetId, targetType, permission) &&
                checkPermission(authentication, targetId, targetType, (String) permission);
    }

    private boolean canHandle(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return authentication != null && targetId != null && targetType != null && permission instanceof String;
    }

    private boolean checkPermission(Authentication authentication, Serializable targetId, String targetType, String permissionKey) {
        try {
            Class<?> clazz = Class.forName(targetType);
            BaseEntity domainObject = (BaseEntity) clazz.newInstance();
            domainObject.setId(targetId.toString());

            final Permission permission = Optional.ofNullable(permissionFactory.getPermission(permissionKey))
                    .orElseThrow(() -> new PermissionNotDefinedException(clazz, permissionKey));

            return permission.isAllowed(authentication, domainObject);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
