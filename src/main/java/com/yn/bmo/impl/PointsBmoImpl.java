package com.yn.bmo.impl;

import com.yn.bmo.IPointsBmo;
import com.yn.entity.Points;
import com.yn.entity.PointsExample;
import com.yn.mapper.PointsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PointsBmoImpl implements IPointsBmo {
    @Autowired
    private PointsMapper mapper;

    @Override
    public int countByExample(PointsExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(PointsExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String name) {
        return mapper.deleteByPrimaryKey(name);
    }

    @Override
    public int insert(Points record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Points record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Map<String, Object>> selectByExample(PointsExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public Points selectByPrimaryKey(String name) {
        return mapper.selectByPrimaryKey(name);
    }

    @Override
    public int updateByExampleSelective(Points record, PointsExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Points record, PointsExample example) {
        return mapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Points record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Points record) {
        return mapper.updateByPrimaryKey(record);
    }
}
