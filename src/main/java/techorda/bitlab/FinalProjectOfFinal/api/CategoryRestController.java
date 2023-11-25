package techorda.bitlab.FinalProjectOfFinal.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import techorda.bitlab.FinalProjectOfFinal.dto.CategoryDTO;
import techorda.bitlab.FinalProjectOfFinal.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
@RequiredArgsConstructor
public class CategoryRestController {

    private final CategoryService categoryService;

    /**
     * GET запрос для получения списка категорий.
     *
     * @return Список объектов CategoryDTO, представляющих собой данные всех категорий.
     */
    @GetMapping
    public List<CategoryDTO> getCategories() {
        return categoryService.getCategories();
    }

    /**
     * GET запрос для получения информации о категории по указанному идентификатору.
     *
     * @param id Идентификатор категории.
     * @return Объект CategoryDTO, представляющий собой данные категории с указанным идентификатором.
     */
    @GetMapping(value = "{id}")
    public CategoryDTO getCategory(@PathVariable(name = "id") final Long id) {
        return categoryService.getCategory(id);
    }

    /**
     * POST запрос для добавления новой категории.
     *
     * @param category Объект CategoryDTO, содержащий информацию о новой категории.
     * @return Объект CategoryDTO, представляющий собой данные добавленной категории.
     */
    @PostMapping
    public CategoryDTO addCategory(@RequestBody final CategoryDTO category) {
        return categoryService.addCategory(category);
    }

    /**
     * PUT запрос для обновления информации о категории.
     *
     * @param categoryDTO Объект CategoryDTO, содержащий обновленные данные категории.
     * @return Объект CategoryDTO, представляющий собой обновленные данные категории.
     */
    @PutMapping
    public CategoryDTO updateCategory(@RequestBody final CategoryDTO categoryDTO) {
        return categoryService.updateCategory(categoryDTO);
    }

    /**
     * Обработчик HTTP DELETE запроса для удаления категории по указанному идентификатору.
     *
     * @param id Идентификатор категории, которую необходимо удалить.
     */
    @DeleteMapping(value = "{id}")
    public void deleteCategory(@PathVariable(name = "id") final Long id) {
        categoryService.deleteCategory(id);
    }
}
