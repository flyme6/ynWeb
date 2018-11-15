package com.yn.smo.impl;

import com.yn.bmo.IDevBmo;
import com.yn.common.Result;
import com.yn.smo.IDevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevServiceImpl implements IDevService {
    @Autowired
    private IDevBmo bmo;

    @Override
    public Result add() {
        Result result = new Result();
        try {
            String sql = "INSERT INTO dev ( dev_name ) SELECT DISTINCT c_dev FROM points;";
            String sql2 = "INSERT INTO dev ( dev_name ) SELECT DISTINCT f_dev FROM points;";
            int insert = bmo.insert(sql);
            int insert2 = bmo.insert(sql2);
            result.addMsg("获取成功");
        } catch (Exception e) {
            result.addMsg("获取失败" + e);
            return result;
        }

        return result;
    }

    @Override
    public Result del() {
        Result result = new Result();
        try {
            String sql = "delete from dev";
            int insert = bmo.delete(sql);
        } catch (Exception e) {
            result.addMsg("清空表失败" + e);
            return Result.getAddFailResult();
        }
        result.addMsg("清空表成功");
        return result;
    }
}
