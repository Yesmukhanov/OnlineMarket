package fullstack.finalProject.Mapper;

import org.mapstruct.Mapper;
import fullstack.finalProject.dto.ProductDTO;
import fullstack.finalProject.model.Product;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDto(Product product);

    Product toModel(ProductDTO productDTO);

    List<ProductDTO> toDtoList(List<Product> list);
}
