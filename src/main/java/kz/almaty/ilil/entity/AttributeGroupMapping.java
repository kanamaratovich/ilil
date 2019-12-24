package kz.almaty.ilil.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "attribute_group_mappings", schema = "nsi")
@Data
@ToString
public class AttributeGroupMapping implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "attribute_group_id",referencedColumnName = "id")
    private AttributeGroup attributeGroup;

    @Id
    @ManyToOne
    @JoinColumn(name = "attribute_id",referencedColumnName = "id")
    private Attribute attribute;

    @Column(name = "position")
    private Integer position;
}
