package kz.almaty.ilil.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "attributes",schema = "nsi")
@Data
@ToString
public class Attribute extends BaseEntity{
    @Column(name = "code")
    @Size(min = 1, max = 25)
    private String code;

    @Column(name = "name")
    @Size(min = 1, max = 100)
    private String name;

    @Size(min = 1, max = 100)
    @Column(name = "type")
    private String type;

    @Size(min = 1, max = 100)
    @Column(name = "validation")
    private String validation;

    @Column(name = "position")
    private Integer position;

    @Column(name = "is_required")
    private Boolean isRequired;

    @Column(name = "is_unique")
    private Boolean isUnique;

    @Column(name = "is_filterable")
    private Boolean isFilterable;

    @Column(name = "is_configurable")
    private Boolean isConfigurable;

    @Column(name = "is_user_defined")
    private Boolean isUserDefined;

    @Column(name = "is_visible_on_front")
    private Boolean isVisibleOnFront;

    @OneToMany(mappedBy = "attribute")
    List<AttributeOption> attributeOptions;
}
