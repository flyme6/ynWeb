package com.yn.smo.impl;

import YNRPC.DeviceInfo;
import YNRPC.Rvqt;
import com.yn.bmo.IPointsBmo;
import com.yn.common.Constant;
import com.yn.common.Result;
import com.yn.entity.Points;
import com.yn.mapper.PointsMapper;
import com.yn.smo.IDataMonitorService;
import com.yn.util.ynService.DataMonitorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class DataMonitorServiceImpl implements IDataMonitorService {
    private static final Logger log = LoggerFactory.getLogger(DataMonitorServiceImpl.class);

    @Autowired
    private IPointsBmo bmo;
    @Autowired
    private PointsMapper mapper;

    @Override
    public Result getDevicesState() {
        Result result = new Result();
        List<HashMap<String, Object>> maps = new ArrayList<>();
        try {
            DeviceInfo[] devicesState = DataMonitorUtil.getDevicesState();
            for (int i = 0; i < devicesState.length; i++) {
                HashMap<String, Object> map = new HashMap<>();
                String s = String.valueOf(devicesState[i].devState);
                if (s == "DSRUNNING") {
                    // 运行为绿色,设备启动中
                    s = "<a style=\"color: #5FB878\"> 设备启动中</a>";
                } else if (s == "DSSTARTING") {
                    // 运行为绿色,设备运行中
                    s = "<a style=\"color: #5FB878\"> 设备运行中</a>";
                } else if (s == "DSFAULT") {
                    // 故障为红色,设备故障
                    s = "<a style=\"color: #FD482C\"> 设备故障</a>";
                } else if (s == "DSSTOPPED") {
                    // 未使用为灰色, 设备停止
                    s = "<a style=\"color: #B2B2B2\"> 设备停止</a>";
                }
                map.put("devName", devicesState[i].devName);
                map.put("devState", s);
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
    public Result queryRealData(Points points) {
        System.out.println("asdsad" + points.toString());
        String[] strings = mapper.selectPoints(points);
        Integer total = mapper.selectTotal(points);

        System.out.println(strings.toString() + "maps1");

        int[] ints = DataMonitorUtil.queryPointIds(strings);

        com.yn.common.Result result = new com.yn.common.Result();
        List<HashMap<String, Object>> maps = new ArrayList<>();
        try {

            Rvqt[] rvqts = DataMonitorUtil.queryRealData(ints);
            for (int i = 0; i < rvqts.length; i++) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("name", strings[i]);
                map.put("id", ints[i]);
                map.put("q", rvqts[i].q);
                map.put("r", rvqts[i].r);
                map.put("t", rvqts[i].t);
                map.put("v", rvqts[i].v);
                maps.add(map);
            }

            result.addCode(Constant.CODE_QUERY_SUCCESS);
            result.addMsg(Constant.MSG_QUERY_SUCCESS);
            result.addCount(total);
            result.addData(maps);
        } catch (Exception e) {
            log.error("queryRealData", e);
            result.addMsg(e.getMessage());
        }
        return result;
    }
}
