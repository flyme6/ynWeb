package com.yn.bmo.impl;

import com.yn.bmo.IGeneralBmo;
import com.yn.entity.General;
import com.yn.entity.GeneralExample;
import com.yn.mapper.GeneralMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class GeneralBmoImpl implements IGeneralBmo {
    @Autowired
    private GeneralMapper mapper;
    @Override
    public int countByExample(GeneralExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(GeneralExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int insert(General record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(General record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Map<String, Object>> selectByExample(GeneralExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(General record, GeneralExample example) {
        return mapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(General record, GeneralExample example) {
        return mapper.updateByExample(record,example);
    }
}
