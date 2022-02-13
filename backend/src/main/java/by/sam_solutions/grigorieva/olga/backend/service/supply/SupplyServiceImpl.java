package by.sam_solutions.grigorieva.olga.backend.service.supply;

import by.sam_solutions.grigorieva.olga.backend.domain.table.TablePage;
import by.sam_solutions.grigorieva.olga.backend.dto.SupplyTableRowDto;
import by.sam_solutions.grigorieva.olga.backend.entity.Supply;
import by.sam_solutions.grigorieva.olga.backend.entity.SupplyProduct;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.repository.supply.SupplyRepository;
import by.sam_solutions.grigorieva.olga.backend.service.AbstractServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SupplyServiceImpl extends AbstractServiceImpl<Supply> implements SupplyService {

    private final SupplyRepository supplyRepository;

    @Autowired
    public SupplyServiceImpl(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }

    @Override
    public void addSupplyProduct(SupplyProduct supplyProduct) {
        Supply supply = supplyRepository.getByWildberriesId(supplyProduct.getSupply().getId());
        if (supply == null) {
            create(supplyProduct.getSupply());
            return;
        }

        supply.addSupplyProduct(supplyProduct);
        update(supply);
    }

    @Override
    public List<Supply> getByUser(User user) {
        return supplyRepository.getByUser(user);
    }

    @Override
    public TablePage<SupplyProduct> getSupplyProductsPerPage(User user, int shift, int rowsPerPage) {
        List<Supply> supplies = supplyRepository.getByUser(user);
        return TablePage.slice(
                supplies.stream()
                        .flatMap(supply -> supply.getSupplyProducts().stream())
                        .collect(Collectors.toList()),
                shift,
                rowsPerPage
        );
    }

    @Override
    public Supply getByProduct(String name) {
        return supplyRepository.getByProduct(name);
    }

    @Override
    public Supply getByIdAndProductName(String product, int id) {
        return supplyRepository.getByIdAndProductName(product, id);
    }

    @Override
    public Supply getByWildberriesId(int id) {
        return supplyRepository.getByWildberriesId(id);
    }
}
