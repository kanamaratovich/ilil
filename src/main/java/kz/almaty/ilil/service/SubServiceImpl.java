package kz.almaty.ilil.service;

import kz.almaty.ilil.dto.CategoryDto;
import kz.almaty.ilil.dto.ShortCategoryDto;
import kz.almaty.ilil.dto.SubCategoryDto;
import kz.almaty.ilil.dto.SubDto;
import kz.almaty.ilil.entity.*;
import kz.almaty.ilil.repository.CategoryRepository;
import kz.almaty.ilil.repository.SubRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SubServiceImpl implements SubService{
    @Autowired
    private SubRepository subRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Sub addSub(Sub newSub){
        /*
        Sub sub = new Sub();
        sub.setName(newSub.getName());
        sub.setSku(newSub.getSku());
        sub.setPosition(newSub.getPosition());
        sub.setAttributeFamilyId(newSub.getAttributeFamilyId());
        sub = subRepository.save(sub);

        *//*Если в запросе отправили еще и категории подписки : 1)либо оно уже есть в базе 2)либо это новая категория*//*
        if(newSub.getSubCategories()!=null && newSub.getSubCategories().size()>0){
           for(SubCategory subCategory : newSub.getSubCategories()){
               Category category = null;
               if(subCategory.getCategory()!=null){
                   Category categoryInfo = subCategory.getCategory();
                   *//*1)*//*
                   if(categoryInfo.getId()!=null){
                       category = categoryRepository.getOne(categoryInfo.getId());
                   }*//*else{
                       *//**//*2)*//**//*
                       category = new Category();
                       category.setName(shortCategoryDto.getName());
                       category.setSlug(shortCategoryDto.getSlug());
                       category.setPosition(shortCategoryDto.getPosition());
                       category.setDescription(shortCategoryDto.getDescription());
                       category.setParentId(shortCategoryDto.getParentId());
                       category = categoryRepository.save(category);
                   }*//*
                   SubCategory subCategory = new SubCategory();
                   subCategory.setCategory(category);
                   subCategory.setPosition(categoryInfo.getPosition());
                   *//*обавляем категорию в подписку*//*
                   sub.getSubCategories().add(subCategory);
               }
           }
           *//*сохраняем измененую подписку с категориями*//*
           subRepository.save(sub);
        }*/
        return null;
    }

    @Override
    public List<Sub> getAllSubs(Long categoryId,Boolean recommend,String cityCode){
        List<Sub> subs;
        if(categoryId!=null){
            subs = subRepository.findByCategoryId(categoryId);
        }else{
            subs = subRepository.findAllByStatusOrderByPosition(Status.ACTIVE);
        }
        if(recommend!=null && recommend || cityCode!=null && !cityCode.isEmpty()){
            subs = subs.stream().filter(sub -> sub.getAttributeValues()!=null && sub.getAttributeValues().size()>0).collect(Collectors.toList());
            for(Sub sub : subs){
                List<SubAttributeValue> attributeValues = sub.getAttributeValues();
                if(recommend!=null && recommend) {
                /*ЕСЛИ У ПОДПИСКИ НЕТ АТТРИБУТА С КОДОМ recommend И ЗНАЧЕНИЕ НЕ true
                   ТОГДА УДАЛЯЕМ ПОДПИСКУ ИЗ subs
                */
                    if (attributeValues.stream()
                            .filter(subAttributeValue -> subAttributeValue.getAttribute().getCode().equals("recommend") &&
                                    subAttributeValue.getBooleanValue().equals(true)).count() == 0) {
                        subs.remove(sub);
                    }
                }
                if(cityCode!=null && !cityCode.isEmpty()){
                    /*ЕСЛИ У ПОДПИСКИ НЕТ АТТРИБУТА С КОДОМ cityCode И ЗНАЧЕНИЕ НЕ ИМЕЕТ cityCode(value)
                        ТОГДА УДАЛЯЕМ ПОДПИСКУ ИЗ subs
                    */
                    if (attributeValues.stream()
                            .filter(subAttributeValue -> subAttributeValue.getAttribute().getCode().equals("cityCodes") &&
                                    subAttributeValue.getTextValue().contains(cityCode)).count() == 0) {
                        subs.remove(sub);
                    }
                }
            }
        }


        return subs;
    }
}
