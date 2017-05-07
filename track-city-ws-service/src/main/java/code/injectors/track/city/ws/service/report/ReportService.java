package code.injectors.track.city.ws.service.report;

import code.injectors.track.city.ws.domain.entity.report.Report;
import code.injectors.track.city.ws.service.PageableCrudService;

/**
 * @author Chrisostomos Bakouras
 */
public interface ReportService extends PageableCrudService<Report> {

    Report changeStatus(String id, String status);
}
