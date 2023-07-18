package techorda.bitlab.FinalProjectOfFinal.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import techorda.bitlab.FinalProjectOfFinal.dto.OrderDTO;
import techorda.bitlab.FinalProjectOfFinal.dto.ProductDTO;
import techorda.bitlab.FinalProjectOfFinal.services.OrderService;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderService orderService;

    @PutMapping(value = "/{user_id}/{product_id}")
    public void addToProductToOrder(@PathVariable(name = "user_id") Long user_id, @PathVariable(name = "product_id")
    Long product_id) {
        orderService.addToCart(user_id, product_id);
    }

    @GetMapping(value = "{id}")
    public List<ProductDTO> getAllUserProducts(@PathVariable(name = "id") Long user_id) {
        return orderService.getAllUserProducts(user_id);
    }

    @DeleteMapping(value = "/{user_id}/{product_id}")
    public ProductDTO deleteFromBasket(@PathVariable(name = "user_id") Long user_id, @PathVariable(name = "product_id")
    Long product_id) {
        return orderService.deleteFromBasket(user_id, product_id);
    }

    @PostMapping(value = "{userId}")
    public OrderDTO orderAllUserProducts(@PathVariable(name = "userId") Long user_id) {
        return orderService.orderAllUserProducts(user_id);
    }

    @GetMapping(value = "/orders")
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping(value = "/getOne/{orderId}")
    public OrderDTO getOrderById(@PathVariable(name = "orderId") Long orderId) {
        return orderService.getOrderById(orderId);
    }


    @GetMapping(value = "/products/{orderId}")
    public List<ProductDTO> getAllOrderProducts(@PathVariable(name = "orderId") Long orderId) {
        return orderService.getAllOrderProducts(orderId);
    }

    @PutMapping(value = "{orderId}")
    public OrderDTO handleOrder(@PathVariable(name = "orderId") Long orderId) {
        return orderService.handleOrder(orderId);
    }

    @GetMapping(value = "/getUserOrders/{userId}")
    public List<OrderDTO> userOrders(@PathVariable(name = "userId") Long userId) {
        return orderService.getAllUserOrders(userId);
    }
}
