package kz.almaty.ilil.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "subs", schema = "nsi")
@Data
@ToString
public class Sub extends BaseEntity {
    @NotNull
    @Column(name = "name",nullable = false)
    private String name;

    @NotNull
    @Column(name = "sku",unique = true,nullable = false)
    private String sku;

    @NotNull
    @Column(name = "attribute_family_id",nullable = false)
    private Long attributeFamilyId;

    @Column(name = "position")
    private Integer position;

    @OneToMany(mappedBy = "sub",cascade = CascadeType.ALL)
    private List<SubCategory> subCategories;

    @OneToMany(mappedBy = "sub")
    List<SubAttributeValue> attributeValues;
}
