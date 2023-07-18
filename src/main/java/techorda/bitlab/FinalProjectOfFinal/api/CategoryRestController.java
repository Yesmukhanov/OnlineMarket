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

    @GetMapping
    public List<CategoryDTO> getCategories(){
        return categoryService.getCategories();
    }

    @GetMapping(value = "{id}")
    public CategoryDTO getCategory(@PathVariable(name = "id") Long id){
        return categoryService.getCategory(id);
    }

    @PostMapping
    public CategoryDTO addCategory(@RequestBody CategoryDTO category){
        return categoryService.addCategory(category);
    }

    @PutMapping
    public CategoryDTO updateCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryService.updateCategory(categoryDTO);
    }

    @DeleteMapping(value = "{id}")
    public void deleteCategory(@PathVariable(name = "id") Long id){
        categoryService.deleteCategory(id);
    }




}
