package by.sam_solutions.grigorieva.olga.backend.service.supply;

import by.sam_solutions.grigorieva.olga.backend.entity.Supply;
import by.sam_solutions.grigorieva.olga.backend.repository.AbstractRepository;
import by.sam_solutions.grigorieva.olga.backend.service.AbstractServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplyServiceImpl extends AbstractServiceImpl<Supply> implements SupplyService {
}
