package kz.almaty.ilil.repository;

import kz.almaty.ilil.entity.Sub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SubRepository extends JpaRepository<Sub,Long> {
}
