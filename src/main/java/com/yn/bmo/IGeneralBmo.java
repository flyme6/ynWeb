package com.yn.bmo;

import com.yn.entity.General;
import com.yn.entity.GeneralExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IGeneralBmo {
    int countByExample(GeneralExample example);

    int deleteByExample(GeneralExample example);

    //    int deleteByPrimaryKey(String name);
    int insert(General record);

    int insertSelective(General record);

    List<Map<String, Object>> selectByExample(GeneralExample example);

    //    General selectByPrimaryKey(String name);
    int updateByExampleSelective(@Param("record") General record, @Param("example") GeneralExample example);

    int updateByExample(@Param("record") General record, @Param("example") GeneralExample example);
//    int updateByPrimaryKeySelective(General record);
//    int updateByPrimaryKey(General record);
}
