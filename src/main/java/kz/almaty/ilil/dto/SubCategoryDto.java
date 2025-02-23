package kz.almaty.ilil.dto;

import kz.almaty.ilil.entity.SubCategory;
import lombok.Data;

@Data
public class SubCategoryDto {
    private ShortCategoryDto category;
    private Integer position;

    public static SubCategoryDto fromSubCategory(SubCategory subCategory){
        SubCategoryDto subCategoryDto = new SubCategoryDto();
        subCategoryDto.setCategory(ShortCategoryDto.fromCategory(subCategory.getCategory()));
        subCategoryDto.setPosition(subCategory.getPosition());
        return subCategoryDto;
    }
}
