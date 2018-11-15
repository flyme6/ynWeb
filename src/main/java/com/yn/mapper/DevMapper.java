package com.yn.mapper;

import com.yn.entity.Dev;
import com.yn.entity.DevExample;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;

public interface DevMapper {
    int countByExample(DevExample example);

    int deleteByExample(DevExample example);

//    int insert(Dev record);

    int insertSelective(Dev record);

    List<Dev> selectByExample(DevExample example);

    int updateByExampleSelective(@Param("record") Dev record, @Param("example") DevExample example);

    int updateByExample(@Param("record") Dev record, @Param("example") DevExample example);

    List<LinkedHashMap<String, Object>> select(String sql);

    int insert(String sql);

    int update(String sql);

    int delete(String sql);
}