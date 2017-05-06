package code.injectors.track.city.ws.mapper.municipality;

import code.injectors.track.city.ws.domain.entity.municipality.Municipality;
import code.injectors.track.city.ws.dto.municipality.MunicipalityDTO;
import code.injectors.track.city.ws.mapper.PageMapper;
import org.mapstruct.Mapper;

/**
 * @author Chatzakis Nikolaos
 */
@Mapper
public interface MunicipalityMapper extends PageMapper<Municipality, MunicipalityDTO> {
}
