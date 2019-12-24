package kz.almaty.ilil.service;

import kz.almaty.ilil.entity.AttributeFamily;

import java.util.List;

public interface AttributeFamilyService {

    List<AttributeFamily> getAllAttributeFamilies();

    AttributeFamily getAttributeFamilyByCode(String code);
}
