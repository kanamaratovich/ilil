package kz.almaty.ilil.dto;

import kz.almaty.ilil.entity.AttributeGroup;
import kz.almaty.ilil.entity.AttributeGroupMapping;
import lombok.Data;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class AttributeGroupDto {
    private Long id;
    private String name;
    private Integer position;
    private Boolean isUserDefined;
    private List<AttributeDto> attributes;

    public static AttributeGroupDto fromAttributeGroup(AttributeGroup attributeGroup){
        AttributeGroupDto attributeGroupDto = new AttributeGroupDto();
        attributeGroupDto.setId(attributeGroup.getId());
        attributeGroupDto.setName(attributeGroup.getName());
        attributeGroupDto.setPosition(attributeGroup.getPosition());
        attributeGroupDto.setIsUserDefined(attributeGroup.getIsUserDefined());
        if(attributeGroup.getAttributeGroupMappings()!=null && attributeGroup.getAttributeGroupMappings().size()>0)
            attributeGroupDto.setAttributes(attributeGroup.getAttributeGroupMappings().stream()
                    .sorted(Comparator.comparingInt(AttributeGroupMapping::getPosition))
                    .map(attributeGroupMapping -> AttributeDto.fromAttribute(attributeGroupMapping.getAttribute())).collect(Collectors.toList()));
        return attributeGroupDto;
    }
}
