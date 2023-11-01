package com.devpro.javaweb22.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "diem")
public class Diem extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "diem_so")
    private Float diem_so;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sinh_vien_id")
    private SinhVien sinhVien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mon_hoc_id")
    private MonHoc monHoc;

    public SinhVien getStudents() {
        return sinhVien;
    }

    public MonHoc getSubjects() {
        return monHoc;
    }

    public void setStudents(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public void setSubjects(MonHoc monHoc) {
        this.monHoc = monHoc;
    }
}
