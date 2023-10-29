package com.devpro.javaweb22.services;

import com.devpro.javaweb22.model.KhuVuc;
import org.springframework.stereotype.Service;

@Service
public class LocationService extends BaseService<KhuVuc>{
    @Override
    protected Class<KhuVuc> clazz() {
        return KhuVuc.class;
    }
}
