package FullStack.FinalProject.dto;

import FullStack.FinalProject.model.Category;
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
