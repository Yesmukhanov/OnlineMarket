package fullstack.finalProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "t_orders")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order extends baseModel {

    @Column(name = "time")
    private LocalDateTime date;

    @ManyToOne
    private User user;

    @Column(name = "status")
    private int status;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Product> products;
}
