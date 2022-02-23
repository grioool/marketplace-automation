//package by.sam_solutions.grigorieva.olga.backend.repository.role;
//
//import by.sam_solutions.grigorieva.olga.backend.config.HibernateConfiguration;
//import by.sam_solutions.grigorieva.olga.backend.entity.Role;
//import by.sam_solutions.grigorieva.olga.backend.entity.country.Country;
//import by.sam_solutions.grigorieva.olga.backend.entity.country.CountryName;
//import by.sam_solutions.grigorieva.olga.backend.repository.country.CountryRepository;
//import junit.framework.TestCase;
//import org.assertj.core.api.Assertions;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = {HibernateConfiguration.class})
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@Transactional
//public class RoleRepositoryTest extends TestCase {
//
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Test
//    @Rollback(value = false)
//    public void test_1_createTest(){
//
//        Role role = new Role();
//        role.setRoleName("TEST");
//
//        countryRepository.create(country);
//
//        Assertions.assertThat(country.getId()).isGreaterThan(0);
//    }
//
//    @Test
//    public void test_2_getTest(){
//
//        Country country = countryRepository.getById(1);
//
//        Assertions.assertThat(country.getId()).isEqualTo(1);
//    }
//
//    @Test
//    public void test_3_getAllTest(){
//
//        List<Country> countries = countryRepository.getAll();
//
//        Assertions.assertThat(countries.size()).isGreaterThan(0);
//
//    }
//
//    @Test
//    @Rollback(value = false)
//    public void test_4_updateTest(){
//
//        Country country = countryRepository.getById(1);
//
//        country.setCountryName(CountryName.RUSSIA);
//
//        Country countryUpdated =  countryRepository.update(country);
//
//        Assertions.assertThat(countryUpdated.getCountryName()).isEqualTo(CountryName.RUSSIA);
//
//    }
//
//    @Test
//    @Rollback(value = false)
//    public void test_5_deleteTest(){
//
//        Country country = countryRepository.getById(1);
//
//        countryRepository.delete(country.getId());
//
//        Country country1 = null;
//
//        Optional<Country> optionalCountry = Optional.ofNullable(countryRepository.getById(1));
//
//        if(optionalCountry.isPresent()){
//            country1 = optionalCountry.get();
//        }
//
//        Assertions.assertThat(country1).isNull();
//    }
//}