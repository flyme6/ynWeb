package com.yn.smo.impl;

import com.yn.bmo.IComBmo;
import com.yn.common.Constant;
import com.yn.common.Result;
import com.yn.entity.Com;
import com.yn.entity.ComExample;
import com.yn.smo.IComService;
import com.yn.util.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ComServiceImpl implements IComService {
    private static final Logger log = LoggerFactory.getLogger(PointsServiceImpl.class);

    @Autowired
    private IComBmo bmo;

    @Override
    public Result query(ComExample example) {
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
    public Result save(Com recod) {
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
    public Result add(Com recod) {
        Result result = new Result();
        try {
            Com recod2 = bmo.selectByPrimaryKey(recod.getPortNumber());
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
            result = Result.getAddFailResult();
            result.addMsg(e.toString());
        }
        return result;
    }

    @Override
    public Result del(Com recod) {
        Result result = new Result();
        try {
            int i = bmo.deleteByPrimaryKey(recod.getPortNumber());
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
