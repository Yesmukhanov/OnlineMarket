package FullStack.FinalProject.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import FullStack.FinalProject.dto.ProductDTO;
import FullStack.FinalProject.services.ProductService;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductService productService;

    /**
     * GET запрос для получения списка всех продуктов по указанному идентификатору.
     *
     * @param id Идентификатор, по которому нужно получить список продуктов.
     * @return Список объектов ProductDTO, представляющих собой данные всех продуктов с указанным идентификатором.
     */
    @GetMapping(value = "{id}")
    public List<ProductDTO> getAllProducts(@PathVariable final Long id) {
        return productService.getAllProducts(id);
    }

    /**
     * GET запроса для получения информации о продукте по указанному идентификатору.
     *
     * @param id Идентификатор продукта.
     * @return Объект ProductDTO, представляющий собой данные продукта с указанным идентификатором.
     */
    @GetMapping
    @RequestMapping(value = "/getOne/{id}")
    public ProductDTO getProduct(@PathVariable(name = "id") final Long id) {
        return productService.getProduct(id);
    }

    /**
     * POST запрос для добавления нового продукта.
     *
     * @param productDTO Объект ProductDTO, содержащий информацию о новом продукте.
     * @return Объект ProductDTO, представляющий собой данные добавленного продукта.
     */
    @PostMapping
    public ProductDTO addProduct(@RequestBody final ProductDTO productDTO) {
        return productService.addProduct(productDTO);
    }

    /**
     * PUT запрос для обновления информации о продукте.
     *
     * @param productDTO Объект ProductDTO, содержащий обновленные данные продукта.
     * @return Объект ProductDTO, представляющий собой обновленные данные продукта.
     */
    @PutMapping
    public ProductDTO updateProduct(@RequestBody final ProductDTO productDTO) {
        return productService.updateProduct(productDTO);
    }

    /**
     * DELETE запрос для удаления продукта по указанному идентификатору.
     *
     * @param id Идентификатор продукта, который требуется удалить.
     */
    @DeleteMapping(value = "{id}")
    public void deleteProduct(@PathVariable(name = "id") final Long id) {
        productService.deleteProduct(id);
    }
}
