package com.devpro.javaweb22.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "mon_hoc")
public class MonHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "ma_mon_hoc")
    private String ma_mon_hoc;
    @Column(name = "ten_mon_hoc")
    private String ten_mon_hoc;
    @Column(name = "khoa_id")
    private String khoa_id;
}
