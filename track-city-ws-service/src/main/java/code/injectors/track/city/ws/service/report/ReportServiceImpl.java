package code.injectors.track.city.ws.service.report;

import code.injectors.track.city.ws.domain.entity.report.Report;
import code.injectors.track.city.ws.domain.entity.report.ReportStatus;
import code.injectors.track.city.ws.domain.repository.GenericRepository;
import code.injectors.track.city.ws.domain.repository.report.ReportRepository;
import javaslang.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Chrisostomos Bakouras
 */
@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public GenericRepository<Report> getRepository() {
        return reportRepository;
    }

    @Override
    public Try<Report> create(Report entity) {
        entity.setCreatedAt(new Date());
        entity.setStatus(ReportStatus.PENDING);

        return Try.of(() -> reportRepository.save(entity));
    }

    @Override
    public Report changeStatus(String id, String status) {
        final Report report = getRepository().findOne(id);

        if (report != null) {
            report.setStatus(ReportStatus.valueOf(status));
            update(report);
        }

        return report;
    }
}
