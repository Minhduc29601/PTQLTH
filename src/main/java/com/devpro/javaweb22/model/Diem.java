package com.devpro.javaweb22.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "diem")
public class Diem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "id_sv")
    private Integer id_sv;
    @Column(name = "id_mh")
    private Integer id_mh;
    @Column(name = "diem_so")
    private Integer diem_so;
}
