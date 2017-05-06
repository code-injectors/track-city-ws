package code.injectors.track.city.ws.api.controller.user;

import code.injectors.track.city.ws.api.controller.PageableController;
import code.injectors.track.city.ws.domain.entity.user.User;
import code.injectors.track.city.ws.dto.user.UserDTO;
import code.injectors.track.city.ws.dto.user.UserLazyDTO;

/**
 * @author Chrisostomos Bakouras
 */
public interface UserController extends PageableController<User, UserDTO, UserLazyDTO> {
}
