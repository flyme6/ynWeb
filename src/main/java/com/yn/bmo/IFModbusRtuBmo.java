package com.yn.bmo;

import com.yn.entity.FModbusRtu;
import com.yn.entity.FModbusRtuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IFModbusRtuBmo {
    int countByExample(FModbusRtuExample example);

    int deleteByExample(FModbusRtuExample example);

    int deleteByPrimaryKey(String name);

    int insert(FModbusRtu record);

    int insertSelective(FModbusRtu record);

    List<Map<String, Object>> selectByExample(FModbusRtuExample example);

    FModbusRtu selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") FModbusRtu record, @Param("example") FModbusRtuExample example);

    int updateByExample(@Param("record") FModbusRtu record, @Param("example") FModbusRtuExample example);

    int updateByPrimaryKeySelective(FModbusRtu record);

    int updateByPrimaryKey(FModbusRtu record);
}
