package com.yn.bmo.impl;

import com.yn.bmo.ICModbusTcpRtuBmo;
import com.yn.entity.CModbusTcpRtu;
import com.yn.entity.CModbusTcpRtuExample;
import com.yn.mapper.CModbusTcpMapper;
import com.yn.mapper.CModbusTcpRtuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CModbusTcpRtuBmoImpl implements ICModbusTcpRtuBmo {

    @Autowired
    private CModbusTcpRtuMapper mapper;

    @Override
    public int countByExample(CModbusTcpRtuExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(CModbusTcpRtuExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String name) {
        return mapper.deleteByPrimaryKey(name);
    }

    @Override
    public int insert(CModbusTcpRtu record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(CModbusTcpRtu record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Map<String, Object>> selectByExample(CModbusTcpRtuExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public CModbusTcpRtu selectByPrimaryKey(String name) {
        return mapper.selectByPrimaryKey(name);
    }

    @Override
    public int updateByExampleSelective(CModbusTcpRtu record, CModbusTcpRtuExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(CModbusTcpRtu record, CModbusTcpRtuExample example) {
        return mapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(CModbusTcpRtu record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CModbusTcpRtu record) {
        return mapper.updateByPrimaryKey(record);
    }
}
