package by.sam_solutions.grigorieva.olga.backend.service.supply;

import by.sam_solutions.grigorieva.olga.backend.domain.table.TablePage;
import by.sam_solutions.grigorieva.olga.backend.entity.Supply;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.repository.supply.SupplyRepository;
import by.sam_solutions.grigorieva.olga.backend.service.AbstractServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SupplyServiceImpl extends AbstractServiceImpl<Supply> implements SupplyService {

    private final SupplyRepository supplyRepository;

    @Override
    public List<Supply> getByUser(User user) {
        return supplyRepository.getByUser(user);
    }

    @Override
    public TablePage<Supply> getSuppliesPerPage(User user, int shift, int rowsPerPage) {
        List<Supply> supplies = supplyRepository.getByUser(user);
        return TablePage.slice(supplies, shift, rowsPerPage);
    }

    @Override
    public Supply getByProduct(String name) {
       return supplyRepository.getByProduct(name);
    }
}
