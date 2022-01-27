package by.sam_solutions.grigorieva.olga.backend.service.wb;

import by.sam_solutions.grigorieva.olga.backend.dto.ReportWBDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ReportsWBService extends WBService<ReportWBDto> {

    public ReportsWBService(@Value("${url.reports}") String url) {
        super(url);
    }

}
