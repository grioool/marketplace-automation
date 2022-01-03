package by.sam_solutions.grigorieva.olga.backend.service.report;

import by.sam_solutions.grigorieva.olga.backend.entity.Report;
import by.sam_solutions.grigorieva.olga.backend.repository.AbstractRepository;
import by.sam_solutions.grigorieva.olga.backend.service.AbstractServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl extends AbstractServiceImpl<Report> implements ReportService {
}
