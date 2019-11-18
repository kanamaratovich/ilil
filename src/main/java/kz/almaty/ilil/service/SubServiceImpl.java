package kz.almaty.ilil.service;

import kz.almaty.ilil.dto.CategoryDto;
import kz.almaty.ilil.dto.SubCategoryDto;
import kz.almaty.ilil.dto.SubDto;
import kz.almaty.ilil.entity.Category;
import kz.almaty.ilil.entity.Sub;
import kz.almaty.ilil.entity.SubCategory;
import kz.almaty.ilil.repository.CategoryRepository;
import kz.almaty.ilil.repository.SubRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SubServiceImpl implements SubService{
    @Autowired
    private SubRepository subRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Sub addSub(SubDto newSub) throws Exception {
        Sub sub = new Sub();
        sub.setName(newSub.getName());
        sub.setSku(newSub.getSku());
        sub.setPosition(newSub.getPosition());
        sub.setAttributeFamilyId(newSub.getAttributeFamilyId());
        sub = subRepository.save(sub);

        /*Если в запросе отправили еще и категории подписки : 1)либо оно уже есть в базе 2)либо это новая категория*/
        if(newSub.getCategories()!=null && newSub.getCategories().size()>0){
           for(SubCategoryDto subCategoryDto : newSub.getCategories()){
               Category category;
               if(subCategoryDto.getCategory()!=null){
                   CategoryDto categoryDto = subCategoryDto.getCategory();
                   if(categoryDto.getId()!=null){/*1)*/
                       category = categoryRepository.getOne(categoryDto.getId());
                   }else{/*2)*/
                       category = new Category();
                       category.setName(categoryDto.getName());
                       category.setSlug(categoryDto.getSlug());
                       category.setPosition(categoryDto.getPosition());
                       category.setDescription(categoryDto.getDescription());
                       category.setParentId(categoryDto.getParentId());
                       category = categoryRepository.save(category);
                   }
                   SubCategory subCategory = new SubCategory();
                   subCategory.setCategory(category);
                   subCategory.setPosition(subCategoryDto.getPosition());
                   /*обавляем категорию в подписку*/
                   sub.getSubCategories().add(subCategory);
               }else{
                   /*Не правильно сформировали данные*/
                   throw new Exception("Ошибка: Не правильно сформировали данные;542");
               }
           }
           /*сохраняем измененую подписку с категориями*/
           subRepository.save(sub);
        }
        return null;
    }
}
