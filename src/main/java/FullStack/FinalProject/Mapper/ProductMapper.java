package FullStack.FinalProject.Mapper;

import org.mapstruct.Mapper;
import FullStack.FinalProject.dto.ProductDTO;
import FullStack.FinalProject.model.Product;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDto(Product product);

    Product toModel(ProductDTO productDTO);

    List<ProductDTO> toDtoList(List<Product> list);
}
