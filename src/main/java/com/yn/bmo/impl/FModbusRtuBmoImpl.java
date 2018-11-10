package com.yn.bmo.impl;

import com.yn.bmo.IFModbusRtuBmo;
import com.yn.entity.FModbusRtu;
import com.yn.entity.FModbusRtuExample;
import com.yn.mapper.FModbusRtuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class FModbusRtuBmoImpl implements IFModbusRtuBmo {
    @Autowired
    private FModbusRtuMapper mapper;

    @Override
    public int countByExample(FModbusRtuExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(FModbusRtuExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String name) {
        return mapper.deleteByPrimaryKey(name);
    }

    @Override
    public int insert(FModbusRtu record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(FModbusRtu record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Map<String, Object>> selectByExample(FModbusRtuExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public FModbusRtu selectByPrimaryKey(String name) {
        return mapper.selectByPrimaryKey(name);
    }

    @Override
    public int updateByExampleSelective(FModbusRtu record, FModbusRtuExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(FModbusRtu record, FModbusRtuExample example) {
        return mapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(FModbusRtu record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FModbusRtu record) {
        return mapper.updateByPrimaryKey(record);
    }
}
