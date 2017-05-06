package code.injectors.track.city.ws.api.controller.report;

import code.injectors.track.city.ws.commons.constant.EndPoint;
import code.injectors.track.city.ws.domain.entity.report.Category;
import code.injectors.track.city.ws.dto.report.CategoryDTO;
import code.injectors.track.city.ws.mapper.PageMapper;
import code.injectors.track.city.ws.mapper.report.CategoryMapper;
import code.injectors.track.city.ws.service.PageableCrudService;
import code.injectors.track.city.ws.service.report.CategoryService;
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
@RequestMapping(EndPoint.CATEGORIES)
public class CategoryControllerImpl implements CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryControllerImpl(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public PageMapper<Category, CategoryDTO> getMapper() {
        return categoryMapper;
    }

    @Override
    public PageMapper<Category, CategoryDTO> getReferenceMapper() {
        return categoryMapper;
    }

    @Override
    public PageableCrudService<Category> getService() {
        return categoryService;
    }

    @Override
    public ResponseEntity<Page<CategoryDTO>> getAll(@QuerydslPredicate(root = Category.class) Predicate predicate, Pageable pageable) {
        return getAllDefaultImplementation(predicate, pageable);
    }
}
