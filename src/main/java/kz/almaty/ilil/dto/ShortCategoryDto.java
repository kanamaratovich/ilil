package kz.almaty.ilil.dto;

import kz.almaty.ilil.entity.Category;
import lombok.Data;

@Data
public class ShortCategoryDto {
    private Long id;
    private String name;
    private String slug;
    private Integer position;

    public static ShortCategoryDto fromCategory(Category category){
        ShortCategoryDto categoryDto = new ShortCategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setSlug(category.getSlug());
        categoryDto.setPosition(category.getPosition());
        return categoryDto;
    }

}
