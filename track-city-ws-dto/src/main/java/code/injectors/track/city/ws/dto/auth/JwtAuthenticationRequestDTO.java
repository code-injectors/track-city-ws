package code.injectors.track.city.ws.dto.auth;

import java.io.Serializable;

/**
 * @author Chrisostomos Bakouras
 */
public class JwtAuthenticationRequestDTO implements Serializable {

    private static final long serialVersionUID = -8445943548965154778L;

    private String username;
    private String password;

    public JwtAuthenticationRequestDTO() {
    }

    public JwtAuthenticationRequestDTO(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
