package kz.almaty.ilil.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "products", schema = "nsi")
@Data
@ToString
public class Product extends BaseEntity {

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "type",nullable = false)
    private ProductType type;

    @NotNull
    @Column(name = "attribute_family_id",nullable = false)
    private Long attributeFamilyId;

    @Column(name = "sub_id")
    private Long subId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sub_id",referencedColumnName = "id",updatable = false,insertable = false)
    private Sub sub;

    @OneToMany(mappedBy = "product")
    List<ProductAttributeValue> attributeValues;

}
