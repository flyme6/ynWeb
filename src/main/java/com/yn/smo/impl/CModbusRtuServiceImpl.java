package com.yn.smo.impl;

import com.yn.bmo.ICModbusRtuBmo;
import com.yn.common.Constant;
import com.yn.common.Result;
import com.yn.entity.CModbusRtu;
import com.yn.entity.CModbusRtuExample;
import com.yn.smo.ICModbusRtuService;
import com.yn.util.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CModbusRtuServiceImpl implements ICModbusRtuService {
    private static final Logger log = LoggerFactory.getLogger(CModbusRtuServiceImpl.class);

    @Autowired
    private ICModbusRtuBmo bmo;

    @Override
    public Result query(CModbusRtuExample example) {
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
            log.error("com/yn/smo/impl/CModbusTcpServiceImpl.java", e);
            result.addMsg(e.getMessage());
        }
        return result;
    }

    @Override
    public Result save(CModbusRtu recod) {
        Result result = new Result();
        try {
            bmo.updateByPrimaryKey(recod);
            result = Result.getUpdateSuccessResult();
        } catch (Exception e) {
            log.error("com/yn/smo/impl/CModbusTcpServiceImpl.java", e);
            result = Result.getUpdateFailResult(e);
            result.addMsg(e.toString());
        }
        return result;
    }

    @Override
    public Result add(CModbusRtu recod) {
        Result result = new Result();
        try {
            CModbusRtu recod2 = bmo.selectByPrimaryKey(recod.getName());
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
            log.error("com/yn/smo/impl/CModbusTcpServiceImpl.java", e);
            result = Result.getAddFailResult();
            result.addMsg(e.toString());
        }
        return result;
    }

    @Override
    public Result del(CModbusRtu recod) {
        Result result = new Result();
        try {
            int i = bmo.deleteByPrimaryKey(recod.getName());
            if (i > 0) {
                result = Result.getDelSuccessResult();
            } else {
                result = Result.getDelFailResult();
            }

        } catch (Exception e) {
            log.error("com/yn/smo/impl/CModbusTcpServiceImpl.java", e);
            result = Result.getDelFailResult();
            result.addMsg(e.toString());
        }
        return result;
    }
}
