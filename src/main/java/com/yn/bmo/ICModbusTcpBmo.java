package com.yn.bmo;

import com.yn.entity.CModbusTcp;
import com.yn.entity.CModbusTcpExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author ：flyme
 * @ProjectName: ynWeb1.2
 * @Title : ICModbusTcpBmo
 * @Description：CModbusTcp接口层
 * @Date ：Created in 15:13 2018/10/31
 */

public interface ICModbusTcpBmo {
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
