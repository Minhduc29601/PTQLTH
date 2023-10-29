package com.devpro.javaweb22.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "khoa")
public class Khoa extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "ma_khoa")
    private String ma_khoa;
    @Column(name = "ten_khoa")
    private String ten_khoa;
}
