package code.injectors.track.city.ws.domain.repository.report;

import code.injectors.track.city.ws.domain.entity.report.QReport;
import code.injectors.track.city.ws.domain.entity.report.Report;
import code.injectors.track.city.ws.domain.repository.GenericRepository;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;

/**
 * @author Chrisostomos Bakouras
 */
@Repository
public interface ReportRepository extends GenericRepository<Report>, QuerydslBinderCustomizer<QReport> {

    @Override
    default void customize(QuerydslBindings bindings, QReport root) {
        bindings.bind(root.title)
                .first(StringExpression::containsIgnoreCase);

        bindings.bind(root.category.id)
                .first((stringPath, s) -> stringPath.in(s.split(",")));
    }
}
