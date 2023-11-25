package fullstack.finalProject.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import fullstack.finalProject.dto.OrderDTO;
import fullstack.finalProject.dto.ProductDTO;
import fullstack.finalProject.services.OrderService;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderService orderService;

    /**
     * PUT запрос для добавления продукта в заказ пользователя.
     *
     * @param user_id     Идентификатор пользователя, к которому добавляется продукт в заказ.
     * @param product_id  Идентификатор продукта, который добавляется в заказ.
     */
    @PutMapping(value = "/{user_id}/{product_id}")
    public void addToProductToOrder(
        @PathVariable(name = "user_id") final Long user_id,
        @PathVariable(name = "product_id") final Long product_id
    ) {
        orderService.addToCart(user_id, product_id);
    }

    /**
     * GET запрос для получения списка всех продуктов пользователя в заказе.
     *
     * @param user_id Идентификатор пользователя, чьи продукты в заказе нужно получить.
     * @return Список объектов ProductDTO, представляющих собой данные всех продуктов в заказе пользователя.
     */
    @GetMapping(value = "{id}")
    public List<ProductDTO> getAllUserProducts(
        @PathVariable(name = "id") final Long user_id
    ) {
        return orderService.getAllUserProducts(user_id);
    }

    /**
     * DELETE запрос для удаления продукта из корзины пользователя.
     *
     * @param user_id     Идентификатор пользователя, у которого удаляется продукт из корзины.
     * @param product_id  Идентификатор продукта, который удаляется из корзины.
     * @return Объект ProductDTO, представляющий собой удаленный продукт из корзины пользователя.
     */
    @DeleteMapping(value = "/{user_id}/{product_id}")
    public ProductDTO deleteFromBasket(
        @PathVariable(name = "user_id") final Long user_id,
        @PathVariable(name = "product_id") final Long product_id
    ) {
        return orderService.deleteFromBasket(user_id, product_id);
    }

    /**
     * POST запрос для размещения заказа на все продукты пользователя.
     *
     * @param user_id Идентификатор пользователя, чьи продукты будут включены в заказ.
     * @return Объект OrderDTO, представляющий собой информацию о размещенном заказе.
     */
    @PostMapping(value = "{userId}")
    public OrderDTO orderAllUserProducts(@PathVariable(name = "userId") final Long user_id) {
        return orderService.orderAllUserProducts(user_id);
    }

    /**
     * GET запрос для получения списка всех заказов.
     *
     * @return Список объектов OrderDTO, представляющих собой данные всех заказов.
     */
    @GetMapping(value = "/orders")
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    /**
     * GET запрос для получения информации о заказе по указанному идентификатору.
     *
     * @param orderId Идентификатор заказа.
     * @return Объект OrderDTO, представляющий собой данные заказа с указанным идентификатором.
     */
    @GetMapping(value = "/getOne/{orderId}")
    public OrderDTO getOrderById(@PathVariable(name = "orderId") final Long orderId) {
        return orderService.getOrderById(orderId);
    }

    /**
     * GET запрос для получения списка всех продуктов в заказе по указанному идентификатору заказа.
     *
     * @param orderId Идентификатор заказа, чьи продукты нужно получить.
     * @return Список объектов ProductDTO, представляющих собой данные всех продуктов в указанном заказе.
     */
    @GetMapping(value = "/products/{orderId}")
    public List<ProductDTO> getAllOrderProducts(@PathVariable(name = "orderId") final Long orderId) {
        return orderService.getAllOrderProducts(orderId);
    }

    /**
     * PUT запрос для обработки заказа по указанному идентификатору заказа.
     *
     * @param orderId Идентификатор заказа, который требуется обработать.
     * @return Объект OrderDTO, представляющий собой обработанный заказ с указанным идентификатором.
     */
    @PutMapping(value = "{orderId}")
    public OrderDTO handleOrder(@PathVariable(name = "orderId") final Long orderId) {
        return orderService.handleOrder(orderId);
    }

    /**
     * GET запрос для получения списка всех заказов пользователя по указанному идентификатору пользователя.
     *
     * @param userId Идентификатор пользователя, чьи заказы нужно получить.
     * @return Список объектов OrderDTO, представляющих собой данные всех заказов пользователя.
     */
    @GetMapping(value = "/getUserOrders/{userId}")
    public List<OrderDTO> userOrders(@PathVariable(name = "userId") final Long userId) {
        return orderService.getAllUserOrders(userId);
    }
}
