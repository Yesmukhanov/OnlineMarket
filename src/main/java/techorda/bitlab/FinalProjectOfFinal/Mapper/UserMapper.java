package techorda.bitlab.FinalProjectOfFinal.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import techorda.bitlab.FinalProjectOfFinal.dto.UserDTO;
import techorda.bitlab.FinalProjectOfFinal.model.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "id")
    UserDTO toDTO(User user);

    User toModel(UserDTO userDTO);

    List<UserDTO> toDtoList(List<User> users);

    List<User> toModelList(List<UserDTO> userDTOS);
}
