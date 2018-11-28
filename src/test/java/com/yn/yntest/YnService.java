package com.yn.yntest;

import YNRPC.DeviceInfo;
import YNRPC.KeyValue;
import YNRPC.Rvqt;
import com.yn.common.Constant;
import com.yn.common.Result;
import com.yn.util.ynService.DataMonitorUtil;
import com.yn.util.ynService.SystemControllerUtil;
import com.yn.util.ynService.systemInformationUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class YnService {

    @Test
    public void DataMonitor() {
        com.yn.common.Result result = new com.yn.common.Result();
        DeviceInfo[] deviceInfos = DataMonitorUtil.getDevicesState();
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
    }


    @Test
    public void systemInformationUtil() {
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

    }

    @Test
    public void getAppRunState() {
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

    }

    @Test
    public void getNetportsState() {
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
    }

    @Test
    public void queryRealData() {
        com.yn.common.Result result = new com.yn.common.Result();
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
//            log.error("query", e);
            result.addMsg(e.getMessage());
        }
    }


    @Test
    public void queryDeviceDataStream() {
        com.yn.common.Result result = new com.yn.common.Result();
        List<HashMap<String, Object>> maps = new ArrayList<>();
        Object o = DataMonitorUtil.queryDeviceDataStream();
        System.out.println(o);

    }




    @Test
    public void newProject() {
        YNRPC.Result ynResult = SystemControllerUtil.newProject();
        Result result = new Result();
//        List<HashMap<String, Object>> maps = new ArrayList<>();

        result.addCode(Constant.CODE_QUERY_SUCCESS);
        result.addMsg(ynResult.toString());
//            result.addCount(rvqts.length);
//            result.addData(maps);
        System.out.println(result);

    }


}