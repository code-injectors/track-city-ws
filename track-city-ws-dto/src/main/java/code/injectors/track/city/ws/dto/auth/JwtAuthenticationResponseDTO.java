package code.injectors.track.city.ws.dto.auth;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Chrisostomos Bakouras
 */
public class JwtAuthenticationResponseDTO implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;

    private final Date expiration;

    public JwtAuthenticationResponseDTO(final String token, final Date expiration) {
        this.token = token;
        this.expiration = expiration;
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
}
