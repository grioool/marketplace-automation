package by.sam_solutions.grigorieva.olga.backend.service.supply;

import by.sam_solutions.grigorieva.olga.backend.domain.table.TablePage;
import by.sam_solutions.grigorieva.olga.backend.entity.Supply;
import by.sam_solutions.grigorieva.olga.backend.entity.SupplyProduct;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.service.AbstractService;

import java.util.List;

public interface SupplyService extends AbstractService<Supply> {

    void addSupplyProduct(SupplyProduct supplyProduct);

    List<Supply> getByUser(User user);

    TablePage<SupplyProduct> getSupplyProductsPerPage(User user, int shift, int rowsPerPage);

    Supply getByProduct(String name);

    Supply getByIdAndProductName(String product, int id);

}
