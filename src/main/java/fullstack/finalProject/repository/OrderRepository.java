package fullstack.finalProject.repository;

import fullstack.finalProject.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByOrderByStatus();

    List<Order> findByUserId(Long userId);

    void deleteByUserId(Long userId);
}
