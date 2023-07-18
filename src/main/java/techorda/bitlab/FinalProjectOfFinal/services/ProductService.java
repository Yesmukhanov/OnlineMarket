package techorda.bitlab.FinalProjectOfFinal.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import techorda.bitlab.FinalProjectOfFinal.Mapper.ProductMapper;
import techorda.bitlab.FinalProjectOfFinal.dto.ProductDTO;
import techorda.bitlab.FinalProjectOfFinal.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductDTO addProduct(ProductDTO productDTO){
        return productMapper.toDto(productRepository.save(productMapper.toModel(productDTO)));
    }

    public List<ProductDTO> getAllProducts(Long id){
        return productMapper.toDtoList(productRepository.findByCategory_Id(id));
    }

    public ProductDTO getProduct(Long id){
        return productMapper.toDto(productRepository.findById(id).orElseThrow());
    }

    public ProductDTO updateProduct(ProductDTO productDTO){
        return productMapper.toDto(productRepository.save(productMapper.toModel(productDTO)));
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

}
