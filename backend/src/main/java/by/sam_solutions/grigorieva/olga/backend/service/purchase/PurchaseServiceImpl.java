package by.sam_solutions.grigorieva.olga.backend.service.purchase;

import by.sam_solutions.grigorieva.olga.backend.entity.Purchase;
import by.sam_solutions.grigorieva.olga.backend.repository.purchase.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;

    public Purchase create(Purchase purchase) { return purchaseRepository.create(purchase); }

    public Purchase update(Purchase purchase) { return purchaseRepository.update(purchase); }

    @Transactional
    public void delete(int id) {
        purchaseRepository.delete(id);
    }

    @Transactional
    public Purchase getById(int id) {
        return purchaseRepository.getById(id);
    }

    public List<Purchase> getAll() {
        return purchaseRepository.getAll();
    }
}
