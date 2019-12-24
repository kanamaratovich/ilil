package kz.almaty.ilil.repository;

import kz.almaty.ilil.entity.AttributeFamily;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributeFamilyRepository extends JpaRepository<AttributeFamily,Long> {

    AttributeFamily findAllByCode(String code);
}
