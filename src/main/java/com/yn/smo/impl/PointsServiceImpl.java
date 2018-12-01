package com.yn.smo.impl;

import com.yn.bmo.IDevBmo;
import com.yn.bmo.IPointsBmo;
import com.yn.common.Constant;
import com.yn.common.Result;
import com.yn.entity.Points;
import com.yn.entity.PointsExample;
import com.yn.smo.IPointsService;
import com.yn.util.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PointsServiceImpl implements IPointsService {
    private static final Logger log = LoggerFactory.getLogger(PointsServiceImpl.class);

    @Autowired
    private IPointsBmo bmo;
    @Autowired
    private IDevBmo devBmo;

    @Override
    public Result query(PointsExample example, Points recod) {
        Result result = new Result();
        try {
            List<Map<String, Object>> maps = bmo.selectByExample(example, recod);
            int total = bmo.countByExample(recod);
            log.info("total" + total);
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
    public Result query(Points recod) {
        Result result = new Result();
        try {
            List<Map<String, Object>> maps = bmo.queryByConditions(recod);
            int total = bmo.selectTotal(recod);
            log.info("total" + total);
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
    public Result queryDriver(Points recod) {
        Result result = new Result();
        try {
            List<Map<String, Object>> maps = bmo.queryByDriver(recod);
            int total = bmo.selectTotal(recod);
            log.info("total" + total);
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

//    @Override
//    public Result queryDriver(PointsExample example,Points recod) {
//        Result result = new Result();
//        try {
////            devBmo.insert();
//            List<Map<String, Object>> maps = bmo.selectByDriver(example);
//            int total = bmo.countByExample(recod);
//            log.info(total + "total");
//            result.addCode(Constant.CODE_QUERY_SUCCESS);
//            result.addMsg(Constant.MSG_QUERY_SUCCESS);
//            result.addCount(total);
//            result.addData(maps);
//        } catch (Exception e) {
//            log.error("query", e);
//            result.addMsg(e.getMessage());
//        }
//        return result;
//    }

    @Override
    public Result save(Points recod) {
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
    public Result add(Points recod) {
        Result result = new Result();
        try {
            Points recod2 = bmo.selectByPrimaryKey(recod.getName());
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
    public Result del(Points recod) {
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
            result = Result.getDelFailResult(e);
        }
        return result;
    }
}
