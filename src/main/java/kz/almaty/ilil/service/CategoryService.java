package kz.almaty.ilil.service;

import kz.almaty.ilil.dto.CategoryDto;
import kz.almaty.ilil.entity.Category;

public interface CategoryService {

    Category addNewCategory(CategoryDto newCategory);
}
