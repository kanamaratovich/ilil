package kz.almaty.ilil.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "sub_attribute_values",schema = "nsi")
@Data
@ToString
public class SubAttributeValue extends BaseEntity{
    @Size(min = 1, max = 100)
    @Column(name = "text_value")
    private String textValue;

    @Column(name = "boolean_value")
    private Boolean booleanValue;

    @Column(name = "integer_value")
    private Integer integerValue;

    @Column(name = "float_value")
    private Float floatValue;

    @Column(name = "datetime_value")
    private Date datetimeValue;

    @Column(name = "date_value")
    private Date dateValue;

    @Column(name = "json_value")
    private String jsonValue;

    @NotNull
    @Column(name = "sub_id")
    private Long productId;

    @NotNull
    @Column(name = "attribute_id")
    private Long attributeId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sub_id",referencedColumnName = "id",updatable = false,insertable = false)
    private Sub sub;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attribute_id",referencedColumnName = "id",updatable = false,insertable = false)
    private Attribute attribute;
}
