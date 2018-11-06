package com.yn.smo.impl;

import com.yn.bmo.ICModbusTcpBmo;
import com.yn.common.Constant;
import com.yn.common.Result;
import com.yn.entity.CModbusTcp;
import com.yn.entity.CModbusTcpExample;
import com.yn.smo.ICModbusTcpService;
import com.yn.util.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class CModbusTcpSericeImpl implements ICModbusTcpService {
    private static final Logger log = LoggerFactory.getLogger(CModbusTcpSericeImpl.class);

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
            log.error("com/yn/smo/impl/CModbusTcpImpl.java", e.getMessage());
            result.addMsg(e.getMessage());
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
            log.error("com/yn/smo/impl/CModbusTcpImpl.java", e);
            result = Result.getUpdateFailResult();
            result.addMsg(e.toString());
        }
        return result;
    }

    @Override
    public Result addICModbusTcp(CModbusTcp cModbusTcp) {
        Result result = new Result();
        try {
            CModbusTcp cModbusTcp1 = icModbusTcpBmo.selectByPrimaryKey(cModbusTcp.getName());
            boolean aNull = ObjectUtil.isNull(cModbusTcp1);
            if (aNull) {
                int insert = icModbusTcpBmo.insert(cModbusTcp);
                if (insert > 0) {
                    result = Result.getAddSuccessResult();
                }
            } else {
                result = Result.getAddFailResult();
                result.addMsg("名称已存在");
            }
        } catch (Exception e) {
            log.error("com/yn/smo/impl/CModbusTcpImpl.java", e);
            result = Result.getAddFailResult();
            result.addMsg(e.toString());
        }
        return result;
    }

    @Override
    public Result delICModbusTcp(CModbusTcp cModbusTcp) {
        Result result = new Result();
        try {

            int i = icModbusTcpBmo.deleteByPrimaryKey(cModbusTcp.getName());
            if (i > 0) {
                result = Result.getDelSuccessResult();
            } else {
                result = Result.getDelFailResult();
            }

        } catch (Exception e) {
            log.error("com/yn/smo/impl/CModbusTcpImpl.java", e);
            result = Result.getDelFailResult();
            result.addMsg(e.toString());
        }
        return result;
    }
}
