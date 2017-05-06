package code.injectors.track.city.ws.service.report;

import code.injectors.track.city.ws.domain.entity.report.Report;
import code.injectors.track.city.ws.domain.repository.GenericRepository;
import code.injectors.track.city.ws.domain.repository.report.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
