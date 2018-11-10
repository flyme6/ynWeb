package com.yn.bmo.impl;

import com.yn.bmo.IFIec104Bmo;
import com.yn.entity.FIec104;
import com.yn.entity.FIec104Example;
import com.yn.mapper.FIec104Mapper;
import org.omg.CORBA.MARSHAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class FIec104BmoImpl implements IFIec104Bmo {
    @Autowired
    private FIec104Mapper mapper;

    @Override
    public int countByExample(FIec104Example example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(FIec104Example example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String name) {
        return mapper.deleteByPrimaryKey(name);
    }

    @Override
    public int insert(FIec104 record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(FIec104 record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Map<String, Object>> selectByExample(FIec104Example example) {
        return mapper.selectByExample(example);
    }

    @Override
    public FIec104 selectByPrimaryKey(String name) {
        return mapper.selectByPrimaryKey(name);
    }

    @Override
    public int updateByExampleSelective(FIec104 record, FIec104Example example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(FIec104 record, FIec104Example example) {
        return mapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(FIec104 record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FIec104 record) {
        return mapper.updateByPrimaryKey(record);
    }
}
