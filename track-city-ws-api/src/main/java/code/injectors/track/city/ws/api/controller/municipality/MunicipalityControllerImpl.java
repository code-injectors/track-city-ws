package code.injectors.track.city.ws.api.controller.municipality;

import code.injectors.track.city.ws.commons.constant.EndPoint;
import code.injectors.track.city.ws.domain.entity.municipality.Municipality;
import code.injectors.track.city.ws.dto.municipality.MunicipalityDTO;
import code.injectors.track.city.ws.mapper.PageMapper;
import code.injectors.track.city.ws.mapper.municipality.MunicipalityMapper;
import code.injectors.track.city.ws.service.PageableCrudService;
import code.injectors.track.city.ws.service.municipality.MunicipalityService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chrisostomos Bakouras
 */
@RestController
@RequestMapping(EndPoint.MUNICIPALITIES)
public class MunicipalityControllerImpl implements MunicipalityController {

    private final MunicipalityService municipalityService;
    private final MunicipalityMapper municipalityMapper;

    @Autowired
    public MunicipalityControllerImpl(MunicipalityService municipalityService, MunicipalityMapper municipalityMapper) {
        this.municipalityService = municipalityService;
        this.municipalityMapper = municipalityMapper;
    }

    @Override
    public PageMapper<Municipality, MunicipalityDTO> getMapper() {
        return municipalityMapper;
    }

    @Override
    public PageMapper<Municipality, MunicipalityDTO> getReferenceMapper() {
        return municipalityMapper;
    }

    @Override
    public PageableCrudService<Municipality> getService() {
        return municipalityService;
    }

    @Override
    public ResponseEntity<Page<MunicipalityDTO>> getAll(@QuerydslPredicate(root = Municipality.class) Predicate predicate, Pageable pageable) {
        return getAllDefaultImplementation(predicate, pageable);
    }
}
