package techorda.bitlab.FinalProjectOfFinal.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import techorda.bitlab.FinalProjectOfFinal.Mapper.UserMapper;
import techorda.bitlab.FinalProjectOfFinal.dto.UserDTO;
import techorda.bitlab.FinalProjectOfFinal.model.Permission;
import techorda.bitlab.FinalProjectOfFinal.model.User;
import techorda.bitlab.FinalProjectOfFinal.repository.PermissionRepository;
import techorda.bitlab.FinalProjectOfFinal.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PermissionRepository permissionRepository;

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
        userRepository.deleteById(id);
    }

    public UserDTO addUser(UserDTO userDTO) {
        return userMapper.toDTO(userMapper.toModel(userDTO));
    }

}
