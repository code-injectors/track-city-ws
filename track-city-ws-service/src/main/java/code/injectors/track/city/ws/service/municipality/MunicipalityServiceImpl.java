package code.injectors.track.city.ws.service.municipality;

import code.injectors.track.city.ws.domain.entity.municipality.Municipality;
import code.injectors.track.city.ws.domain.repository.GenericRepository;
import code.injectors.track.city.ws.domain.repository.municipality.MunicipalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Chrisostomos Bakouras
 */
@Service
public class MunicipalityServiceImpl implements MunicipalityService {

    private final MunicipalityRepository municipalityRepository;

    @Autowired
    public MunicipalityServiceImpl(MunicipalityRepository municipalityRepository) {
        this.municipalityRepository = municipalityRepository;
    }

    @Override
    public GenericRepository<Municipality> getRepository() {
        return municipalityRepository;
    }
}
