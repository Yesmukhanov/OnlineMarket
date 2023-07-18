package techorda.bitlab.FinalProjectOfFinal.dto;

import lombok.Getter;
import lombok.Setter;
import techorda.bitlab.FinalProjectOfFinal.model.Category;

@Getter
@Setter
public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private double price;
    private Category category;

}
