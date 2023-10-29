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
    @Column(name = "khu_vuc_id")
    private String khu_vuc_id;
    @Column(name = "khoa_id")
    private String khoa_id;
    @Column(name = "magv")
    private String magv;

}
