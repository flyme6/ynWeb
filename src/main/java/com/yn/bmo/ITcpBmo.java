package com.yn.bmo;

import com.yn.entity.Tcp;
import com.yn.entity.TcpExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ITcpBmo {
    int countByExample(TcpExample example);

    int deleteByExample(TcpExample example);

    int deleteByPrimaryKey(String portNumber);

    int insert(Tcp record);

    int insertSelective(Tcp record);

    List<Map<String, Object>> selectByExample(TcpExample example);

    Tcp selectByPrimaryKey(String portNumber);

    int updateByExampleSelective(@Param("record") Tcp record, @Param("example") TcpExample example);

    int updateByExample(@Param("record") Tcp record, @Param("example") TcpExample example);

    int updateByPrimaryKeySelective(Tcp record);

    int updateByPrimaryKey(Tcp record);
}
