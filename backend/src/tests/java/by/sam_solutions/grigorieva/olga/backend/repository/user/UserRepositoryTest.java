package by.sam_solutions.grigorieva.olga.backend.repository.user;

import by.sam_solutions.grigorieva.olga.backend.config.HibernateConfiguration;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {HibernateConfiguration.class})
@Transactional
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void createUserTest(){

        User user = new User();
        user.setPassword("");
        user.setUsername("test");
        user.setEmail("test@gmail.com");
        user.setNameCompany("");
        user.setWildBerriesKeys("");

        user.setRoles(List.of());
        user.setPassword("");

        user.setIsBlocked(false);
        user.setIsSubscribed(false);
        user.setResetPasswordToken("testToken");

        userRepository.create(user);

        Assertions.assertThat(user.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getUserTest(){

        User user = userRepository.getById(1);

        Assertions.assertThat(user.getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void getAllUsersTest(){

        List<User> users = userRepository.getAll();

        Assertions.assertThat(users.size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateUserTest(){

        User user = userRepository.getById(1);

        user.setEmail("new@gmail.com");

        User userUpdated =  userRepository.create(user);

        Assertions.assertThat(userUpdated.getEmail()).isEqualTo("new@gmail.com");

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteUserTest(){

        User user = userRepository.findByUsername("test");

        userRepository.delete(user.getId());

        User user1 = null;

        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByEmail("test@gmail.com"));

        if(optionalUser.isPresent()){
            user1 = optionalUser.get();
        }

        Assertions.assertThat(user1).isNull();
    }

    @Test
    @Order(6)
    @Rollback(value = false)
    public void findByUsernameTest() {

        String username = "test";

        User user = userRepository.findByUsername(username);

        Assertions.assertThat(user.getUsername()).isEqualTo(username);
    }

    @Test
    @Order(7)
    @Rollback(value = false)
    public void findByEmailTest() {

        String email = "test@gmail.com";

        User user = userRepository.findByEmail(email);

        Assertions.assertThat(user.getEmail()).isEqualTo(email);

    }

    @Test
    @Order(8)
    @Rollback(value = false)
    public void findByResetPasswordTokenTest() {

        String token = "testToken";

        User user = userRepository.findByResetPasswordToken(token);

        Assertions.assertThat(user.getResetPasswordToken()).isEqualTo(token);
    }
}