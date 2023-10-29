package com.devpro.javaweb22.services;

import com.devpro.javaweb22.model.GiangVien;
import com.devpro.javaweb22.model.SinhVien;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends BaseService<SinhVien> {
    @Override
    protected Class<SinhVien> clazz() {
        return SinhVien.class;
    }
}
