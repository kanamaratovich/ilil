package kz.almaty.ilil.repository;

import kz.almaty.ilil.entity.Status;
import kz.almaty.ilil.entity.Sub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface SubRepository extends JpaRepository<Sub,Long> {
    @Query(value = "select s.* from NSI.SUBS s left join NSI.SUB_CATEGORIES q on s.id = q.sub_id  where q.category_id = ?1 and s.status = 'ACTIVE' order by q.position",nativeQuery = true)
    List<Sub> findByCategoryId(Long categoryId);

    List<Sub> findAllByStatusOrderByPosition(Status status);
}
