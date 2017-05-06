package code.injectors.track.city.ws.api.controller.auth;

import code.injectors.track.city.ws.api.config.util.JwtTokenUtil;
import code.injectors.track.city.ws.security.domain.JwtCurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Chrisostomos Bakouras
 */
@RestController
public class UserRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    private final JwtTokenUtil jwtTokenUtil;

    private final UserDetailsService userDetailsService;

    @Autowired
    public UserRestController(JwtTokenUtil jwtTokenUtil, UserDetailsService userDetailsService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public JwtCurrentUser getAuthenticatedUser(HttpServletRequest request) {
        final String token = request.getHeader(tokenHeader);
        final String username = jwtTokenUtil.getUsernameFromToken(token);

        return (JwtCurrentUser) userDetailsService.loadUserByUsername(username);
    }
}
