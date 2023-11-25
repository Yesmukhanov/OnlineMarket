package fullstack.finalProject.dto;

import fullstack.finalProject.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private double price;
    private Category category;

}
