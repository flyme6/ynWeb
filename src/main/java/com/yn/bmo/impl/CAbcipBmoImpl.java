package com.yn.bmo.impl;

import com.yn.bmo.ICAbcipBmo;
import com.yn.entity.CAbcip;
import com.yn.entity.CAbcipExample;
import com.yn.mapper.CAbcipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CAbcipBmoImpl implements ICAbcipBmo {
    @Autowired
    private CAbcipMapper mapper;

    @Override
    public int countByExample(CAbcipExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(CAbcipExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String name) {
        return mapper.deleteByPrimaryKey(name);
    }

    @Override
    public int insert(CAbcip record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(CAbcip record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Map<String, Object>> selectByExample(CAbcipExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public CAbcip selectByPrimaryKey(String name) {
        return mapper.selectByPrimaryKey(name);
    }

    @Override
    public int updateByExampleSelective(CAbcip record, CAbcipExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(CAbcip record, CAbcipExample example) {
        return mapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(CAbcip record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CAbcip record) {
        return mapper.updateByPrimaryKey(record);
    }
}
