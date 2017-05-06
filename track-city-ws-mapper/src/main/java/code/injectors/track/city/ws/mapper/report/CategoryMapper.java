package code.injectors.track.city.ws.mapper.report;

import code.injectors.track.city.ws.domain.entity.report.Category;
import code.injectors.track.city.ws.dto.report.CategoryDTO;
import code.injectors.track.city.ws.mapper.PageMapper;
import org.mapstruct.Mapper;

/**
 * @author Chatzakis Nikolaos
 */
@Mapper
public interface CategoryMapper extends PageMapper<Category, CategoryDTO> {
}
