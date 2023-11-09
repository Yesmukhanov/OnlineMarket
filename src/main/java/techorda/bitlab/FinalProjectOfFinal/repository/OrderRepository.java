package techorda.bitlab.FinalProjectOfFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import techorda.bitlab.FinalProjectOfFinal.model.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByOrderByStatus();

    List<Order> findByUserId(Long userId);

    void deleteByUserId(Long userId);
}
