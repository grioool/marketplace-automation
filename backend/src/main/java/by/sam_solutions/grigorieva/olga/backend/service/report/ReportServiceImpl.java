package by.sam_solutions.grigorieva.olga.backend.service.report;

import by.sam_solutions.grigorieva.olga.backend.entity.Report;
import by.sam_solutions.grigorieva.olga.backend.repository.AbstractRepository;
import by.sam_solutions.grigorieva.olga.backend.service.AbstractServiceImpl;

//@RequiredArgsConstructor TODO
public class ReportServiceImpl extends AbstractServiceImpl<Report> implements ReportService {

    public ReportServiceImpl(AbstractRepository<Report> abstractRepository) {
        super(abstractRepository);
    }
}
