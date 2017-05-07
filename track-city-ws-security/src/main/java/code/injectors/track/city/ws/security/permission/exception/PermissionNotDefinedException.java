package code.injectors.track.city.ws.security.permission.exception;

/**
 * @author Chatzakis Nikolaos
 */
public class PermissionNotDefinedException extends RuntimeException {

    public PermissionNotDefinedException(Class<?> aClass, String permissionKey) {
        super(aClass.getSimpleName() + " - " + permissionKey + " [NOT DEFINED]");
    }
}
