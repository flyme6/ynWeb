package com.yn.mapper;

import com.yn.entity.CIec104;
import com.yn.entity.CIec104Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CIec104Mapper {
    int countByExample(CIec104Example example);

    int deleteByExample(CIec104Example example);

    int deleteByPrimaryKey(String name);

    int insert(CIec104 record);

    int insertSelective(CIec104 record);

    List<Map<String, Object>> selectByExample(CIec104Example example);

    CIec104 selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") CIec104 record, @Param("example") CIec104Example example);

    int updateByExample(@Param("record") CIec104 record, @Param("example") CIec104Example example);

    int updateByPrimaryKeySelective(CIec104 record);

    int updateByPrimaryKey(CIec104 record);
}