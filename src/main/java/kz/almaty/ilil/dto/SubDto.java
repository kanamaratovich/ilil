package kz.almaty.ilil.dto;

import kz.almaty.ilil.entity.Sub;
import kz.almaty.ilil.entity.SubAttributeValue;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class SubDto {
    private Long id;
    private String name;
    private Integer position;
    private PartnerDto partner;
    private List<SubCategoryDto> categories;
    private List<String> tags;
    private String periodFrom;
    private Integer moneyFrom;
    private Integer discountTo;
    private Integer followers;
    private String rating;
    private Boolean isNew;
    private CalcInitialValues calcInitialValues = new CalcInitialValues();

    public static SubDto fromSub(Sub sub){
        SubDto resultDto = new SubDto();
        resultDto.setId(sub.getId());
        resultDto.setPartner(PartnerDto.fromPartner(sub.getPartner()));

        if(sub.getSubCategories()!=null && sub.getSubCategories().size()>0) {
            resultDto.setCategories(sub.getSubCategories().stream()
                    .map(subCategory -> SubCategoryDto.fromSubCategory(subCategory))
                    .collect(Collectors.toList()));
        }

        if(sub.getAttributeValues()!=null && sub.getAttributeValues().size()>0){
            for(SubAttributeValue subAttributeValue : sub.getAttributeValues()){
                switch (subAttributeValue.getAttribute().getCode()){
                    case ("name"):
                        resultDto.setName(subAttributeValue.getTextValue());
                        break;
                    case ("tags"):
                        resultDto.setTags(Arrays.asList(subAttributeValue.getTextValue().split(";")));
                        break;
                    case("ratings"):
                        resultDto.setRating(String.format("%.1f",subAttributeValue.getFloatValue()));
                        break;
                    case("calcN0"):
                        resultDto.getCalcInitialValues().setN0(subAttributeValue.getIntegerValue());
                        break;
                    case("calcNmax"):
                        resultDto.getCalcInitialValues().setNmax(subAttributeValue.getIntegerValue());
                        break;
                    case("calcNmin"):
                        resultDto.getCalcInitialValues().setNmin(subAttributeValue.getIntegerValue());
                        break;
                    case("calcNstep"):
                        resultDto.getCalcInitialValues().setNstep(subAttributeValue.getIntegerValue());
                        break;
                    case("calcD0"):
                        resultDto.getCalcInitialValues().setD0(subAttributeValue.getIntegerValue());
                        break;
                    case("calcDmin"):
                        resultDto.getCalcInitialValues().setDmin(subAttributeValue.getIntegerValue());
                        break;
                    case("calcDmax"):
                        resultDto.getCalcInitialValues().setDmax(subAttributeValue.getIntegerValue());
                        break;
                    case("calcDstep"):
                        resultDto.getCalcInitialValues().setDstep(subAttributeValue.getIntegerValue());
                        break;
                    case("calcPmax"):
                        resultDto.getCalcInitialValues().setPmax(subAttributeValue.getIntegerValue());
                        break;
                    case("calcProductId"):
                        resultDto.getCalcInitialValues().setProductId(Long.valueOf(subAttributeValue.getIntegerValue()));
                        break;
                    case("new"):
                        resultDto.setIsNew(subAttributeValue.getBooleanValue());
                        break;
                }
            }
        }

        return resultDto;
    }
}
