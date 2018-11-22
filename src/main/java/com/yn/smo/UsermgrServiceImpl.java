package com.yn.smo;

import com.yn.bmo.ITcpBmo;
import com.yn.bmo.IUsermgrBmo;
import com.yn.common.Constant;
import com.yn.common.Result;
import com.yn.entity.Tcp;
import com.yn.entity.Usermgr;
import com.yn.entity.UsermgrExample;
import com.yn.smo.impl.TcpServiceImpl;
import com.yn.util.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UsermgrServiceImpl implements IUsermgrService {
    private static final Logger log = LoggerFactory.getLogger(UsermgrServiceImpl.class);

    @Autowired
    private IUsermgrBmo bmo;

    @Override
    public Result query(UsermgrExample example) {
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
    public Result query(Usermgr recod) {
        Result result = new Result();
        try {
            Usermgr usermgr = bmo.selectByPrimaryKey(recod.getUsername());
            if (ObjectUtil.isNotNull(usermgr)) {
                if (recod.getUsername().equals(usermgr.getUsername())) {
                    if (recod.getPassword().equals(usermgr.getPassword())) {
                        result.addMsg("登录成功");
                        result.addCode(501);
                        result.addData(usermgr.getRole());
                    } else {
                        result.addMsg("请检查密码是否输入正确");
                        result.addCode(502);
                    }
                }
            } else {
                result.addMsg("请检查用户名");
                result.addCode(500);
            }
        } catch (Exception e) {
            log.error("query", e);
            result.addMsg(e.getMessage());
        }
        return result;
    }

    @Override
    public Result save(Usermgr recod) {
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
    public Result add(Usermgr recod) {
        Result result = new Result();
        try {
            Usermgr recod2 = bmo.selectByPrimaryKey(recod.getUsername());
            boolean aNull = ObjectUtil.isNull(recod2);
            if (aNull) {
                int insert = bmo.insert(recod);
                if (insert > 0) {
                    result = Result.getAddSuccessResult();
                }
            } else {
                result = Result.getAddFailResult();
                result.addMsg("用户已存在");
            }
        } catch (Exception e) {
            log.error("add", e);
            result = Result.getAddFailResult();
            result.addMsg(e.toString());
        }
        return result;
    }

    @Override
    public Result del(Usermgr recod) {
        Result result = new Result();
        try {
            int i = bmo.deleteByPrimaryKey(recod.getUsername());
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
