package kz.almaty.ilil.dto;

import kz.almaty.ilil.entity.Category;
import lombok.Data;

@Data
public class CategoryDto {
    private Long id;
    private Long parentId;
    private String name;
    private String slug;
    private String description;
    private Integer position;

    public static CategoryDto fromCategory(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setDescription(category.getDescription());
        categoryDto.setSlug(category.getSlug());
        categoryDto.setPosition(category.getPosition());
        return categoryDto;
    }
}
