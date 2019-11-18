package kz.almaty.ilil.service;

import kz.almaty.ilil.dto.SubDto;
import kz.almaty.ilil.entity.Product;
import kz.almaty.ilil.entity.ProductType;
import kz.almaty.ilil.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<SubDto> getAllSubs(Pageable pageable, List<String> filters,Long categoryId) {
        Page<SubDto> subs = null;
/*
        List<Product> allSubs = productRepository.findByType(ProductType.COMPLEX);

        *//*if(categoryId!=null){
            if(allSubs!=null && allSubs.size()>0){
                for(Product sub :allSubs){
                    if(sub.getProductCategories().stream().filter(productCategory -> productCategory.getCategory().getId().equals(categoryId)).count()==0){
                        allSubs.removeIf(product -> product.getId().equals(sub.getId()));
                    }
                }
            }
        }*//*

        if(filters==null){
            int start = (int) pageable.getOffset();
            int end = (start + pageable.getPageSize()) > allSubs.size() ? allSubs.size() : (start + pageable.getPageSize());

            subs = new PageImpl<>(allSubs.stream().map(product -> SubDto.fromProduct(product)).collect(Collectors.toList()).subList(start,end),pageable,allSubs.size());
        }*/
        return subs;
    }
}
