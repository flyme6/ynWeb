package com.yn.smo.impl;

import YNRPC.DeviceInfo;
import YNRPC.Rvqt;
import com.alibaba.fastjson.JSON;
import com.yn.common.Constant;
import com.yn.common.Result;
import com.yn.smo.IDataMonitorService;
import com.yn.util.JsonUtil;
import com.yn.util.ynService.DataMonitorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataMonitorServiceImpl implements IDataMonitorService {
    private static final Logger log = LoggerFactory.getLogger(DataMonitorServiceImpl.class);

    @Override
    public Result getDevicesState() {
        Result result = new Result();
        List<HashMap<String, Object>> maps = new ArrayList<>();
        try {
            DeviceInfo[] devicesState = DataMonitorUtil.getDevicesState();
            for (int i = 0; i < devicesState.length; i++) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("devName", devicesState[i].devName);
                map.put("devState", devicesState[i].devState);
                maps.add(map);
            }

            result.addCode(Constant.CODE_QUERY_SUCCESS);
            result.addMsg(Constant.MSG_QUERY_SUCCESS);
            result.addCount(devicesState.length);
            result.addData(maps);
            System.out.println(result);
        } catch (Exception e) {
            log.error("query", e);
            result.addMsg(e.getMessage());
        }
        return result;
    }

    @Override
    public Result queryRealData() {
        Result result = new Result();
        List<HashMap<String, Object>> maps = new ArrayList<>();
        try {
            Rvqt[] rvqts = DataMonitorUtil.queryRealData();
            for (int i = 0; i < rvqts.length; i++) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("q", rvqts[i].q);
                map.put("r", rvqts[i].r);
                map.put("t", rvqts[i].t);
                map.put("v", rvqts[i].v);
                maps.add(map);
            }

            result.addCode(Constant.CODE_QUERY_SUCCESS);
            result.addMsg(Constant.MSG_QUERY_SUCCESS);
            result.addCount(rvqts.length);
            result.addData(maps);
            System.out.println(result);
        } catch (Exception e) {
            log.error("query", e);
            result.addMsg(e.getMessage());
        }
        return result;
    }
}
