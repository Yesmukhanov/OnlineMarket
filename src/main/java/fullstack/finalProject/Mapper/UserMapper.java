package fullstack.finalProject.Mapper;

import fullstack.finalProject.dto.UserDTO;
import fullstack.finalProject.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "id")
    UserDTO toDTO(User user);

    User toModel(UserDTO userDTO);

    List<UserDTO> toDtoList(List<User> users);

    List<User> toModelList(List<UserDTO> userDTOS);
}
