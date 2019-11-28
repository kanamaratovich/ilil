package kz.almaty.ilil.dto;

import kz.almaty.ilil.entity.Category;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class CategoryDto {
    private Long id;
    private Long parentId;
    private String name;
    private String slug;
    private String description;
    private Integer position;
    private List<CategoryDto> childCategories;

    public static CategoryDto fromCategory(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setParentId(category.getParentId());
        categoryDto.setName(category.getName());
        categoryDto.setDescription(category.getDescription());
        categoryDto.setSlug(category.getSlug());
        categoryDto.setPosition(category.getPosition());

        if(category.getChildCategories()!=null && category.getChildCategories().size()>0)
            categoryDto.setChildCategories(category.getChildCategories().stream().map(child -> CategoryDto.fromCategory(child)).collect(Collectors.toList()));

        return categoryDto;
    }
}
