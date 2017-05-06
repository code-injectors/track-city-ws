package code.injectors.track.city.ws.mapper.report;

import code.injectors.track.city.ws.domain.entity.report.Report;
import code.injectors.track.city.ws.dto.report.ReportDTO;
import code.injectors.track.city.ws.dto.review.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static java.lang.Math.toIntExact;

/**
 * @author Chatzakis Nikolaos
 */
public abstract class ReportMapperDecorator implements ReportMapper {

    @Autowired
    @Qualifier("delegate")
    private ReportMapper delegate;

    @Override
    public ReportDTO toDTO(Report object) {
        final ReportDTO report = delegate.toDTO(object);

        report.setUpVotes(
                toIntExact(report.getReviews().stream()
                        .filter(ReviewDTO::getUpvote)
                        .count())
        );

        report.setDownVotes(
                toIntExact(report.getReviews().stream()
                        .filter(reviewDTO -> !reviewDTO.getUpvote())
                        .count())
        );
        return report;
    }
}
