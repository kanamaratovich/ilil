package kz.almaty.ilil.service;

import kz.almaty.ilil.entity.Product;
import kz.almaty.ilil.entity.Status;
import kz.almaty.ilil.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts(List<String> filters, Long subId) {
        List<Product> products = null;
        if(subId!=null){
            products = productRepository.findAllBySubIdAndStatus(subId, Status.ACTIVE);
        }else{
            products = productRepository.findAllByStatus(Status.ACTIVE);
        }

        List<Product> copyProductList = new ArrayList<>(products);

        if(filters!=null && filters.size()>0){
            for(Product product : copyProductList){
                for(String filter : filters){
                    String code = filter.split("=")[0];
                    String value = filter.split("=")[1];

                    if(!(product.getAttributeValues()!=null &&
                            product.getAttributeValues().size()>0 &&
                            product.getAttributeValues().stream()
                            .filter(productAttributeValue ->
                                    productAttributeValue.getAttribute().getCode().equals(code)
                                            && productAttributeValue.getTextValue().equals(value)).count()>0)){
                        products.remove(product);
                    }
                }
            }
        }

        return products;
    }
}
