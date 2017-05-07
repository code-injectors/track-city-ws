package code.injectors.track.city.ws.security.permission;

import code.injectors.track.city.ws.security.permission.system.MunicipalityAdminPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chrisostomos Bakouras.
 */
@Component
public class PermissionFactory {

    private final Map<String, Permission> permissions;

    @Autowired
    public PermissionFactory(MunicipalityAdminPermission municipalityAdminPermission) {

        final Map<String, Permission> map = new HashMap<>();

        map.put(PermissionName.IS_MUNICIPALITY_ADMIN, municipalityAdminPermission);

        permissions = Collections.unmodifiableMap(map);
    }

    public Permission getPermission(String permission) {
        return permissions.get(permission);
    }
}
