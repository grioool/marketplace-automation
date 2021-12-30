package by.sam_solutions.grigorieva.olga.backend.service;

import by.sam_solutions.grigorieva.olga.backend.entity.Purchase;
import by.sam_solutions.grigorieva.olga.backend.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PurchaseServiceImpl extends AbstractServiceImpl<Purchase> implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

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
