package com.yn.mapper;

import com.yn.entity.General;
import com.yn.entity.GeneralExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GeneralMapper {
    int countByExample(GeneralExample example);

    int deleteByExample(GeneralExample example);

    int insert(General record);

    int insertSelective(General record);

    List<Map<String, Object>> selectByExample(GeneralExample example);

    int updateByExampleSelective(@Param("record") General record, @Param("example") GeneralExample example);

    int updateByExample(@Param("record") General record, @Param("example") GeneralExample example);
}