package techorda.bitlab.FinalProjectOfFinal.Mapper;

import org.mapstruct.Mapper;
import techorda.bitlab.FinalProjectOfFinal.dto.CategoryDTO;
import techorda.bitlab.FinalProjectOfFinal.model.Category;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toDTO(Category category);

    Category toModel(CategoryDTO categoryDTO);

    List<CategoryDTO> toDtoList(List<Category> categories);

    List<Category> toModelList(List<CategoryDTO> categoryDTOS);
}
