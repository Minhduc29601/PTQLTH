package com.devpro.javaweb22.services;

import com.devpro.javaweb22.model.Khoa;
import com.devpro.javaweb22.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FacultyService extends BaseService<Khoa>{
    @Override
    protected Class<Khoa> clazz() {
        return Khoa.class;
    }


}
