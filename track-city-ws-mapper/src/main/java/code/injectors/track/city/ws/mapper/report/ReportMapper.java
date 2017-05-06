package code.injectors.track.city.ws.mapper.report;

import code.injectors.track.city.ws.domain.entity.report.Report;
import code.injectors.track.city.ws.dto.report.ReportDTO;
import code.injectors.track.city.ws.mapper.PageMapper;
import code.injectors.track.city.ws.mapper.media.MediaMapper;
import code.injectors.track.city.ws.mapper.review.ReviewMapper;
import code.injectors.track.city.ws.mapper.user.UserMapper;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Chatzakis Nikolaos
 */
@Mapper(uses = {
        UserMapper.class,
        CategoryMapper.class,
        MediaMapper.class,
        ReviewMapper.class
}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
@DecoratedWith(ReportMapperDecorator.class)
public interface ReportMapper extends PageMapper<Report, ReportDTO> {
}
