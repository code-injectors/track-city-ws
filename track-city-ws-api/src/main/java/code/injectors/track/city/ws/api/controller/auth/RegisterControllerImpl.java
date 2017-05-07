package code.injectors.track.city.ws.api.controller.auth;

import code.injectors.track.city.ws.commons.constant.RoleNames;
import code.injectors.track.city.ws.domain.entity.user.QRole;
import code.injectors.track.city.ws.domain.entity.user.User;
import code.injectors.track.city.ws.dto.user.UserDTO;
import code.injectors.track.city.ws.dto.user.UserLazyDTO;
import code.injectors.track.city.ws.mapper.user.UserLazyMapper;
import code.injectors.track.city.ws.mapper.user.UserMapper;
import code.injectors.track.city.ws.service.user.RoleService;
import code.injectors.track.city.ws.service.user.UserService;
import javaslang.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * @author Chrisostomos Bakouras
 */
@RestController
@RequestMapping("/auth")
public class RegisterControllerImpl implements RegisterController {

    private final static Logger logger = LoggerFactory.getLogger(RegisterControllerImpl.class);

    private final UserMapper userMapper;
    private final UserLazyMapper userLazyMapper;
    private final RoleService roleService;
    private final UserService userService;

    public RegisterControllerImpl(UserMapper userMapper, UserLazyMapper userLazyMapper, RoleService roleService, UserService userService) {
        this.userMapper = userMapper;
        this.userLazyMapper = userLazyMapper;
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserLazyDTO dto) {
        return Try
                .of(() -> {
                    final User user = userLazyMapper.fromDTO(dto);
                    user.setId(null);
                    roleService.findOne(QRole.role.name.eq(RoleNames.CLIENT))
                            .forEach(roles -> roles.forEach(user::setRole));
                    return user;
                })
                .flatMap(userService::create)
                .map(userMapper::toDTO)
                .map(createdDto -> ResponseEntity
                        .created(linkTo(getClass()).slash(createdDto.getId()).toUri())
                        .body(createdDto))
                .onFailure(throwable -> logger.error("Could not register user", throwable))
                .getOrElse(() -> ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .build());
    }
}
