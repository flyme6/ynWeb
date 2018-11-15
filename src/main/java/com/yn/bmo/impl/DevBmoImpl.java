package com.yn.bmo.impl;

import com.yn.bmo.IDevBmo;
import com.yn.mapper.DevMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;

@Repository
public class DevBmoImpl implements IDevBmo {
    @Autowired
    private DevMapper mapper;

    @Override
    public List<LinkedHashMap<String, Object>> select(String sql) {
        return mapper.select(sql);
    }

    @Override
    public int insert(String sql) {
        return mapper.insert(sql);
    }

    @Override
    public int update(String sql) {
        return mapper.update(sql);
    }

    @Override
    public int delete(String sql) {
        return mapper.delete(sql);
    }
}
