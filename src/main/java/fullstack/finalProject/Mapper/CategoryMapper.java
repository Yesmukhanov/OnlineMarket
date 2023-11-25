package fullstack.finalProject.Mapper;

import fullstack.finalProject.dto.CategoryDTO;
import fullstack.finalProject.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toDTO(Category category);

    Category toModel(CategoryDTO categoryDTO);

    List<CategoryDTO> toDtoList(List<Category> categories);

    List<Category> toModelList(List<CategoryDTO> categoryDTOS);
}
