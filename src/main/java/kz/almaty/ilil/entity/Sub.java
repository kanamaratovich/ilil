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
    @Column(name = "attribute_family_id",nullable = false)
    private Long attributeFamilyId;

    @NotNull
    @Column(name = "partner_id",nullable = false)
    private Long partnerId;

    @OneToMany(mappedBy = "sub",cascade = CascadeType.ALL)
    private List<SubCategory> subCategories;

    @OneToMany(mappedBy = "sub")
    List<SubAttributeValue> attributeValues;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "partner_id",referencedColumnName = "id",updatable = false,insertable = false)
    private Partner partner;


}
