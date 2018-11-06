package com.yn.bmo.impl;

import com.yn.bmo.ICModbusRtuBmo;
import com.yn.entity.CModbusRtu;
import com.yn.entity.CModbusRtuExample;
import com.yn.mapper.CModbusRtuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CModbusRtuBmoImpl implements ICModbusRtuBmo {
    @Autowired
    private CModbusRtuMapper mapper;
    @Override
    public int countByExample(CModbusRtuExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(CModbusRtuExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String name) {
        return mapper.deleteByPrimaryKey(name);
    }

    @Override
    public int insert(CModbusRtu record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(CModbusRtu record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Map<String, Object>> selectByExample(CModbusRtuExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public CModbusRtu selectByPrimaryKey(String name) {
        return mapper.selectByPrimaryKey(name);
    }

    @Override
    public int updateByExampleSelective(CModbusRtu record, CModbusRtuExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(CModbusRtu record, CModbusRtuExample example) {
        return mapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(CModbusRtu record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CModbusRtu record) {
        return mapper.updateByPrimaryKey(record);
    }
}
