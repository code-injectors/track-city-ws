package code.injectors.track.city.ws.api.controller.report;

import code.injectors.track.city.ws.commons.constant.EndPoint;
import code.injectors.track.city.ws.domain.entity.report.Report;
import code.injectors.track.city.ws.dto.report.ReportDTO;
import code.injectors.track.city.ws.dto.report.ReportLazyDTO;
import code.injectors.track.city.ws.mapper.PageMapper;
import code.injectors.track.city.ws.mapper.report.ReportLazyMapper;
import code.injectors.track.city.ws.mapper.report.ReportMapper;
import code.injectors.track.city.ws.service.PageableCrudService;
import code.injectors.track.city.ws.service.report.ReportService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chrisostomos Bakouras
 */
@RestController
@RequestMapping(EndPoint.REPORTS)
public class ReportControllerImpl implements ReportController {

    private final ReportService reportService;
    private final ReportMapper reportMapper;
    private final ReportLazyMapper reportLazyMapper;

    @Autowired
    public ReportControllerImpl(ReportService reportService, ReportMapper reportMapper, ReportLazyMapper reportLazyMapper) {
        this.reportService = reportService;
        this.reportMapper = reportMapper;
        this.reportLazyMapper = reportLazyMapper;
    }

    @Override
    public PageMapper<Report, ReportDTO> getMapper() {
        return reportMapper;
    }

    @Override
    public PageMapper<Report, ReportLazyDTO> getReferenceMapper() {
        return reportLazyMapper;
    }

    @Override
    public PageableCrudService<Report> getService() {
        return reportService;
    }

    @Override
    public ResponseEntity<Page<ReportDTO>> getAll(Predicate predicate, Pageable pageable) {
        return getAllDefaultImplementation(predicate, pageable);
    }
}
