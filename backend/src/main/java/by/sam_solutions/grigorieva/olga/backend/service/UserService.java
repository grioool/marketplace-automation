package by.sam_solutions.grigorieva.olga.backend.service;

import by.sam_solutions.grigorieva.olga.backend.dao.RoleDao;
import by.sam_solutions.grigorieva.olga.backend.dao.UserDao;
import by.sam_solutions.grigorieva.olga.backend.entity.Role;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final RoleDao roleDao;

    private final UserDao userDao;

    @Transactional
    public void test() {
        Role admin = new Role();
        admin.setRoleName("Admin");
        roleDao.save(admin);

        User user = new User();
        user.setEmail("");
        user.setPassword("");
        user.setName("");
        user.setOzonKey("");
        user.setRole(admin);
        user.setIsBlocked(false);
        user.setIsSubscribed(false);
        user.setWildBerriesKeys("asd");
      // userDao.save(user);
    }
}
