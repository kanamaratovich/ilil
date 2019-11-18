package kz.almaty.ilil.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "products", schema = "nsi")
@Data
@ToString
public class Product extends BaseEntity {

    @NotNull
    @Column(name = "name",nullable = false)
    private String name;

    @NotNull
    @Column(name = "sku",unique = true,nullable = false)
    private String sku;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "type",nullable = false)
    private ProductType type;

    @NotNull
    @Column(name = "attribute_family_id",nullable = false)
    private Long attributeFamilyId;

    @Column(name = "sub_id")
    private Long subId;

    @Column(name = "position")
    private Integer position;

    /*@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<ProductCategory> productCategories;*/

}
