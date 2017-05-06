package code.injectors.track.city.ws.domain.repository;

import code.injectors.track.city.ws.domain.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Chrisostomos Bakouras
 */
@NoRepositoryBean
public interface GenericRepository<T extends BaseEntity> extends JpaRepository<T, String> {
}
