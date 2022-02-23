package by.sam_solutions.grigorieva.olga.backend.repository.storage;

import by.sam_solutions.grigorieva.olga.backend.config.HibernateConfiguration;
import by.sam_solutions.grigorieva.olga.backend.entity.Storage;
import by.sam_solutions.grigorieva.olga.backend.entity.country.Country;
import by.sam_solutions.grigorieva.olga.backend.entity.country.CountryName;
import by.sam_solutions.grigorieva.olga.backend.entity.town.Town;
import by.sam_solutions.grigorieva.olga.backend.entity.town.TownName;
import by.sam_solutions.grigorieva.olga.backend.repository.country.CountryRepository;
import by.sam_solutions.grigorieva.olga.backend.repository.town.TownRepository;
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

import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {HibernateConfiguration.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
public class StorageRepositoryTest extends TestCase {

    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private TownRepository townRepository;

    @Test
    @Rollback(value = false)
    public void test_1_createTest(){

        Country country = new Country();
        country.setCountryName(CountryName.BELARUS);

        countryRepository.create(country);

        Town town = new Town();
        town.setTownName(TownName.MINSK);

        townRepository.create(town);

        Storage storage = new Storage();
        storage.setTown(town);
        storage.setCountry(country);

        storageRepository.create(storage);

        Assertions.assertThat(storage.getId()).isGreaterThan(0);
    }

    @Test
    public void test_2_getTest(){

        Storage storage = storageRepository.getById(1);

        Assertions.assertThat(storage.getId()).isEqualTo(1);
    }

    @Test
    public void test_3_getAllTest(){

        List<Storage> storages = storageRepository.getAll();

        Assertions.assertThat(storages.size()).isGreaterThan(0);

    }

    @Test
    @Rollback(value = false)
    public void test_4_updateTest(){

        Storage storage = storageRepository.getById(1);

        Country country = new Country();
        country.setCountryName(CountryName.RUSSIA);

        countryRepository.create(country);

        storage.setCountry(country);

        Storage storageUpdated =  storageRepository.update(storage);

        Assertions.assertThat(storageUpdated.getCountry().getCountryName()).isEqualTo(CountryName.RUSSIA);

    }

    @Test
    @Rollback(value = false)
    public void test_5_deleteTest(){

        Storage storage = storageRepository.getById(1);

        storageRepository.delete(storage.getId());

        Storage storage1 = null;

        Optional<Storage> optionalStorage = Optional.ofNullable(storageRepository.getById(1));

        if(optionalStorage.isPresent()){
            storage1 = optionalStorage.get();
        }

        Assertions.assertThat(storage1).isNull();
    }

}