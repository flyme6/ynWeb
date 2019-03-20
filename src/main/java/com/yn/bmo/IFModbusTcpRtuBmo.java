package com.yn.bmo;

import com.yn.entity.FModbusTcpRtu;
import com.yn.entity.FModbusTcpRtuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IFModbusTcpRtuBmo {
    int countByExample(FModbusTcpRtuExample example);

    int deleteByExample(FModbusTcpRtuExample example);

    int deleteByPrimaryKey(String name);

    int insert(FModbusTcpRtu record);

    int insertSelective(FModbusTcpRtu record);

    List<Map<String, Object>> selectByExample(FModbusTcpRtuExample example);

    FModbusTcpRtu selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") FModbusTcpRtu record, @Param("example") FModbusTcpRtuExample example);

    int updateByExample(@Param("record") FModbusTcpRtu record, @Param("example") FModbusTcpRtuExample example);

    int updateByPrimaryKeySelective(FModbusTcpRtu record);

    int updateByPrimaryKey(FModbusTcpRtu record);
}
