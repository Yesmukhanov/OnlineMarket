package FullStack.FinalProject.services;

import FullStack.FinalProject.model.Permission;
import FullStack.FinalProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import FullStack.FinalProject.repository.PermissionRepository;
import FullStack.FinalProject.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private PermissionRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user != null && !user.isStatus()) {
            return user;
        } else {
            throw new UsernameNotFoundException("User Not Found");
        }
    }

    public User addUser(User user) {
        User checkUser = userRepository.findByEmail(user.getEmail());
        Permission permission = repository.findById(2L).orElse(null);
        List<Permission> permissions = new ArrayList<>();
        permissions.add(permission);

        if (checkUser == null) {
            user.setPermissions(permissions);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoleId(2);
            return userRepository.save(user);
        }
        return null;
    }


    public User getCurrentSession() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return (User) (authentication.getPrincipal());
        }

        return null;
    }

    public User changePassword(String oldPassword, String newPassword) {

        User currentUser = getCurrentSession();

        if (passwordEncoder.matches(oldPassword, currentUser.getPassword())) {
            currentUser.setPassword(passwordEncoder.encode(newPassword));
            return userRepository.save(currentUser);
        }

        return null;
    }

}
