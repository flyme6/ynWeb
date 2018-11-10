package com.yn.mapper;

import com.yn.entity.CAbcip;
import com.yn.entity.CAbcipExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CAbcipMapper {
    int countByExample(CAbcipExample example);

    int deleteByExample(CAbcipExample example);

    int deleteByPrimaryKey(String name);

    int insert(CAbcip record);

    int insertSelective(CAbcip record);

    List<Map<String, Object>> selectByExample(CAbcipExample example);

    CAbcip selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") CAbcip record, @Param("example") CAbcipExample example);

    int updateByExample(@Param("record") CAbcip record, @Param("example") CAbcipExample example);

    int updateByPrimaryKeySelective(CAbcip record);

    int updateByPrimaryKey(CAbcip record);
}