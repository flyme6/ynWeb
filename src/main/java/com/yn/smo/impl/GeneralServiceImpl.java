package com.yn.smo.impl;

import com.yn.bmo.IGeneralBmo;
import com.yn.common.Constant;
import com.yn.common.Result;
import com.yn.entity.General;
import com.yn.entity.GeneralExample;
import com.yn.smo.IGeneralService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GeneralServiceImpl implements IGeneralService {
    private static final Logger log = LoggerFactory.getLogger(GeneralServiceImpl.class);
    @Autowired
    private IGeneralBmo bmo;

    @Override
    public Result query(GeneralExample example) {
        Result result = new Result();
        try {
            List<Map<String, Object>> maps = bmo.selectByExample(example);
            int total = bmo.countByExample(example);
            System.out.println(total + "total");
            result.addCode(Constant.CODE_QUERY_SUCCESS);
            result.addMsg(Constant.MSG_QUERY_SUCCESS);
            result.addCount(total);
            result.addData(maps);
        } catch (Exception e) {
            log.error("query", e);
            result.addMsg(e.getMessage());
        }
        return result;
    }

    @Override
    public Result save(General recod, GeneralExample example) {
        Result result = new Result();
        try {
            bmo.updateByExample(recod, example);
            result = Result.getUpdateSuccessResult();
        } catch (Exception e) {
            log.error("save", e);
            result = Result.getUpdateFailResult(e);
            result.addMsg(e.toString());
        }
        return result;
    }

    @Override
    public Result add(General recod, GeneralExample example) {
        Result result = new Result();
        try {
            List<Map<String, Object>> maps = bmo.selectByExample(example);
            int size = maps.size();
            log.info("maps.size()", size);
//            boolean aNull = ObjectUtil.isNull(maps);
            if (size == 1 || size > 1) {
                result = Result.getAddFailResult();
                result.addMsg("配置失败，配置表中存在1行或者多行数据");
            } else {
                int insert = bmo.insert(recod);
                if (insert > 0) {
                    result = Result.getAddSuccessResult();
                }
            }
        } catch (Exception e) {
            log.error("add", e);
            result = Result.getAddFailResult();
            result.addMsg(e.toString());
        }
        return result;
    }

    @Override
    public Result del(GeneralExample example) {
        Result result = new Result();
        try {
            int i = bmo.deleteByExample(example);
            if (i > 0) {
                result = Result.getDelSuccessResult();
            } else {
                result = Result.getDelFailResult();
            }

        } catch (Exception e) {
            log.error("del", e);
            result = Result.getDelFailResult(e);
        }
        return result;
    }
}
