package com.yn.smo.impl;

import com.yn.bmo.ICAbcipBmo;
import com.yn.common.Constant;
import com.yn.common.Result;
import com.yn.entity.CAbcip;
import com.yn.entity.CAbcipExample;
import com.yn.smo.ICAbcipService;
import com.yn.util.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CAbcipServiceImpl implements ICAbcipService {
    private static final Logger log = LoggerFactory.getLogger(CModbusRtuServiceImpl.class);

    @Autowired
    private ICAbcipBmo bmo;

    @Override
    public Result query(CAbcipExample example) {
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
            result = Result.getQueryFailResult(e);
        }
        return result;
    }

    @Override
    public Result save(CAbcip recod) {
        Result result = new Result();
        try {
            bmo.updateByPrimaryKey(recod);
            result = Result.getUpdateSuccessResult();
        } catch (Exception e) {
            log.error("save", e);
            result = Result.getUpdateFailResult(e);
            result.addMsg(e.toString());
        }
        return result;
    }

    @Override
    public Result add(CAbcip recod) {
        Result result = new Result();
        try {
            CAbcip recod2 = bmo.selectByPrimaryKey(recod.getName());
            boolean aNull = ObjectUtil.isNull(recod2);
            if (aNull) {
                int insert = bmo.insert(recod);
                if (insert > 0) {
                    result = Result.getAddSuccessResult();
                }
            } else {
                result = Result.getAddFailResult();
                result.addMsg("名称已存在");
            }
        } catch (Exception e) {
            log.error("add", e);
            result = Result.getAddFailResult(e);
        }
        return result;
    }

    @Override
    public Result del(CAbcip recod) {
        Result result = new Result();
        try {
            int i = bmo.deleteByPrimaryKey(recod.getName());
            if (i > 0) {
                result = Result.getDelSuccessResult();
            } else {
                result = Result.getDelFailResult();
            }

        } catch (Exception e) {
            log.error("del", e);
            result = Result.getDelFailResult();
            result.addMsg(e.toString());
        }
        return result;
    }
}
