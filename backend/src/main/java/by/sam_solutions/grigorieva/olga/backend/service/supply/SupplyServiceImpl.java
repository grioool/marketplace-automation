package by.sam_solutions.grigorieva.olga.backend.service.supply;

import by.sam_solutions.grigorieva.olga.backend.entity.Supply;
import by.sam_solutions.grigorieva.olga.backend.repository.AbstractRepository;
import by.sam_solutions.grigorieva.olga.backend.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor TODO
public class SupplyServiceImpl extends AbstractServiceImpl<Supply> implements SupplyService {

    public SupplyServiceImpl(AbstractRepository<Supply> abstractRepository) {
        super(abstractRepository);
    }

}
