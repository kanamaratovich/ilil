package kz.almaty.ilil.dto;

import kz.almaty.ilil.entity.Attribute;
import kz.almaty.ilil.entity.AttributeGroupMapping;
import kz.almaty.ilil.entity.AttributeOption;
import lombok.Data;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class AttributeDto {
    private Long id;
    private String name;
    private String code;
    private String type;
    private String validation;
    private Integer position;
    private Boolean isRequired;
    private Boolean isUnique;
    private Boolean isFilterable;
    private Boolean isConfigurable;
    private Boolean isUserDefined;
    private Boolean isVisibleOnFront;
    private List<AttributeOptionDto> attributeOptions;

    /*public static AttributeDto fromAttributeGroupMapping(AttributeGroupMapping attributeGroupMapping) {
        AttributeDto attributeDto = new AttributeDto();
        if(attributeGroupMapping.getAttribute()!=null) {
            Attribute attribute = attributeGroupMapping.getAttribute();
            attributeDto.setId(attribute.getId());
            attributeDto.setName(attribute.getName());
            attributeDto.setCode(attribute.getCode());
            attributeDto.setPosition(attributeGroupMapping.getPosition());
            attributeDto.setType(attribute.getType());
            attributeDto.setValidation(attribute.getValidation());
            attributeDto.setIsRequired(attribute.getIsRequired());
            attributeDto.setIsUnique(attribute.getIsUnique());
            attributeDto.setIsFilterable(attribute.getIsFilterable());
            attributeDto.setIsConfigurable(attribute.getIsConfigurable());
            attributeDto.setIsUserDefined(attribute.getIsUserDefined());
            attributeDto.setIsVisibleOnFront(attribute.getIsVisibleOnFront());
            List<AttributeOption> attributeOptions = attribute.getAttributeOptions();
            if (attributeOptions != null && attributeOptions.size() > 0){
                attributeDto.setAttributeOptions(attributeOptions.stream()
                        .sorted(Comparator.comparingInt(AttributeOption::getSortOrder))
                        .map(attributeOption -> AttributeOptionDto.fromAttributeOption(attributeOption)).collect(Collectors.toList()));
            }
        }
        return attributeDto;
    }*/

    public static AttributeDto fromAttribute(Attribute attribute){
        AttributeDto attributeDto = new AttributeDto();
        attributeDto.setId(attribute.getId());
        attributeDto.setName(attribute.getName());
        attributeDto.setCode(attribute.getCode());
        attributeDto.setPosition(attribute.getPosition());
        attributeDto.setType(attribute.getType());
        attributeDto.setValidation(attribute.getValidation());
        attributeDto.setIsRequired(attribute.getIsRequired());
        attributeDto.setIsUnique(attribute.getIsUnique());
        attributeDto.setIsFilterable(attribute.getIsFilterable());
        attributeDto.setIsConfigurable(attribute.getIsConfigurable());
        attributeDto.setIsUserDefined(attribute.getIsUserDefined());
        attributeDto.setIsVisibleOnFront(attribute.getIsVisibleOnFront());
        List<AttributeOption> attributeOptions = attribute.getAttributeOptions();
        if (attributeOptions != null && attributeOptions.size() > 0){
            attributeDto.setAttributeOptions(attributeOptions.stream()
                    .sorted(Comparator.comparingInt(AttributeOption::getSortOrder))
                    .map(attributeOption -> AttributeOptionDto.fromAttributeOption(attributeOption)).collect(Collectors.toList()));
        }
        return attributeDto;
    }
}
