package com.yn.bmo.impl;

import com.yn.bmo.IFModbusTcpBmo;
import com.yn.entity.FModbusTcp;
import com.yn.entity.FModbusTcpExample;
import com.yn.mapper.FModbusTcpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class FModbusTcpBmoImpl implements IFModbusTcpBmo {
    @Autowired
    private FModbusTcpMapper mapper;

    @Override
    public int countByExample(FModbusTcpExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(FModbusTcpExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String name) {
        return mapper.deleteByPrimaryKey(name);
    }

    @Override
    public int insert(FModbusTcp record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(FModbusTcp record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Map<String, Object>> selectByExample(FModbusTcpExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public FModbusTcp selectByPrimaryKey(String name) {
        return mapper.selectByPrimaryKey(name);
    }

    @Override
    public int updateByExampleSelective(FModbusTcp record, FModbusTcpExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(FModbusTcp record, FModbusTcpExample example) {
        return mapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(FModbusTcp record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FModbusTcp record) {
        return mapper.updateByPrimaryKey(record);
    }
}
