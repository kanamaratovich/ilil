package kz.almaty.ilil.service;

import kz.almaty.ilil.entity.AttributeFamily;
import kz.almaty.ilil.repository.AttributeFamilyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AttributeFamilyServiceImpl implements AttributeFamilyService {
    @Autowired
    private AttributeFamilyRepository attributeFamilyRepository;

    @Override
    public List<AttributeFamily> getAllAttributeFamilies() {
        return attributeFamilyRepository.findAll();
    }

    @Override
    public AttributeFamily getAttributeFamilyByCode(String code) {
        return attributeFamilyRepository.findAllByCode(code);
    }
}
