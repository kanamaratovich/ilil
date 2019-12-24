package kz.almaty.ilil.service;

import kz.almaty.ilil.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts(List<String> filters, Long subId);
}
