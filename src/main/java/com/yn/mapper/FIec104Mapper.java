package com.yn.mapper;

import com.yn.entity.FIec104;
import com.yn.entity.FIec104Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FIec104Mapper {
    int countByExample(FIec104Example example);

    int deleteByExample(FIec104Example example);

    int deleteByPrimaryKey(String name);

    int insert(FIec104 record);

    int insertSelective(FIec104 record);

    List<Map<String, Object>> selectByExample(FIec104Example example);

    FIec104 selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") FIec104 record, @Param("example") FIec104Example example);

    int updateByExample(@Param("record") FIec104 record, @Param("example") FIec104Example example);

    int updateByPrimaryKeySelective(FIec104 record);

    int updateByPrimaryKey(FIec104 record);
}