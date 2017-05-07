package code.injectors.track.city.ws.service.municipality;

import code.injectors.track.city.ws.domain.entity.municipality.Municipality;
import code.injectors.track.city.ws.domain.repository.GenericRepository;
import code.injectors.track.city.ws.domain.repository.municipality.MunicipalityRepository;
import javaslang.control.Try;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * @author Chrisostomos Bakouras
 */
@Service
public class MunicipalityServiceImpl implements MunicipalityService {

    private final MunicipalityRepository municipalityRepository;

    public MunicipalityServiceImpl(MunicipalityRepository municipalityRepository) {
        this.municipalityRepository = municipalityRepository;
    }

    @Override
    public GenericRepository<Municipality> getRepository() {
        return municipalityRepository;
    }

    @Override
    @PreAuthorize("(isAuthenticated() and hasRole('MUNICIPALITY_ADMIN'))")
    public Try<Municipality> create(Municipality entity) {
        return Try.of(() -> municipalityRepository.save(entity));
    }

    @Override
    @PreAuthorize("(isAuthenticated() and " +
            "(hasRole('MUNICIPALITY_ADMIN')) or " +
            "hasPermission(#entity, 'code.injectors.track.city.ws.domain.entity.Municipality', T(code.injectors.track.city.ws.security.permission.PermissionName).IS_MUNICIPALITY_ADMIN))")
    public Try<Municipality> update(Municipality entity) {
        return Try.of(() -> municipalityRepository.save(entity));
    }

    @Override
    @PreAuthorize("(isAuthenticated() and hasRole('MUNICIPALITY_ADMIN'))")
    public Try<Void> delete(String id) {
        return Try.run(() -> municipalityRepository.delete(id));
    }
}
