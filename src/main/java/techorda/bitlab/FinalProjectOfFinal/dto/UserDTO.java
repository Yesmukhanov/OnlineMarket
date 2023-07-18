package techorda.bitlab.FinalProjectOfFinal.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {

    private Long id;
    private String email;
    private String fullName;
    private boolean status;
    private int roleId;
    private List<ProductDTO> products;
}
