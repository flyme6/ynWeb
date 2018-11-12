package com.yn.bmo.impl;

import com.yn.bmo.IComBmo;
import com.yn.entity.Com;
import com.yn.entity.ComExample;
import com.yn.mapper.ComMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ComBmoImpl implements IComBmo {
    @Autowired
    private ComMapper mapper;

    @Override
    public int countByExample(ComExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ComExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer portNumber) {
        return mapper.deleteByPrimaryKey(portNumber);
    }

    @Override
    public int insert(Com record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Com record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Map<String, Object>> selectByExample(ComExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public Com selectByPrimaryKey(Integer portNumber) {
        return mapper.selectByPrimaryKey(portNumber);
    }

    @Override
    public int updateByExampleSelective(Com record, ComExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Com record, ComExample example) {
        return mapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Com record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Com record) {
        return mapper.updateByPrimaryKey(record);
    }
}
