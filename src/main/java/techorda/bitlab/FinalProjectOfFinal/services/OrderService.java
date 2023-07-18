package techorda.bitlab.FinalProjectOfFinal.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import techorda.bitlab.FinalProjectOfFinal.Mapper.OrderMapper;
import techorda.bitlab.FinalProjectOfFinal.Mapper.ProductMapper;
import techorda.bitlab.FinalProjectOfFinal.Mapper.UserMapper;
import techorda.bitlab.FinalProjectOfFinal.dto.OrderDTO;
import techorda.bitlab.FinalProjectOfFinal.dto.ProductDTO;
import techorda.bitlab.FinalProjectOfFinal.model.Order;
import techorda.bitlab.FinalProjectOfFinal.model.Product;
import techorda.bitlab.FinalProjectOfFinal.model.User;
import techorda.bitlab.FinalProjectOfFinal.repository.OrderRepository;
import techorda.bitlab.FinalProjectOfFinal.repository.ProductRepository;
import techorda.bitlab.FinalProjectOfFinal.repository.UserRepository;

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

    public void addToCart(Long user_id, Long product_id) {
        User user = userRepository.findById(user_id).orElseThrow();
        Product product = productRepository.findById(product_id).orElseThrow();
        user.getProducts().add(product);
        userRepository.save(user);
    }

    public List<ProductDTO> getAllUserProducts(Long user_id) {
        User user = userRepository.findById(user_id).orElseThrow();
        return productMapper.toDtoList(user.getProducts());
    }

    public ProductDTO deleteFromBasket(Long user_id, Long product_id) {
        User user = userRepository.findById(user_id).orElseThrow();
        Product product = productRepository.findById(product_id).orElseThrow();

        user.getProducts().remove(product);
        userRepository.save(user);
        return productMapper.toDto(product);
    }

    public OrderDTO orderAllUserProducts(Long user_id) {
        User user = userRepository.findById(user_id).orElse(null);
        List<Product> products = new ArrayList<>(user.getProducts());
        user.getProducts().clear();

        Order order = new Order();
        order.setUser(user);
        order.setProducts(products);
        order.setDate(LocalDateTime.now());

        orderRepository.save(order);
        userRepository.save(user);

        return orderMapper.toDTO(order);

    }

    public List<OrderDTO> getAllOrders() {
        return orderMapper.toDtoList(orderRepository.findAllByOrderByStatus());
    }

    public List<OrderDTO> getAllUserOrders(Long user_id) {
        return orderMapper.toDtoList(orderRepository.findByUserId(user_id));
    }

    public OrderDTO getOrderById(Long orderId) {
        return orderMapper.toDTO(orderRepository.findById(orderId).orElseThrow());
    }


    public List<ProductDTO> getAllOrderProducts(Long order_id) {
        Order order = orderRepository.findById(order_id).orElseThrow();
        return productMapper.toDtoList(order.getProducts());
    }

    public OrderDTO handleOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.setStatus(1);
        return orderMapper.toDTO(orderRepository.save(order));
    }

}
