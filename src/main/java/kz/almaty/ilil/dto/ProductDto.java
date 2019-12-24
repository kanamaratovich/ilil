package kz.almaty.ilil.dto;

import kz.almaty.ilil.entity.Product;
import kz.almaty.ilil.entity.ProductAttributeValue;
import lombok.Data;

import java.util.List;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private Long subId;

    public static ProductDto fromProduct(Product product){
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        List<ProductAttributeValue> attributeValues = product.getAttributeValues();

        if(attributeValues!=null && attributeValues.size()>0){
            for(ProductAttributeValue productAttributeValue : attributeValues){
                switch (productAttributeValue.getAttribute().getCode()){
                    case "name":
                        dto.setName(productAttributeValue.getTextValue());
                        break;
                }
            }
        }
        dto.setSubId(product.getSubId());
        return dto;
    }
}
