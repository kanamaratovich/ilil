package kz.almaty.ilil.dto;

import kz.almaty.ilil.entity.AttributeFamily;
import kz.almaty.ilil.entity.AttributeGroup;
import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class AttributeFamilyDto {
    private Long id;
    private String name;
    private String code;
    private Boolean isUserDefined;
    private List<AttributeGroupDto> groups;

    public static AttributeFamilyDto fromAttributeFamily(AttributeFamily attributeFamily) {
        AttributeFamilyDto attributeFamilyDto = new AttributeFamilyDto();
        attributeFamilyDto.setId(attributeFamily.getId());
        attributeFamilyDto.setCode(attributeFamily.getCode());
        attributeFamilyDto.setName(attributeFamily.getName());
        attributeFamilyDto.setIsUserDefined(attributeFamily.getIsUserDefined());

        if(attributeFamily.getAttributeGroups()!=null && attributeFamily.getAttributeGroups().size()>0)
            attributeFamilyDto.setGroups(new ArrayList<>(attributeFamily.getAttributeGroups().stream().sorted(Comparator.comparingInt(AttributeGroup::getPosition)).map(attributeGroup -> AttributeGroupDto.fromAttributeGroup(attributeGroup)).collect(Collectors.toList())));

        return attributeFamilyDto;
    }
}
