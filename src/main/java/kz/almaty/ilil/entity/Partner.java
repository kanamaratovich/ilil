package kz.almaty.ilil.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "partners", schema = "nsi")
@Data
@ToString
public class Partner extends BaseEntity{
    @Column(name = "name")
    private String name;
    @Column(name = "image")
    private String image;
}
