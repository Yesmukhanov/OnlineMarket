package FullStack.FinalProject.Mapper;

import FullStack.FinalProject.dto.UserDTO;
import FullStack.FinalProject.model.User;
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
