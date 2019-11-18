/*
package kz.almaty.ilil.rest;

import kz.almaty.ilil.dto.SubDto;
import kz.almaty.ilil.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/")
public class ProductRestControllerV1 {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/subs",method = RequestMethod.GET)
    public Page<SubDto> getAllSubs(@RequestParam(name = "categoryId", required = false) Long categoryId,
                                   @RequestParam(name = "filters", required = false) List<String> filters,
                                   @RequestParam(name = "size", required = false,defaultValue = "10") int size,
                                   @RequestParam(name = "page", required = false,defaultValue = "0") int page,
                                   @RequestParam(name = "sortedBy", required = false,defaultValue = "position") String sortedBy){

        return productService.getAllSubs(PageRequest.of(page,size,Sort.by(Sort.Direction.DESC,sortedBy)),filters,categoryId);
    }

    @RequestMapping(value = "/subs/{id}/products",method = RequestMethod.GET)
    public Page<SubDto> getSubProducts(@PathVariable(name = "id") Long subId,
                                   @RequestParam(name = "filters", required = false) List<String> filters,
                                   @RequestParam(name = "size", required = false,defaultValue = "10") int size,
                                   @RequestParam(name = "page", required = false,defaultValue = "0") int page,
                                   @RequestParam(name = "sortedBy", required = false,defaultValue = "position") String sortedBy){
        Page<SubDto> subs = null;

        return subs;
    }


}
*/
