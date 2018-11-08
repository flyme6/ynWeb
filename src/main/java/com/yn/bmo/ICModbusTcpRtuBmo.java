package com.yn.bmo;

import com.yn.entity.CModbusTcpRtu;
import com.yn.entity.CModbusTcpRtuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ICModbusTcpRtuBmo {
    int countByExample(CModbusTcpRtuExample example);

    int deleteByExample(CModbusTcpRtuExample example);

    int deleteByPrimaryKey(String name);

    int insert(CModbusTcpRtu record);

    int insertSelective(CModbusTcpRtu record);

    List<Map<String, Object>> selectByExample(CModbusTcpRtuExample example);

    CModbusTcpRtu selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") CModbusTcpRtu record, @Param("example") CModbusTcpRtuExample example);

    int updateByExample(@Param("record") CModbusTcpRtu record, @Param("example") CModbusTcpRtuExample example);

    int updateByPrimaryKeySelective(CModbusTcpRtu record);

    int updateByPrimaryKey(CModbusTcpRtu record);
}
