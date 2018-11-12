package com.yn.bmo;

import com.yn.entity.Com;
import com.yn.entity.ComExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IComBmo {
    int countByExample(ComExample example);

    int deleteByExample(ComExample example);

    int deleteByPrimaryKey(Integer portNumber);

    int insert(Com record);

    int insertSelective(Com record);

    List<Map<String, Object>> selectByExample(ComExample example);

    Com selectByPrimaryKey(Integer portNumber);

    int updateByExampleSelective(@Param("record") Com record, @Param("example") ComExample example);

    int updateByExample(@Param("record") Com record, @Param("example") ComExample example);

    int updateByPrimaryKeySelective(Com record);

    int updateByPrimaryKey(Com record);
}
