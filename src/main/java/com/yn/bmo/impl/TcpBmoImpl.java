package com.yn.bmo.impl;

import com.yn.bmo.ITcpBmo;
import com.yn.entity.Tcp;
import com.yn.entity.TcpExample;
import com.yn.mapper.TcpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class TcpBmoImpl implements ITcpBmo {
    @Autowired
    private TcpMapper mapper;

    @Override
    public int countByExample(TcpExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(TcpExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String portNumber) {
        return mapper.deleteByPrimaryKey(portNumber);
    }

    @Override
    public int insert(Tcp record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Tcp record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Map<String, Object>> selectByExample(TcpExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public Tcp selectByPrimaryKey(String portNumber) {
        return mapper.selectByPrimaryKey(portNumber);
    }

    @Override
    public int updateByExampleSelective(Tcp record, TcpExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Tcp record, TcpExample example) {
        return mapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Tcp record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Tcp record) {
        return mapper.updateByPrimaryKey(record);
    }
}
