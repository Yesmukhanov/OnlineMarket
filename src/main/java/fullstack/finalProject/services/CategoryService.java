package fullstack.finalProject.services;

import fullstack.finalProject.Mapper.CategoryMapper;
import fullstack.finalProject.dto.CategoryDTO;
import fullstack.finalProject.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryDTO> getCategories() {
        return categoryMapper.toDtoList(categoryRepository.findAll());
    }

    public CategoryDTO addCategory(final CategoryDTO categoryDTO) {
        return categoryMapper.toDTO(categoryRepository.save(categoryMapper.toModel(categoryDTO)));
    }

    public CategoryDTO getCategory(final Long id) {
        return categoryMapper.toDTO(categoryRepository.findById(id).orElseThrow());
    }

    public CategoryDTO updateCategory(final CategoryDTO categoryDTO) {
        return categoryMapper.toDTO(categoryRepository.save(categoryMapper.toModel(categoryDTO)));
    }

    public void deleteCategory(final Long id) {
        categoryRepository.deleteById(id);
    }
}
