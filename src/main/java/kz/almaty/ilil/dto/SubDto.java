package kz.almaty.ilil.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kz.almaty.ilil.entity.Sub;
import kz.almaty.ilil.entity.SubAttributeValue;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class SubDto {
    private Long id;
    private String name;
    @NotNull
    private String sku;
    private Integer position;
    private List<SubCategoryDto> categories;
    private List<String> tags;
    private String periodFrom;
    private Integer moneyFrom;
    private Integer discountTo;
    private String rating;

    public static SubDto fromSub(Sub sub){
        SubDto resultDto = new SubDto();
        resultDto.setId(sub.getId());
        resultDto.setName(sub.getName());
        resultDto.setSku(sub.getSku());
        resultDto.setPosition(sub.getPosition());

        if(sub.getSubCategories()!=null && sub.getSubCategories().size()>0) {
            resultDto.setCategories(sub.getSubCategories().stream()
                    .map(subCategory -> SubCategoryDto.fromSubCategory(subCategory))
                    .collect(Collectors.toList()));
        }

        if(sub.getAttributeValues()!=null && sub.getAttributeValues().size()>0){
            for(SubAttributeValue subAttributeValue : sub.getAttributeValues()){
                switch (subAttributeValue.getAttribute().getCode()){
                    case ("tags"):
                        resultDto.setTags(Arrays.asList(subAttributeValue.getTextValue().split(";")));
                        break;
                    case("ratings"):
                        resultDto.setRating(String.format("%.1f",subAttributeValue.getFloatValue()));
                        break;
                    /*case("calcN0"):

                        break;*/    
                }
            }
        }

        return resultDto;
    }

    public Sub toSub() {
        Sub sub = new Sub();
        return sub;
    }
}
