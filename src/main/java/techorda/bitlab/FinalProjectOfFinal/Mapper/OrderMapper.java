package techorda.bitlab.FinalProjectOfFinal.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import techorda.bitlab.FinalProjectOfFinal.dto.OrderDTO;
import techorda.bitlab.FinalProjectOfFinal.model.Order;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(source = "user", target = "userDTO")
    OrderDTO toDTO(Order order);

    @Mapping(source = "userDTO", target = "user")
    Order toModel(OrderDTO orderDTO);

    List<OrderDTO> toDtoList(List<Order> orders);
}
