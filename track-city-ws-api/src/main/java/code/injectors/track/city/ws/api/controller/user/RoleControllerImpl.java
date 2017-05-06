package code.injectors.track.city.ws.api.controller.user;

import code.injectors.track.city.ws.domain.entity.user.Role;
import code.injectors.track.city.ws.dto.user.RoleDTO;
import code.injectors.track.city.ws.mapper.PageMapper;
import code.injectors.track.city.ws.mapper.user.RoleMapper;
import code.injectors.track.city.ws.service.PageableCrudService;
import code.injectors.track.city.ws.service.user.RoleService;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chatzakis Nikolaos
 */
@RestController
public class RoleControllerImpl implements RoleController {

    private final RoleMapper roleMapper;
    private final RoleService roleService;

    public RoleControllerImpl(RoleMapper roleMapper, RoleService roleService) {
        this.roleMapper = roleMapper;
        this.roleService = roleService;
    }

    @Override
    public PageMapper<Role, RoleDTO> getMapper() {
        return roleMapper;
    }

    @Override
    public PageMapper<Role, RoleDTO> getReferenceMapper() {
        return roleMapper;
    }

    @Override
    public PageableCrudService<Role> getService() {
        return roleService;
    }

    @Override
    public ResponseEntity<Page<RoleDTO>> getAll(Predicate predicate, Pageable pageable) {
        return getAllDefaultImplementation(predicate, pageable);
    }
}
