package com.yn.bmo.impl;

import com.yn.bmo.ICModbusTcpBmo;
import com.yn.entity.CModbusTcp;
import com.yn.entity.CModbusTcpExample;
import com.yn.mapper.CModbusTcpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author ：flyme
 * @ProjectName: ynWeb1.2
 * @Title : CModbusTcpBmoImpl
 * @Description：CModbusTcpDao层
 * @Date ：Created in 15:12 2018/10/31
 */
@Repository
public class CModbusTcpBmoImpl implements ICModbusTcpBmo {

    @Autowired
    private CModbusTcpMapper mapper;

    @Override
    public int countByExample(CModbusTcpExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(CModbusTcpExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String name) {
        return mapper.deleteByPrimaryKey(name);
    }

    @Override
    public int insert(CModbusTcp record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(CModbusTcp record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Map<String, Object>> selectByExample(CModbusTcpExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public CModbusTcp selectByPrimaryKey(String name) {
        return mapper.selectByPrimaryKey(name);
    }

    @Override
    public int updateByExampleSelective(CModbusTcp record, CModbusTcpExample example) {
        return mapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(CModbusTcp record, CModbusTcpExample example) {
        return mapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(CModbusTcp record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CModbusTcp record) {
        return mapper.updateByPrimaryKey(record);
    }
}
