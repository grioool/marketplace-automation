package by.sam_solutions.grigorieva.olga.backend.service.user;

import by.sam_solutions.grigorieva.olga.backend.config.jwt.JwtProvider;
import by.sam_solutions.grigorieva.olga.backend.entity.TokenAuthentication;
import by.sam_solutions.grigorieva.olga.backend.entity.Role;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
//import by.sam_solutions.grigorieva.olga.backend.entity.role.RoleName;
import by.sam_solutions.grigorieva.olga.backend.repository.role.RoleRepository;
import by.sam_solutions.grigorieva.olga.backend.repository.user.UserRepository;
import by.sam_solutions.grigorieva.olga.backend.service.AbstractServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl extends AbstractServiceImpl<User> implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtProvider jwtProvider;

    @Override
    public User register(User user) {
        user.setRoles(List.of(roleRepository.findByName("USER")));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.create(user);
    }

    @Override
    public User createUser(User user) {
        // log.info("Saving new user {} to the database", user.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.create(user);
    }

    @Override
    public Role createRole(Role role) {
        //  log.info("Saving new role {} to the database", role.getName());
        return roleRepository.create(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        //  log.info("Adding role {} to user {}", roleName, username);
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            // log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }
        // log.info("User found in the database: {}", username);
        return user;
    }

    @Transactional
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    public TokenAuthentication authenticate(String username, String password) {
        User user = getByUsername(username);
        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return jwtProvider.generateToken(user);
            }
        }
        return null;
    }

}
