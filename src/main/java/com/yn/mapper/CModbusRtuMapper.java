package com.yn.mapper;

import com.yn.entity.CModbusRtu;
import com.yn.entity.CModbusRtuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CModbusRtuMapper {
    int countByExample(CModbusRtuExample example);

    int deleteByExample(CModbusRtuExample example);

    int deleteByPrimaryKey(String name);

    int insert(CModbusRtu record);

    int insertSelective(CModbusRtu record);

    List<Map<String, Object>> selectByExample(CModbusRtuExample example);

    CModbusRtu selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") CModbusRtu record, @Param("example") CModbusRtuExample example);

    int updateByExample(@Param("record") CModbusRtu record, @Param("example") CModbusRtuExample example);

    int updateByPrimaryKeySelective(CModbusRtu record);

    int updateByPrimaryKey(CModbusRtu record);
}