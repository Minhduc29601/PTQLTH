package com.devpro.javaweb22.services;

import com.devpro.javaweb22.model.Diem;
import org.springframework.stereotype.Service;

@Service
public class ScoreService extends BaseService<Diem> {
    @Override
    protected Class<Diem> clazz() {
        return Diem.class;
    }
}
