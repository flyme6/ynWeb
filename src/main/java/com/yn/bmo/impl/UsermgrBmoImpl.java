package com.yn.bmo.impl;

import com.yn.bmo.IUsermgrBmo;
import com.yn.entity.Usermgr;
import com.yn.entity.UsermgrExample;
import com.yn.mapper.UsermgrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UsermgrBmoImpl implements IUsermgrBmo {
    @Autowired
    private UsermgrMapper mapper;

    @Override
    public int countByExample(UsermgrExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UsermgrExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String username) {
        return mapper.deleteByPrimaryKey(username);
    }

    @Override
    public int insert(Usermgr record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Usermgr record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Map<String, Object>> selectByExample(UsermgrExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public Usermgr selectByPrimaryKey(String username) {
        return mapper.selectByPrimaryKey(username);
    }

    @Override
    public int updateByExampleSelective(Usermgr record, UsermgrExample example) {
        return mapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Usermgr record, UsermgrExample example) {
        return mapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Usermgr record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Usermgr record) {
        return mapper.updateByPrimaryKey(record);
    }
}
