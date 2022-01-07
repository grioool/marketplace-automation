package by.sam_solutions.grigorieva.olga.backend.service.user;

import by.sam_solutions.grigorieva.olga.backend.config.jwt.JwtProvider;
import by.sam_solutions.grigorieva.olga.backend.entity.role.Role;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.entity.role.RoleName;
import by.sam_solutions.grigorieva.olga.backend.repository.AbstractRepository;
import by.sam_solutions.grigorieva.olga.backend.repository.role.RoleRepository;
import by.sam_solutions.grigorieva.olga.backend.repository.user.UserRepository;
import by.sam_solutions.grigorieva.olga.backend.service.AbstractServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
@RequiredArgsConstructor
public class UserServiceImpl extends AbstractServiceImpl<User> implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtProvider jwtProvider;

    @Transactional
    public User register(User user) {
        user.setRole(roleRepository.findByName(RoleName.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.create(user);
    }

    @Transactional
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    public String authenticate(String username, String password) {
        User user = getByUsername(username);
        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return jwtProvider.generateToken(user.getUsername());
            }
        }
        return null;
    }
}
