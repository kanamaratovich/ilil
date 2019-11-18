package kz.almaty.ilil.service;

import kz.almaty.ilil.dto.SubDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    Page<SubDto> getAllSubs(Pageable pageable, List<String> filters,Long categoryId);
}
