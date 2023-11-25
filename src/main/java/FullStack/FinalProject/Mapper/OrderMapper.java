package FullStack.FinalProject.Mapper;

import FullStack.FinalProject.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import FullStack.FinalProject.dto.OrderDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(source = "user", target = "userDTO")
    OrderDTO toDTO(Order order);

    @Mapping(source = "userDTO", target = "user")
    Order toModel(OrderDTO orderDTO);

    List<OrderDTO> toDtoList(List<Order> orders);
}
