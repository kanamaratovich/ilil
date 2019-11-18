package kz.almaty.ilil.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "categories", schema = "nsi")
@Data
@ToString
public class Category extends BaseEntity {

    @Column(name = "parent_id")
    private Long parentId;

    @NotNull
    @Column(name = "name",nullable = false)
    private String name;

    @NotNull
    @Column(name = "slug",unique = true, nullable = false)
    private String slug;

    @Column(name = "description")
    private String description;

    @Column(name = "position")
    private Integer position;

    @Column(name = "image")
    private String image;

    /*@OneToMany(mappedBy = "categories",cascade= CascadeType.ALL)
    private List<ProductCategory> productCategoryList;*/
}
