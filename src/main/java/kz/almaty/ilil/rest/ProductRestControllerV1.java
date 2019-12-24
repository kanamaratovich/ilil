package kz.almaty.ilil.rest;

import kz.almaty.ilil.dto.ProductDto;
import kz.almaty.ilil.entity.Product;
import kz.almaty.ilil.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/products")
public class ProductRestControllerV1 {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    @ResponseBody
    public List<ProductDto> getAllSubs(@RequestParam(name = "filters",required = false) List<String> filters,
                                       @RequestParam(name = "subId",required = false) Long subId){
        List<Product> allProducts = productService.getAllProducts(filters,subId);

        return allProducts.stream().map(product -> ProductDto.fromProduct(product)).collect(Collectors.toList());
    }


}
