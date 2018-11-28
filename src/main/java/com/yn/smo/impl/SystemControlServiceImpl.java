package com.yn.smo.impl;

import com.yn.common.Constant;
import com.yn.common.Result;
import com.yn.smo.ISystemControlService;
import com.yn.util.ynService.SystemControllerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SystemControlServiceImpl implements ISystemControlService {
    private static final Logger log = LoggerFactory.getLogger(DataMonitorServiceImpl.class);

    @Override
    public Result newProject() {
        YNRPC.Result ynResult = SystemControllerUtil.newProject();
        Result result = new Result();
        try {

            result.addCode(Constant.CODE_QUERY_SUCCESS);
            result.addMsg(ynResult.toString());
            System.out.println(result);
        } catch (Exception e) {
            log.error("newProject", e);
            result.addMsg(e.getMessage());
        }
        return result;
    }

    @Override
    public Result saveProject() {
        YNRPC.Result ynResult = SystemControllerUtil.saveProject();
        Result result = new Result();
        try {

            result.addCode(Constant.CODE_QUERY_SUCCESS);
            result.addMsg(ynResult.toString());
            System.out.println(result);
        } catch (Exception e) {
            log.error("newProject", e);
            result.addMsg(e.getMessage());
        }
        return result;
    }

    @Override
    public Result exportProject() {
        YNRPC.Result ynResult = SystemControllerUtil.exportProject();
        Result result = new Result();
        try {
            result.addCode(Constant.CODE_QUERY_SUCCESS);
            result.addMsg(ynResult.toString());
            System.out.println(result);
        } catch (Exception e) {
            log.error("newProject", e);
            result.addMsg(e.getMessage());
        }
        return result;
    }

    @Override
    public Result importProject() {
        YNRPC.Result ynResult = SystemControllerUtil.importProject();
        Result result = new Result();
        try {
            result.addCode(Constant.CODE_QUERY_SUCCESS);
            result.addMsg(ynResult.toString());
            System.out.println(result);
        } catch (Exception e) {
            log.error("newProject", e);
            result.addMsg(e.getMessage());
        }
        return result;
    }

    @Override
    public Result checkProject() {
        YNRPC.Result ynResult = SystemControllerUtil.checkProject();
        Result result = new Result();
        try {
            result.addCode(Constant.CODE_QUERY_SUCCESS);
            result.addMsg(ynResult.toString());
            System.out.println(result);
        } catch (Exception e) {
            log.error("newProject", e);
            result.addMsg(e.getMessage());
        }
        return result;
    }

    @Override
    public Result startProject() {
        YNRPC.Result ynResult = SystemControllerUtil.startProject();
        Result result = new Result();
        try {
            result.addCode(Constant.CODE_QUERY_SUCCESS);
            result.addMsg(ynResult.toString());
            System.out.println(result);
        } catch (Exception e) {
            log.error("newProject", e);
            result.addMsg(e.getMessage());
        }
        return result;
    }

    @Override
    public Result stopProject() {
        YNRPC.Result ynResult = SystemControllerUtil.stopProject();
        Result result = new Result();
        try {
            result.addCode(Constant.CODE_QUERY_SUCCESS);
            result.addMsg(ynResult.toString());
            System.out.println(result);
        } catch (Exception e) {
            log.error("newProject", e);
            result.addMsg(e.getMessage());
        }
        return result;
    }

    @Override
    public Result rebootBox() {
        YNRPC.Result ynResult = SystemControllerUtil.rebootBox();
        Result result = new Result();
        try {
            result.addCode(Constant.CODE_QUERY_SUCCESS);
            result.addMsg(ynResult.toString());
            System.out.println(result);
        } catch (Exception e) {
            log.error("newProject", e);
            result.addMsg(e.getMessage());
        }
        return result;
    }
}
