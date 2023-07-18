package techorda.bitlab.FinalProjectOfFinal.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "t_orders")
@Getter
@Setter
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
