package kz.almaty.ilil.dto;

import kz.almaty.ilil.entity.AttributeOption;
import lombok.Data;

@Data
public class AttributeOptionDto {
    private Long id;
    private String name;
    private Integer sortOrder;
    private String swatchValue;

    public static AttributeOptionDto fromAttributeOption(AttributeOption attributeOption){
        AttributeOptionDto attributeOptionDto = new AttributeOptionDto();
        attributeOptionDto.setId(attributeOption.getId());
        attributeOptionDto.setName(attributeOption.getName());
        attributeOptionDto.setSortOrder(attributeOption.getSortOrder());
        attributeOptionDto.setSwatchValue(attributeOption.getSwatchValue());
        return attributeOptionDto;
    }
}
