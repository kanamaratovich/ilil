package kz.almaty.ilil.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "attribute_families",schema = "nsi")
@Data
@ToString
public class AttributeFamily extends BaseEntity {

    @Column(name = "code")
    @Size(min = 1, max = 25)
    private String code;

    @Column(name = "name")
    @Size(min = 1, max = 100)
    private String name;

    @Column(name = "type")
    @Size(min = 1, max = 100)
    private String type;

    @Column(name = "is_user_defined")
    private Boolean isUserDefined;

    @OneToMany(mappedBy = "attributeFamily")
    List<AttributeGroup> attributeGroups;

}
