package com.devpro.javaweb22.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@DiscriminatorValue("sinh_vien")
@Table(name = "sinh_vien")
public class SinhVien extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "khu_vuc_id")
    private String khu_vuc_id;
    @Column(name = "khoa_id")
    private String khoa_id;
    @Column(name = "masv")
    private String masv;

}
