package techorda.bitlab.FinalProjectOfFinal.Mapper;

import org.mapstruct.Mapper;
import techorda.bitlab.FinalProjectOfFinal.dto.ProductDTO;
import techorda.bitlab.FinalProjectOfFinal.model.Product;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDto(Product product);

    Product toModel(ProductDTO productDTO);

    List<ProductDTO> toDtoList(List<Product> list);
}
