package com.devpro.javaweb22.services;

import com.devpro.javaweb22.model.GiangVien;
import com.devpro.javaweb22.model.MonHoc;
import com.devpro.javaweb22.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SubjectService extends BaseService<MonHoc> {
    @Override
    protected Class<MonHoc> clazz() {
        return MonHoc.class;
    }


}
