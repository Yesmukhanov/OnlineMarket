package techorda.bitlab.FinalProjectOfFinal.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import techorda.bitlab.FinalProjectOfFinal.dto.UserDTO;
import techorda.bitlab.FinalProjectOfFinal.services.AdminService;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
@RequiredArgsConstructor
public class AdminRestController {

    private final AdminService adminService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return adminService.getAllUsers();
    }

    @GetMapping(value = "{id}")
    public UserDTO getUser(@PathVariable(name = "id") Long id) {
        return adminService.getUser(id);
    }

    @PostMapping
    public UserDTO addUser(@RequestBody UserDTO user) {
        return adminService.addUser(user);
    }

    @PutMapping
    public UserDTO updateUser(@RequestBody UserDTO user) {
        return adminService.updateUser(user);
    }

    @DeleteMapping(value = "{id}")
    public void deleteUser(@PathVariable(name = "id") Long id) {
        adminService.deleteUser(id);
    }
}
