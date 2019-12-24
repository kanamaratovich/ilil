package kz.almaty.ilil.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "attribute_groups",schema = "nsi")
@Data
@ToString
public class AttributeGroup extends BaseEntity {
    @Column(name = "name")
    @Size(min = 1, max = 100)
    private String name;

    @Column(name = "position")
    private Integer position;

    @Column(name = "attribute_family_id")
    private Long attributeFamilyId;

    @Column(name = "is_user_defined")
    private Boolean isUserDefined;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attribute_family_id",referencedColumnName = "id",updatable = false,insertable = false)
    private AttributeFamily attributeFamily;

    @OneToMany(mappedBy = "attributeGroup")
    private List<AttributeGroupMapping> attributeGroupMappings;
}
