package FullStack.FinalProject.services;

import FullStack.FinalProject.Mapper.ProductMapper;
import FullStack.FinalProject.dto.ProductDTO;
import FullStack.FinalProject.repository.ProductRepository;
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
