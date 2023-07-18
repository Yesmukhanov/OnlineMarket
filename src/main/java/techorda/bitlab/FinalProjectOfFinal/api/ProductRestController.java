package techorda.bitlab.FinalProjectOfFinal.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import techorda.bitlab.FinalProjectOfFinal.dto.ProductDTO;
import techorda.bitlab.FinalProjectOfFinal.services.ProductService;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductService productService;

    @GetMapping(value = "{id}")
    public List<ProductDTO> getAllProducts(@PathVariable Long id) {
        return productService.getAllProducts(id);
    }

    @GetMapping
    @RequestMapping(value = "/getOne/{id}")
    public ProductDTO getProduct(@PathVariable(name = "id") Long id) {
        return productService.getProduct(id);
    }

    @PostMapping
    public ProductDTO addProduct(@RequestBody ProductDTO productDTO) {
        return productService.addProduct(productDTO);
    }

    @PutMapping
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
        return productService.updateProduct(productDTO);
    }

    @DeleteMapping(value = "{id}")
    public void deleteProduct(@PathVariable(name = "id") Long id) {
        productService.deleteProduct(id);
    }
}
