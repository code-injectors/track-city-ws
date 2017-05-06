package code.injectors.track.city.ws.api.controller.user;

import code.injectors.track.city.ws.commons.constant.EndPoint;
import code.injectors.track.city.ws.domain.entity.user.User;
import code.injectors.track.city.ws.dto.user.UserDTO;
import code.injectors.track.city.ws.dto.user.UserLazyDTO;
import code.injectors.track.city.ws.mapper.PageMapper;
import code.injectors.track.city.ws.mapper.user.UserLazyMapper;
import code.injectors.track.city.ws.mapper.user.UserMapper;
import code.injectors.track.city.ws.service.PageableCrudService;
import code.injectors.track.city.ws.service.user.UserService;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chatzakis Nikolaos
 */
@RestController
@RequestMapping(EndPoint.USERS)
public class UserControllerImpl implements UserController {

    private final UserMapper userMapper;
    private final UserLazyMapper userLazyMapper;
    private final UserService userService;

    public UserControllerImpl(UserMapper userMapper, UserLazyMapper userLazyMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userLazyMapper = userLazyMapper;
        this.userService = userService;
    }

    @Override
    public PageMapper<User, UserDTO> getMapper() {
        return userMapper;
    }

    @Override
    public PageMapper<User, UserLazyDTO> getReferenceMapper() {
        return userLazyMapper;
    }

    @Override
    public PageableCrudService<User> getService() {
        return userService;
    }

    @Override
    public ResponseEntity<Page<UserDTO>> getAll(Predicate predicate, Pageable pageable) {
        return getAllDefaultImplementation(predicate, pageable);
    }
}
