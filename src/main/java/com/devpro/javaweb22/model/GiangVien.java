package com.devpro.javaweb22.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@DiscriminatorValue("giang_vien")
@Table(name = "giang_vien")
public class GiangVien extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "magv")
    private String magv;
}
