package code.injectors.track.city.ws.dto.auth;

import java.io.Serializable;

/**
 * @author Chrisostomos Bakouras
 */
public class JwtAuthenticationResponseDTO implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;

    public JwtAuthenticationResponseDTO(final String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
