package com.devpro.javaweb22.services;

import com.devpro.javaweb22.model.GiangVien;
import com.devpro.javaweb22.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class LecturerService extends BaseService<GiangVien> {
    @Override
    protected Class<GiangVien> clazz() {
        return GiangVien.class;
    }

    public GiangVien loadUserByUsername(String userName) {
        String sql = "select * from tbl_users u where u.username = '" + userName + "' and status = 1";
        return this.getEntityByNativeSQL(sql);
    }
}
