package com.yn.mapper;

import com.yn.entity.CModbusTcp;
import com.yn.entity.CModbusTcpExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CModbusTcpMapper {
    int countByExample(CModbusTcpExample example);

    int deleteByExample(CModbusTcpExample example);

    int deleteByPrimaryKey(String name);

    int insert(CModbusTcp record);

    int insertSelective(CModbusTcp record);

    List<Map<String, Object>> selectByExample(CModbusTcpExample example);

    CModbusTcp selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") CModbusTcp record, @Param("example") CModbusTcpExample example);

    int updateByExample(@Param("record") CModbusTcp record, @Param("example") CModbusTcpExample example);

    int updateByPrimaryKeySelective(CModbusTcp record);

    int updateByPrimaryKey(CModbusTcp record);
}