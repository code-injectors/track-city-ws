package code.injectors.track.city.ws.domain.repository.municipality;

import code.injectors.track.city.ws.domain.entity.municipality.Municipality;
import code.injectors.track.city.ws.domain.entity.municipality.QMunicipality;
import code.injectors.track.city.ws.domain.repository.GenericRepository;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;

/**
 * @author Chrisostomos Bakouras
 */
@Repository
public interface MunicipalityRepository extends GenericRepository<Municipality>, QuerydslBinderCustomizer<QMunicipality> {

    @Override
    default void customize(QuerydslBindings bindings, QMunicipality root) {
        bindings.bind(root.name)
                .first(StringExpression::containsIgnoreCase);
    }
}
