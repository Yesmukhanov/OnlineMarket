package techorda.bitlab.FinalProjectOfFinal.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import techorda.bitlab.FinalProjectOfFinal.Mapper.CategoryMapper;
import techorda.bitlab.FinalProjectOfFinal.dto.CategoryDTO;
import techorda.bitlab.FinalProjectOfFinal.repository.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryDTO> getCategories(){
        return categoryMapper.toDtoList(categoryRepository.findAll());
    }

    public CategoryDTO addCategory(CategoryDTO categoryDTO){
        return categoryMapper.toDTO(categoryRepository.save(categoryMapper.toModel(categoryDTO)));
    }

    public CategoryDTO getCategory(Long id){
        return categoryMapper.toDTO(categoryRepository.findById(id).orElseThrow());
    }

    public CategoryDTO updateCategory(CategoryDTO categoryDTO){
        return categoryMapper.toDTO(categoryRepository.save(categoryMapper.toModel(categoryDTO)));
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }


}
