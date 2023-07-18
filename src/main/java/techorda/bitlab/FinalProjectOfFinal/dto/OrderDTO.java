package techorda.bitlab.FinalProjectOfFinal.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderDTO {
    private Long id;
    private UserDTO userDTO;
    private LocalDateTime date;
    private int status;
    private List<ProductDTO> products;
}
