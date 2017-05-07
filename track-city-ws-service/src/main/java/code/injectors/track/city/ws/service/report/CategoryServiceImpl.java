package code.injectors.track.city.ws.service.report;

import code.injectors.track.city.ws.domain.entity.report.Category;
import code.injectors.track.city.ws.domain.repository.GenericRepository;
import code.injectors.track.city.ws.domain.repository.report.CategoryRepository;
import javaslang.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * @author Chrisostomos Bakouras
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public GenericRepository<Category> getRepository() {
        return categoryRepository;
    }

    @Override
    @PreAuthorize("(isAuthenticated() and hasRole('SUPER_USER'))")
    public Try<Category> create(Category entity) {
        return Try.of(() -> categoryRepository.save(entity));
    }

    @Override
    @PreAuthorize("(isAuthenticated() and hasRole('SUPER_USER'))")
    public Try<Category> update(Category entity) {
        return Try.of(() -> categoryRepository.save(entity));
    }

    @Override
    @PreAuthorize("(isAuthenticated() and hasRole('SUPER_USER'))")
    public Try<Void> delete(String id) {
        return Try.run(() -> categoryRepository.delete(id));
    }
}
