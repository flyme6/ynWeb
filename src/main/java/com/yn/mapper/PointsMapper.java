package com.yn.mapper;

import com.yn.entity.Points;
import com.yn.entity.PointsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PointsMapper {
    int countByExample(PointsExample example);

    int deleteByExample(PointsExample example);

    int deleteByPrimaryKey(String name);

    int insert(Points record);

    int insertDev();

    int insertSelective(Points record);

    List<Map<String, Object>> selectByExample(PointsExample example);

    List<Map<String, Object>> selectByDriver(PointsExample example);

    Points selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") Points record, @Param("example") PointsExample example);

    int updateByExample(@Param("record") Points record, @Param("example") PointsExample example);

    int updateByPrimaryKeySelective(Points record);

    int updateByPrimaryKey(Points record);
}