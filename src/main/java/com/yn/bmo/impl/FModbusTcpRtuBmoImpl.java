package com.yn.bmo.impl;

import com.yn.bmo.IFModbusTcpRtuBmo;
import com.yn.entity.FModbusTcpRtu;
import com.yn.entity.FModbusTcpRtuExample;
import com.yn.mapper.FModbusTcpRtuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class FModbusTcpRtuBmoImpl implements IFModbusTcpRtuBmo {
    @Autowired
    private FModbusTcpRtuMapper mapper;
    @Override
    public int countByExample(FModbusTcpRtuExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(FModbusTcpRtuExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String name) {
        return mapper.deleteByPrimaryKey(name);
    }

    @Override
    public int insert(FModbusTcpRtu record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(FModbusTcpRtu record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Map<String, Object>> selectByExample(FModbusTcpRtuExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public FModbusTcpRtu selectByPrimaryKey(String name) {
        return mapper.selectByPrimaryKey(name);
    }

    @Override
    public int updateByExampleSelective(FModbusTcpRtu record, FModbusTcpRtuExample example) {
        return mapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(FModbusTcpRtu record, FModbusTcpRtuExample example) {
        return mapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(FModbusTcpRtu record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FModbusTcpRtu record) {
        return mapper.updateByPrimaryKey(record);
    }
}
