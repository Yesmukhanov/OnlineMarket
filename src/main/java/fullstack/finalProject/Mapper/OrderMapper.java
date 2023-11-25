package fullstack.finalProject.Mapper;

import fullstack.finalProject.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import fullstack.finalProject.dto.OrderDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(source = "user", target = "userDTO")
    OrderDTO toDTO(Order order);

    @Mapping(source = "userDTO", target = "user")
    Order toModel(OrderDTO orderDTO);

    List<OrderDTO> toDtoList(List<Order> orders);
}
