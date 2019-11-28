package kz.almaty.ilil.rest;

import kz.almaty.ilil.dto.CategoryDto;
import kz.almaty.ilil.entity.Category;
import kz.almaty.ilil.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/categories")
public class CategoryRestControllerV1 {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    @ResponseBody
    public List<CategoryDto> getAllCategories(@RequestParam(name = "parentId",required = false) Long parentId){
        List<Category> categories = categoryService.getAll(parentId);
        return categories.stream()
                .map(category -> CategoryDto.fromCategory(category)).collect(Collectors.toList());
    }
}
