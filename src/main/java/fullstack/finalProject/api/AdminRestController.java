package fullstack.finalProject.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import fullstack.finalProject.dto.UserDTO;
import fullstack.finalProject.services.AdminService;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
@RequiredArgsConstructor
public class AdminRestController {

    private final AdminService adminService;

    /**
     * GET запрос для получения списка всех пользователей.
     *
     * @return Список объектов UserDTO, представляющих собой данные всех пользователей.
     */
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return adminService.getAllUsers();
    }

    /**
     * GET запрос для получения информации о пользователе по указанному идентификатору.
     *
     * @param id Идентификатор пользователя.
     * @return Объект UserDTO, представляющий собой данные пользователя с указанным идентификатором.
     */
    @GetMapping(value = "{id}")
    public UserDTO getUser(@PathVariable(name = "id") final Long id) {
        return adminService.getUser(id);
    }

    /**
     * POST запрос для добавления нового пользователя.
     *
     * @param user Объект UserDTO, содержащий информацию о новом пользователе.
     * @return Объект UserDTO, представляющий собой данные добавленного пользователя.
     */
    @PostMapping
    public UserDTO addUser(@RequestBody final UserDTO user) {
        return adminService.addUser(user);
    }

    /**
     * PUT запрос для обновления информации о пользователе.
     *
     * @param user Объект UserDTO, содержащий обновленные данные пользователя.
     * @return Объект UserDTO, представляющий собой обновленные данные пользователя.
     */
    @PutMapping
    public UserDTO updateUser(@RequestBody final UserDTO user) {
        return adminService.updateUser(user);
    }

    /**
     * DELETE запрос для удаления пользователя по указанному идентификатору.
     *
     * @param id Идентификатор пользователя, который будет удален.
     */
    @DeleteMapping(value = "{id}")
    public void deleteUser(@PathVariable(name = "id") final Long id) {
        adminService.deleteUser(id);
    }
}
