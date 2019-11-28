package kz.almaty.ilil.repository;

import kz.almaty.ilil.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category,Long> {
    List<Category> findAllByParentIdOrderByPosition(Long parentId);
}
