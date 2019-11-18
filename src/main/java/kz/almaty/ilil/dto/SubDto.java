package kz.almaty.ilil.dto;

import kz.almaty.ilil.entity.Sub;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class SubDto {
    private Long id;
    private String name;
    private String sku;
    private Integer position;
    private List<SubCategoryDto> categories;
    private Long attributeFamilyId;
    private List<String> tags;
    private String periodFrom;
    private Integer moneyFrom;
    private Integer discountTo;
    private Double rating;

    public static SubDto fromSub(Sub sub){
        SubDto resultDto = new SubDto();
        resultDto.setId(sub.getId());
        resultDto.setName(sub.getName());
        resultDto.setSku(sub.getSku());
        resultDto.setPosition(sub.getPosition());
        resultDto.setCategories(sub.getSubCategories()!=null && sub.getSubCategories().size()>0 ?
                sub.getSubCategories().stream()
                .map(subCategory -> SubCategoryDto.fromSubCategory(subCategory)).collect(Collectors.toList()) : null);
        resultDto.setAttributeFamilyId(sub.getAttributeFamilyId());

        return resultDto;
    }
}
