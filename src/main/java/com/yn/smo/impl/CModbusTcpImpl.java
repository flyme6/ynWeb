package com.yn.smo.impl;

import com.yn.bmo.ICModbusTcpBmo;
import com.yn.common.Constant;
import com.yn.common.Result;
import com.yn.entity.CModbusTcp;
import com.yn.entity.CModbusTcpExample;
import com.yn.smo.ICModbusTcpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ：flyme
 * @ProjectName: ynWeb1.2
 * @Title : CModbusTcpImpl
 * @Description：CModbusTcp接口实现层
 * @Date ：Created in 15:07 2018/10/31
 */
@Service
public class CModbusTcpImpl implements ICModbusTcpService {
    private static final Logger log = LoggerFactory.getLogger(CModbusTcpImpl.class);

    @Autowired
    private ICModbusTcpBmo icModbusTcpBmo;

    @Override
    public Result queryICModbusTcp(CModbusTcpExample cModbusTcp) {
        Result result = new Result();
        try {
            List<Map<String, Object>> maps = icModbusTcpBmo.selectByExample(cModbusTcp);
//            List<Map<String, Object>> points = cModbusTcps;
            int total = icModbusTcpBmo.countByExample(cModbusTcp);
            System.out.println(total + "total");
//            Map<String,Object> map = new HashMap<>();
//            map.put("total", total);
//            map.put("rows", maps);
            result.addCode(Constant.CODE_QUERY_SUCCESS);
            result.addMsg(Constant.MSG_QUERY_SUCCESS);
            result.addCount(total);
            result.addData(maps);

        } catch (Exception e) {
            log.error("AuditLabelServiceImpl.queryAuditLabel error:{}", e.getMessage());
//            result.addMsg(e.getMessage());
//            result.addStatus("60020");
//
//            AuditException auditException=new AuditException();
//            auditException.setId(CommonUtils.generateId());
//            auditException.setErrorType("查询");
//            auditException.setErrorContent("AuditLabelServiceImpl.queryAuditLabel error:"+e.getMessage());
//            auditException.setCreateDate(new Date());
//            auditException.setSystem("平衡性组件-web应用");
//            auditException.setErrorClass("AuditLabelServiceImpl");
//            auditExceptionBmo.insertSelective(auditException);
        }
        return result;
    }

    @Override
    public Result saveICModbusTcp(CModbusTcp cModbusTcp) {
        Result result = new Result();
        try {
            icModbusTcpBmo.updateByPrimaryKey(cModbusTcp);
            result = Result.getUpdateSuccessResult();
        } catch (Exception e) {
            log.error("CModbusTcpImpl.saveICModbusTcp error:{}", e);
            result = Result.getUpdateFailResult();
            result.addMsg(e.toString());
        }
        return result;
    }

    @Override
    public Result delICModbusTcp(CModbusTcp cModbusTcp) {
        Result result = new Result();
        try {

            icModbusTcpBmo.deleteByPrimaryKey(cModbusTcp.getName());
            result = Result.getDelSuccessResult();
        } catch (Exception e) {
            log.error("CModbusTcpImpl.saveICModbusTcp error:{}", e);
            result = Result.getUpdateFailResult();
            result.addMsg(e.toString());
        }
        return result;
    }
}
