package FullStack.FinalProject.Mapper;

import FullStack.FinalProject.dto.CategoryDTO;
import FullStack.FinalProject.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toDTO(Category category);

    Category toModel(CategoryDTO categoryDTO);

    List<CategoryDTO> toDtoList(List<Category> categories);

    List<Category> toModelList(List<CategoryDTO> categoryDTOS);
}
