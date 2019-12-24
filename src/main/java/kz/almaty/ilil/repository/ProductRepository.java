package kz.almaty.ilil.repository;

import kz.almaty.ilil.entity.Product;
import kz.almaty.ilil.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllBySubIdAndStatus(Long subId,Status status);

    List<Product>findAllByStatus(Status status);
}
