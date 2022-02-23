package by.sam_solutions.grigorieva.olga.backend.repository.town;

import by.sam_solutions.grigorieva.olga.backend.config.HibernateConfiguration;
import by.sam_solutions.grigorieva.olga.backend.entity.town.Town;
import by.sam_solutions.grigorieva.olga.backend.entity.town.TownName;
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
public class TownRepositoryTest extends TestCase {

    @Autowired
    private TownRepository townRepository;

    @Test
    @Rollback(value = false)
    public void test_1_createTest(){

        Town town = new Town();
        town.setTownName(TownName.MINSK);

        townRepository.create(town);

        Assertions.assertThat(town.getId()).isGreaterThan(0);
    }

    @Test
    public void test_2_getUserTest(){

        Town town = townRepository.getById(1);

        Assertions.assertThat(town.getId()).isEqualTo(1);
    }

    @Test
    public void test_3_getAllUsersTest(){

        List<Town> towns = townRepository.getAll();

        Assertions.assertThat(towns.size()).isGreaterThan(0);

    }

    @Test
    @Rollback(value = false)
    public void test_4_updateUserTest(){

        Town town = townRepository.getById(1);

        town.setTownName(TownName.KIEV);

        Town townUpdated =  townRepository.update(town);

        Assertions.assertThat(townUpdated.getTownName()).isEqualTo(TownName.KIEV);

    }

    @Test
    @Rollback(value = false)
    public void test_5_deleteTest(){

        Town town = townRepository.getById(1);

        townRepository.delete(town.getId());

        Town town1 = null;

        Optional<Town> optionalTown = Optional.ofNullable(townRepository.getById(1));

        if(optionalTown.isPresent()){
            town1 = optionalTown.get();
        }

        Assertions.assertThat(town1).isNull();
    }

}