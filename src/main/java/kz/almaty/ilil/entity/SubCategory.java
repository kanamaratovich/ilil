package kz.almaty.ilil.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sub_categories", schema = "nsi")
@Data
@ToString
public class SubCategory implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "sub_id",referencedColumnName = "id")
    private Sub sub;

    @Id
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;

    @Column(name = "position")
    private Integer position;
}
