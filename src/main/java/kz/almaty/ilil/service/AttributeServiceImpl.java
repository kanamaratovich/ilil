package kz.almaty.ilil.service;

import kz.almaty.ilil.entity.Attribute;
import kz.almaty.ilil.repository.AttributeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AttributeServiceImpl implements AttributeService {
    @Autowired
    private AttributeRepository attributeRepository;

    @Override
    public List<Attribute> getAllAttributes() {
        return attributeRepository.findAll();
    }
}
