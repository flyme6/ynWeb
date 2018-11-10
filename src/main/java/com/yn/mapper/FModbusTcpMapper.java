package com.yn.mapper;

import com.yn.entity.FModbusTcp;
import com.yn.entity.FModbusTcpExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FModbusTcpMapper {
    int countByExample(FModbusTcpExample example);

    int deleteByExample(FModbusTcpExample example);

    int deleteByPrimaryKey(String name);

    int insert(FModbusTcp record);

    int insertSelective(FModbusTcp record);

    List<Map<String, Object>> selectByExample(FModbusTcpExample example);

    FModbusTcp selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") FModbusTcp record, @Param("example") FModbusTcpExample example);

    int updateByExample(@Param("record") FModbusTcp record, @Param("example") FModbusTcpExample example);

    int updateByPrimaryKeySelective(FModbusTcp record);

    int updateByPrimaryKey(FModbusTcp record);
}