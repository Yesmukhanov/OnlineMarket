package fullstack.finalProject.services;

import fullstack.finalProject.Mapper.UserMapper;
import fullstack.finalProject.dto.UserDTO;
import fullstack.finalProject.model.Permission;
import fullstack.finalProject.model.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import fullstack.finalProject.repository.OrderRepository;
import fullstack.finalProject.repository.PermissionRepository;
import fullstack.finalProject.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PermissionRepository permissionRepository;
    private final OrderRepository orderRepository;

    public List<UserDTO> getAllUsers() {
        return this.userMapper.toDtoList(userRepository.findAll());
    }

    public UserDTO getUser(final Long id) {
        return userMapper.toDTO(userRepository.findById(id).orElseThrow());
    }

    public User getDefaultUser(final Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public UserDTO updateUser(final UserDTO user) {
        final User user1 = getDefaultUser(user.getId());
        final User response = new User();
        final Permission permission = permissionRepository.findById(Long.valueOf(user.getRoleId())).orElseThrow();
        final List<Permission> permissions = new ArrayList<>();

        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setFullName(user.getFullName());
        response.setStatus(user.isStatus());
        response.setPassword(user1.getPassword());
        response.setRoleId(user.getRoleId());

        permissions.add(permission);
        response.setPermissions(permissions);

        return userMapper.toDTO(userRepository.save(response));
    }

    public void deleteUser(final Long id) {
        orderRepository.deleteByUserId(id);
        userRepository.deleteById(id);

    }

    public UserDTO addUser(final UserDTO userDTO) {
        return userMapper.toDTO(userMapper.toModel(userDTO));
    }

}
