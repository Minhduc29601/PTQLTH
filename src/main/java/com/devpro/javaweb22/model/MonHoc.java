package com.devpro.javaweb22.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "mon_hoc")
public class MonHoc extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "ma_mon_hoc")
    private String ma_mon_hoc;
    @Column(name = "ten_mon_hoc")
    private String ten_mon_hoc;
    @Column(name = "khoa_id")
    private String khoa_id;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "monHoc")
    private List<Diem> diems = new ArrayList<>();
}
