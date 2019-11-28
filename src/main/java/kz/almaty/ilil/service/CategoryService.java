package kz.almaty.ilil.service;

import kz.almaty.ilil.dto.CategoryDto;
import kz.almaty.ilil.entity.Category;

import java.util.List;

public interface CategoryService {

    Category addNewCategory(CategoryDto newCategory);

    List<Category> getAll(Long parentId);
}
