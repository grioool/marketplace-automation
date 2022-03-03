package by.sam_solutions.grigorieva.olga.backend.repository.supply;

import by.sam_solutions.grigorieva.olga.backend.config.HibernateConfiguration;
import by.sam_solutions.grigorieva.olga.backend.entity.*;
import by.sam_solutions.grigorieva.olga.backend.entity.country.Country;
import by.sam_solutions.grigorieva.olga.backend.entity.country.CountryName;
import by.sam_solutions.grigorieva.olga.backend.entity.town.Town;
import by.sam_solutions.grigorieva.olga.backend.entity.town.TownName;
import by.sam_solutions.grigorieva.olga.backend.repository.country.CountryRepository;
import by.sam_solutions.grigorieva.olga.backend.repository.purchase.PurchaseRepository;
import by.sam_solutions.grigorieva.olga.backend.repository.storage.StorageRepository;
import by.sam_solutions.grigorieva.olga.backend.repository.town.TownRepository;
import by.sam_solutions.grigorieva.olga.backend.repository.user.UserRepository;
import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {HibernateConfiguration.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
public class SupplyRepositoryTest extends TestCase {

    @Autowired
    private SupplyRepository supplyRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private TownRepository townRepository;

    private final String username = "testName";
    private final String email = "test@gmail.com";
    private final String testToken = "testToken";

    private static Purchase p;
    private static Town t;
    private static Country c;
    private static Storage s;
    private static Supply su;

    @Test
    @Rollback(value = false)
    public void test_1_createTest() {

        User user = new User();
        user.setPassword("");
        user.setUsername(username);
        user.setEmail(email);
        user.setNameCompany("");
        user.setWildBerriesKeys("");
        user.setRoles(List.of());
        user.setPassword("");
        user.setIsBlocked(false);
        user.setIsSubscribed(false);
        user.setResetPasswordToken(testToken);
        userRepository.create(user);

        Purchase purchase = new Purchase();
        purchase.setPurchasePrice(0);
        purchase.setLogistics(0.0);
        purchase.setDate(Timestamp.from(Instant.now()));
        purchase.setExtra(0.0);
        purchase.setAmount(0);
        purchase.setProductName("");
        purchase.setBatchPrice(0.0);
        purchase.setPriceForOne(0.0);
        purchase.setCostPrice(0.0);
        purchase.setUser(user);

        purchaseRepository.create(purchase);
        p = purchase;

        Country country = new Country();
        country.setCountryName(CountryName.BELARUS);

        countryRepository.create(country);

        c = country;

        Town town = new Town();
        town.setTownName(TownName.MINSK);
        townRepository.create(town);

        t = town;

        Storage storage = new Storage();
        storage.setTown(town);
        storage.setCountry(country);

        storageRepository.create(storage);

        s = storage;

        SupplyProduct supplyProduct = new SupplyProduct();
        supplyProduct.setProduct("");
        supplyProduct.setAmount(0);

        Set<SupplyProduct> supplyProducts = new HashSet<>();
        supplyProducts.add(supplyProduct);

        Supply supply = new Supply();
        supply.setStorage(storage);
        supply.setFulfillment(0.0);
        supply.setWildberriesId(12);
        supply.setPurchase(purchase);
        supply.setSupplyProducts(supplyProducts);
        supply.setCostPrice(0.0);
        supply.setLogistics(0.0);
        supply.setUser(user);
        supply.setDate(Timestamp.from(Instant.now()));
        supply.setPurchasePrice(0.0);

        supply.addSupplyProducts(supplyProducts);

        supplyRepository.create(supply);

        su = supply;

        Assertions.assertThat(user.getId()).isGreaterThan(0);
    }

    @Test
    public void test_2_getTest(){

        Supply supply = supplyRepository.getById(su.getId());

        Assertions.assertThat(supply.getId()).isEqualTo(su.getId());
    }

    @Test
    public void test_3_getAllTest(){

        List<Supply> supplies = supplyRepository.getAll();

        Assertions.assertThat(supplies.size()).isGreaterThan(0);

    }

    @Test
    @Rollback(value = false)
    public void test_4_updateTest(){

        Supply supply = supplyRepository.getById(su.getId());

        supply.setPurchasePrice(1.5);

        Supply supplyUpdated =  supplyRepository.update(supply);

        Assertions.assertThat(supplyUpdated.getPurchasePrice()).isEqualTo(1.5);

    }

    @Test
    public void test_5_getByUser() {
        User user = userRepository.findByUsername(username);

        List<Supply> supplies = supplyRepository.getByUser(user);

        Assertions.assertThat(supplies.size()).isGreaterThan(0);

    }

    @Test
    @Rollback(value = false)
    public void test_6_deleteTest(){
        supplyRepository.delete(su.getId());
        purchaseRepository.delete(p.getId());
        storageRepository.delete(s.getId());
        townRepository.delete(t.getId());
        countryRepository.delete(c.getId());

        User user = userRepository.findByUsername(username);
        userRepository.delete(user.getId());
        Assertions.assertThat(supplyRepository.getById(su.getId())).isNull();
    }
}