package fullstack.finalProject.services;

import fullstack.finalProject.Mapper.OrderMapper;
import fullstack.finalProject.Mapper.ProductMapper;
import fullstack.finalProject.Mapper.UserMapper;
import fullstack.finalProject.dto.OrderDTO;
import fullstack.finalProject.dto.ProductDTO;
import fullstack.finalProject.model.Order;
import fullstack.finalProject.model.Product;
import fullstack.finalProject.model.User;
import fullstack.finalProject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import fullstack.finalProject.repository.OrderRepository;
import fullstack.finalProject.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final UserMapper userMapper;

    public void addToCart(final Long user_id, final Long product_id) {
        final User user = userRepository.findById(user_id).orElseThrow();
        final Product product = productRepository.findById(product_id).orElseThrow();
        user.getProducts().add(product);
        userRepository.save(user);
    }

    public List<ProductDTO> getAllUserProducts(final Long user_id) {
        final User user = userRepository.findById(user_id).orElseThrow();

        return productMapper.toDtoList(user.getProducts());
    }

    public ProductDTO deleteFromBasket(final Long user_id, final Long product_id) {
        final User user = userRepository.findById(user_id).orElseThrow();
        final Product product = productRepository.findById(product_id).orElseThrow();

        user.getProducts().remove(product);
        userRepository.save(user);

        return productMapper.toDto(product);
    }

    public OrderDTO orderAllUserProducts(final Long user_id) {
        User user = userRepository.findById(user_id).orElse(null);
        List<Product> products = new ArrayList<>(user.getProducts());
        user.getProducts().clear();

        final Order order = Order.builder()
                                 .user(user)
                                 .products(products)
                                 .date(LocalDateTime.now())
                                 .build();

        orderRepository.save(order);
        userRepository.save(user);

        return orderMapper.toDTO(order);

    }

    public List<OrderDTO> getAllOrders() {
        return orderMapper.toDtoList(orderRepository.findAllByOrderByStatus());
    }

    public List<OrderDTO> getAllUserOrders(final Long user_id) {
        return orderMapper.toDtoList(orderRepository.findByUserId(user_id));
    }

    public OrderDTO getOrderById(final Long orderId) {
        return orderMapper.toDTO(orderRepository.findById(orderId).orElseThrow());
    }


    public List<ProductDTO> getAllOrderProducts(final Long order_id) {
        final Order order = orderRepository.findById(order_id).orElseThrow();

        return productMapper.toDtoList(order.getProducts());
    }

    public OrderDTO handleOrder(final Long orderId) {
        final Order order = orderRepository.findById(orderId).orElseThrow();
        order.setStatus(1);

        return orderMapper.toDTO(orderRepository.save(order));
    }

}
