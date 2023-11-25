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

    public UserDTO getUser(Long id) {
        return userMapper.toDTO(userRepository.findById(id).orElseThrow());
    }

    public User getDefaultUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public UserDTO updateUser(UserDTO user) {
        User user1 = getDefaultUser(user.getId());
        User response = new User();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setFullName(user.getFullName());
        response.setStatus(user.isStatus());
        response.setPassword(user1.getPassword());
        response.setRoleId(user.getRoleId());
        Permission permission = permissionRepository.findById(Long.valueOf(user.getRoleId())).orElseThrow();
        List<Permission> permissions = new ArrayList<>();
        permissions.add(permission);
        response.setPermissions(permissions);
        return userMapper.toDTO(userRepository.save(response));
    }

    public void deleteUser(Long id) {
        orderRepository.deleteByUserId(id);
        userRepository.deleteById(id);

    }

    public UserDTO addUser(UserDTO userDTO) {
        return userMapper.toDTO(userMapper.toModel(userDTO));
    }

}
