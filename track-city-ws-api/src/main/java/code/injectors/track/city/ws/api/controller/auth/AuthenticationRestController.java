package code.injectors.track.city.ws.api.controller.auth;

import code.injectors.track.city.ws.api.config.util.JwtTokenUtil;
import code.injectors.track.city.ws.dto.auth.JwtAuthenticationRequestDTO;
import code.injectors.track.city.ws.dto.auth.JwtAuthenticationResponseDTO;
import code.injectors.track.city.ws.mapper.user.UserMapper;
import code.injectors.track.city.ws.security.domain.JwtCurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author Chrisostomos Bakouras
 */
@RestController
public class AuthenticationRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    private final UserDetailsService userDetailsService;

    private final UserMapper userMapper;

    @Autowired
    public AuthenticationRestController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, UserDetailsService userDetailsService, UserMapper userMapper) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
        this.userMapper = userMapper;
    }

    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequestDTO authenticationRequest, Device device) throws AuthenticationException {

        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-security so we can generate token
        final JwtCurrentUser user = (JwtCurrentUser) userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(user, device);
        final Date expirationDateFromToken = jwtTokenUtil.getExpirationDateFromToken(token);

        // Return the token
        return ResponseEntity.ok(new JwtAuthenticationResponseDTO(token, expirationDateFromToken, user.getId()));
    }

    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        final JwtCurrentUser user = (JwtCurrentUser) userDetailsService.loadUserByUsername(username);

        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            final String refreshedToken = jwtTokenUtil.refreshToken(token);
            final Date expirationDateFromToken = jwtTokenUtil.getExpirationDateFromToken(token);

            return ResponseEntity.ok(new JwtAuthenticationResponseDTO(refreshedToken, expirationDateFromToken, user.getId()));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
