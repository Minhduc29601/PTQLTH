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
    private String maVaTenMonHoc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "khoa_id")
    private Khoa khoa;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "monHoc")
    private List<Diem> diems = new ArrayList<>();
    public String getMaVaTenMonHoc() {
        return ma_mon_hoc + " - " + ten_mon_hoc;
    }

    public void setMaVaTenMonHoc(String maVaTenMonHoc) {
        this.maVaTenMonHoc = maVaTenMonHoc;
    }
}
