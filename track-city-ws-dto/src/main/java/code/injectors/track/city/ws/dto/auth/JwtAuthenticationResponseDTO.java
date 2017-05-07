package code.injectors.track.city.ws.dto.auth;

import code.injectors.track.city.ws.dto.user.UserDTO;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Chrisostomos Bakouras
 */
public class JwtAuthenticationResponseDTO implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;

    private final Date expiration;

    private final UserDTO user;

    public JwtAuthenticationResponseDTO(final String token, final Date expiration, final UserDTO user) {
        this.token = token;
        this.expiration = expiration;
        this.user = user;
    }

    public String getToken() {
        return this.token;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getExpiration() {
        return expiration;
    }

    public UserDTO getUser() {
        return user;
    }
}
