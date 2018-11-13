package com.yn.bmo;

import com.yn.entity.Usermgr;
import com.yn.entity.UsermgrExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IUsermgrBmo {
    int countByExample(UsermgrExample example);

    int deleteByExample(UsermgrExample example);

    int deleteByPrimaryKey(String username);

    int insert(Usermgr record);

    int insertSelective(Usermgr record);

    List<Map<String, Object>> selectByExample(UsermgrExample example);

    Usermgr selectByPrimaryKey(String username);

    int updateByExampleSelective(@Param("record") Usermgr record, @Param("example") UsermgrExample example);

    int updateByExample(@Param("record") Usermgr record, @Param("example") UsermgrExample example);

    int updateByPrimaryKeySelective(Usermgr record);

    int updateByPrimaryKey(Usermgr record);
}
