package com.yn.smo.impl;

import YNRPC.DeviceInfo;
import YNRPC.KeyValue;
import com.yn.common.Constant;
import com.yn.common.Result;
import com.yn.smo.IsystemInformationService;
import com.yn.util.ynService.systemInformationUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class systemInformationServiceImpl implements IsystemInformationService {
    @Override
    public Result getSystemResourcesState() {
        com.yn.common.Result result = new com.yn.common.Result();
        KeyValue[] keyValues = systemInformationUtil.getSystemResourcesState();

        List<HashMap<String, Object>> mMenuData = new ArrayList<>();

        for (int i = 0; i < keyValues.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("name", keyValues[i].name);
            map.put("val", keyValues[i].val);
            mMenuData.add(map);
        }

        result.addCode(Constant.CODE_QUERY_SUCCESS);
        result.addMsg(Constant.MSG_QUERY_SUCCESS);
        result.addCount(keyValues.length);
        result.addData(mMenuData);
        System.out.println(result);
        return result;
    }

    @Override
    public Result getAppRunState() {
        com.yn.common.Result result = new com.yn.common.Result();
        KeyValue[] keyValues = systemInformationUtil.getAppRunState();

        List<HashMap<String, Object>> mMenuData = new ArrayList<>();

        for (int i = 0; i < keyValues.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("name", keyValues[i].name);
            map.put("val", keyValues[i].val);
            mMenuData.add(map);
        }

        result.addCode(Constant.CODE_QUERY_SUCCESS);
        result.addMsg(Constant.MSG_QUERY_SUCCESS);
        result.addCount(keyValues.length);
        result.addData(mMenuData);
        System.out.println(result);
        return result;
    }

    @Override
    public Result getNetportsState() {
        com.yn.common.Result result = new com.yn.common.Result();
        DeviceInfo[] deviceInfos = systemInformationUtil.getNetportsState();
        List<HashMap<String, Object>> mMenuData = new ArrayList<>();

        for (int i = 0; i < deviceInfos.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("devName", deviceInfos[i].devName);
            map.put("devState", deviceInfos[i].devState);
            mMenuData.add(map);
        }

        result.addCode(Constant.CODE_QUERY_SUCCESS);
        result.addMsg(Constant.MSG_QUERY_SUCCESS);
        result.addCount(deviceInfos.length);
        result.addData(mMenuData);
        System.out.println(result);
        return result;
    }

    @Override
    public Result getComportsState() {
        com.yn.common.Result result = new com.yn.common.Result();
        DeviceInfo[] deviceInfos = systemInformationUtil.getComportsState();
        List<HashMap<String, Object>> mMenuData = new ArrayList<>();

        for (int i = 0; i < deviceInfos.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            String s = String.valueOf(deviceInfos[i].devState);
            if (s == "DSRUNNING") {
//                运行为绿色
                s = "#B2B2B2";
//                s = "5FB878";
            } else if (s == "DSFAULT") {
//                故障为红色
                s = "#B2B2B2";
            } else if (s == "DSSTOPPED") {
//                未使用为灰色
                s = "#B2B2B2";
            }

            map.put("devName", deviceInfos[i].devName);
            map.put("devState", s);
//            map.put("devState", deviceInfos[i].devState);
            mMenuData.add(map);
        }

        result.addCode(Constant.CODE_QUERY_SUCCESS);
        result.addMsg(Constant.MSG_QUERY_SUCCESS);
        result.addCount(deviceInfos.length);
        result.addData(mMenuData);
        System.out.println(result);
        return result;
    }
}
