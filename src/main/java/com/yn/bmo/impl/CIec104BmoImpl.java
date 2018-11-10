package com.yn.bmo.impl;

import com.yn.bmo.ICIec104Bmo;
import com.yn.entity.CIec104;
import com.yn.entity.CIec104Example;
import com.yn.mapper.CIec104Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CIec104BmoImpl implements ICIec104Bmo {
    @Autowired
    private CIec104Mapper mapper;

    @Override
    public int countByExample(CIec104Example example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(CIec104Example example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String name) {
        return mapper.deleteByPrimaryKey(name);
    }

    @Override
    public int insert(CIec104 record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(CIec104 record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Map<String, Object>> selectByExample(CIec104Example example) {
        return mapper.selectByExample(example);
    }

    @Override
    public CIec104 selectByPrimaryKey(String name) {
        return mapper.selectByPrimaryKey(name);
    }

    @Override
    public int updateByExampleSelective(CIec104 record, CIec104Example example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(CIec104 record, CIec104Example example) {
        return mapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(CIec104 record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CIec104 record) {
        return mapper.updateByPrimaryKey(record);
    }
}
