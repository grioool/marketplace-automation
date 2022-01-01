package by.sam_solutions.grigorieva.olga.backend.service.purchase;

import by.sam_solutions.grigorieva.olga.backend.entity.Purchase;
import by.sam_solutions.grigorieva.olga.backend.repository.AbstractRepository;
import by.sam_solutions.grigorieva.olga.backend.service.AbstractServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor TODO
public class PurchaseServiceImpl extends AbstractServiceImpl<Purchase> implements PurchaseService {

    public PurchaseServiceImpl(AbstractRepository<Purchase> abstractRepository) {
        super(abstractRepository);
    }
}
