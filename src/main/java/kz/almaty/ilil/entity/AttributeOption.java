package kz.almaty.ilil.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "attribute_options",schema = "nsi")
@Data
@ToString
public class AttributeOption extends BaseEntity {

    @Column(name = "attribute_id")
    private Long attributeId;

    @Column(name = "name")
    @Size(min = 1,max = 50)
    private String name;

    @Column(name = "sort_order")
    private Integer sortOrder;

    @Column(name = "swatch_value")
    private String swatchValue;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attribute_id",referencedColumnName = "id",updatable = false,insertable = false)
    private Attribute attribute;

}
