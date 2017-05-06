package code.injectors.track.city.ws.mapper.report;

import code.injectors.track.city.ws.domain.entity.report.Report;
import code.injectors.track.city.ws.dto.report.ReportLazyDTO;
import code.injectors.track.city.ws.mapper.PageMapper;
import code.injectors.track.city.ws.mapper.ReferenceMapper;
import org.mapstruct.Mapper;

/**
 * @author Chatzakis Nikolaos
 */
@Mapper(uses = ReferenceMapper.class)
public interface ReportLazyMapper extends PageMapper<Report, ReportLazyDTO> {
}
