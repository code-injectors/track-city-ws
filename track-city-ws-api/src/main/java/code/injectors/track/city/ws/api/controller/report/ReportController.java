package code.injectors.track.city.ws.api.controller.report;

import code.injectors.track.city.ws.api.controller.PageableController;
import code.injectors.track.city.ws.domain.entity.report.Report;
import code.injectors.track.city.ws.dto.report.ReportDTO;
import code.injectors.track.city.ws.dto.report.ReportLazyDTO;
import org.springframework.http.ResponseEntity;

/**
 * @author Chrisostomos Bakouras
 */
public interface ReportController extends PageableController<Report, ReportDTO, ReportLazyDTO> {

    ResponseEntity<Void> changeStatus(final String id, final String status);
}
