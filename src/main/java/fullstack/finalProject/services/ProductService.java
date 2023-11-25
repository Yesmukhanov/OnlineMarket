package fullstack.finalProject.services;

import fullstack.finalProject.Mapper.ProductMapper;
import fullstack.finalProject.dto.ProductDTO;
import fullstack.finalProject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductDTO addProduct(ProductDTO productDTO) {
        return productMapper.toDto(productRepository.save(productMapper.toModel(productDTO)));
    }

    public List<ProductDTO> getAllProducts(Long id) {
        return productMapper.toDtoList(productRepository.findByCategory_Id(id));
    }

    public ProductDTO getProduct(Long id) {
        return productMapper.toDto(productRepository.findById(id).orElseThrow());
    }

    public ProductDTO updateProduct(ProductDTO productDTO) {
        return productMapper.toDto(productRepository.save(productMapper.toModel(productDTO)));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
