package com.devpro.javaweb22.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "khu_vuc")
public class KhuVuc extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "ma_khu_vuc")
    private String ma_khu_vuc;
    @Column(name = "ten_khu_vuc")
    private String ten_khu_vuc;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "khuVuc")
    private List<User> users = new ArrayList<>();
}
