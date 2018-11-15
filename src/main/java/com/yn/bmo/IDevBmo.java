package com.yn.bmo;

import com.yn.entity.Dev;

import java.util.LinkedHashMap;
import java.util.List;

public interface IDevBmo {

    List<LinkedHashMap<String, Object>> select(String sql);

    int insert(String sql);

    int update(String sql);

    int delete(String sql);

}
