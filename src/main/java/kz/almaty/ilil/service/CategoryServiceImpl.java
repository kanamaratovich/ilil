package kz.almaty.ilil.service;

import kz.almaty.ilil.dto.CategoryDto;
import kz.almaty.ilil.entity.Category;
import kz.almaty.ilil.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addNewCategory(CategoryDto newCategory) {
        Category category = new Category();
        category.setName(newCategory.getName());
        category.setDescription(newCategory.getDescription());
        category.setPosition(newCategory.getPosition());
        category.setSlug(newCategory.getSlug());
        category = categoryRepository.save(category);
        return category;
    }
}
