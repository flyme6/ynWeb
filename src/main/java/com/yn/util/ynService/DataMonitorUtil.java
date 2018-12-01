package com.yn.util.ynService;

import Ice.IntHolder;
import YNRPC.*;
import com.alibaba.fastjson.JSON;
import com.yn.common.Constant;
import com.yn.util.Const;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 获得数据监听接口，IDataMonitor可监视实时数据及日志及通信数据流等。
 */
public class DataMonitorUtil {

    public static void main(String[] args) {
        com.yn.common.Result result = new com.yn.common.Result();
        DeviceInfo[] deviceInfos = getDevicesState();
//        Map<String, String> map = new HashMap<>();
        String s = JSON.toJSONString(deviceInfos);

//        System.out.println(s);
//        map.put("data",s);
//        System.out.println(map.toString());

//        System.out.println(result);
        List<HashMap<String, Object>> maps = new ArrayList<>();
        HashMap<String, Object> map = new HashMap<>();

//        第二种方式
        for (DeviceInfo deviceInfo : deviceInfos) {
            String devName = deviceInfo.devName;
            DeviceState devState = deviceInfo.devState;
//            for (int i = 0; i < 10; i++) {
            map.put("devName", devName);
            map.put("devState", devState.toString());
            maps.add(map);
//            }
//            System.out.println(map.toString());
        }

//        第一种方式
        List<HashMap<String, Object>> mMenuData = new ArrayList<>();

        for (int i = 0; i < deviceInfos.length; i++) {
            HashMap<String, Object> map2 = new HashMap<>();
//            String s1 = null;
            String s1 = String.valueOf(deviceInfos[i].devState);
            if (s1 == "DSRUNNING") {
//                运行为绿色
//                s1 = deviceInfos[i].devState.toString();
//                s1 = "5FB878";
                s1 = "FD482C";
            } else if (s1 == "DSFAULT") {
//                故障为红色
//                s1 = deviceInfos[i].devState.toString();
                s1 = "FD482C";
            } else if (s1 == "DSSTOPPED") {
//                未使用为灰色
//                s1 = deviceInfos[i].devState.toString();
                s1 = "B2B2B2";
            }
            map2.put("devName", deviceInfos[i].devName);
            map2.put("devState", s1);
//            map2.put("devState", deviceInfos[i].devState);
            mMenuData.add(map2);
        }

        result.addCode(Constant.CODE_QUERY_SUCCESS);
        result.addMsg(Constant.MSG_QUERY_SUCCESS);
        result.addCount(deviceInfos.length);
        result.addData(mMenuData);
        System.out.println(result);
    }

    /**
     * 获得设备状态
     *
     * @return
     */
    public static DeviceInfo[] getDevicesState() {
        String[] args = {"ser", "yn"};
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        DeviceInfoListHolder deviceInfoListHolder = null;
        try {
            ic = Ice.Util.initialize(args);
//            Ice.ObjectPrx base = ic.stringToProxy(Const.STRINGIFIED_PROXIES);
            Ice.ObjectPrx base = ic.stringToProxy(Const.STRINGIFIED_PROXIES);

            IServicePrx service = IServicePrxHelper.checkedCast(base);
            if (service == null) {
                throw new Error("service为空");
            }

            IDataMonitorPrxHolder iDataMonitorPrxHolder = new IDataMonitorPrxHolder();
            service.getDataMonitor(iDataMonitorPrxHolder);
            if (iDataMonitorPrxHolder == null) {
                throw new Error("iDataMonitorPrxHolder为空");
            }

            IDataMonitorPrx value = iDataMonitorPrxHolder.value;
            deviceInfoListHolder = new DeviceInfoListHolder();
            result = value.getDevicesState(deviceInfoListHolder);


            System.out.println("获得设备状态----" + "获取结果：" + result + "----返回对象：" + deviceInfoListHolder.value);
            return deviceInfoListHolder.value;
        } catch (Ice.LocalException e) {
            e.printStackTrace();
            status = 1;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            status = 1;
        } finally {
            if (ic != null) {
                ic.destroy();
            }
            return deviceInfoListHolder.value;
        }

    }

    /**
     * 获得实时数据
     * ptIds: 点的ID列表
     * values: 返回点的实时数据值
     *
     * @return
     */
    public static Rvqt[] queryRealData(int[] ptIds) {
        String[] args = {"ser", "yn"};
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        RvqtListHolder rvqtListHolder = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectPrx base = ic.stringToProxy(Const.STRINGIFIED_PROXIES);

            IServicePrx service = IServicePrxHelper.checkedCast(base);
            if (service == null) {
                throw new Error("service为空");
            }

            IDataMonitorPrxHolder iDataMonitorPrxHolder = new IDataMonitorPrxHolder();
            service.getDataMonitor(iDataMonitorPrxHolder);
            if (iDataMonitorPrxHolder == null) {
                throw new Error("iDataMonitorPrxHolder为空");
            }

            IDataMonitorPrx value = iDataMonitorPrxHolder.value;
            rvqtListHolder = new RvqtListHolder();
//            ptIds = new int[]{1, 2};
            result = value.queryRealDatas(ptIds, rvqtListHolder);
            System.out.println("获得实时数据----" + "获取结果：" + result + "----返回对象：" + rvqtListHolder.value + "----点ID列表" + ptIds);
            return rvqtListHolder.value;
        } catch (Ice.LocalException e) {
            e.printStackTrace();
            status = 1;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            status = 1;
        } finally {
            if (ic != null) {
                ic.destroy();
            }
            return rvqtListHolder.value;
        }

    }

    /**
     * Description: 转换点名为点ID(使用ID可提高点查询效率)
     * Input: ptNames 点名列表
     * Output: ptIds 返回点ID列表，如ID为-1表示无此点
     * Return:
     * Others:
     **/
    public static int[] queryPointIds(String[] ptNames) {
        String[] args = {"ser", "yn"};
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        PointIdListHolder pointIdListHolder = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectPrx base = ic.stringToProxy(Const.STRINGIFIED_PROXIES);

            IServicePrx service = IServicePrxHelper.checkedCast(base);
            if (service == null) {
                throw new Error("service为空");
            }

            IDataMonitorPrxHolder iDataMonitorPrxHolder = new IDataMonitorPrxHolder();
            service.getDataMonitor(iDataMonitorPrxHolder);
            if (iDataMonitorPrxHolder == null) {
                throw new Error("iDataMonitorPrxHolder为空");
            }

            IDataMonitorPrx value = iDataMonitorPrxHolder.value;
            pointIdListHolder = new PointIdListHolder();
            result = value.queryPointIds(ptNames, pointIdListHolder);
            System.out.println("获得实时数据----" + "获取结果：" + result + "----返回对象：" + pointIdListHolder.value + "----点ID列表" + ptNames);
            return pointIdListHolder.value;
        } catch (Ice.LocalException e) {
            e.printStackTrace();
            status = 1;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            status = 1;
        } finally {
            if (ic != null) {
                ic.destroy();
            }
            return pointIdListHolder.value;
        }

    }

    /**
     * 获得设备的通信数据流
     * devName: 设备的名称
     * inId: 数据流编号位置。第一调用此方法此参数传递0，再次调用时传递上次调用返回的outId参数
     * limit：最大显示行数。参数为0表示无限制。
     * Msgs：返回数据流的字符串数组
     * outId：返回数据流位置，下次调用此方法时传递此参数
     *
     * @return
     */
    public static Object queryDeviceDataStream() {
        String[] args = {"ser", "yn"};
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectPrx base = ic.stringToProxy(Const.STRINGIFIED_PROXIES);

            IServicePrx service = IServicePrxHelper.checkedCast(base);
            if (service == null) {
                throw new Error("service为空");
            }

            IDataMonitorPrxHolder iDataMonitorPrxHolder = new IDataMonitorPrxHolder();
            service.getDataMonitor(iDataMonitorPrxHolder);
            if (iDataMonitorPrxHolder == null) {
                throw new Error("iDataMonitorPrxHolder为空");
            }

            IDataMonitorPrx monitorPrx = iDataMonitorPrxHolder.value;
            String devName = "dev";
            int inId = 0;
            int limit = 0;
            StringListHolder msgs = new StringListHolder();
            Ice.IntHolder outId = new IntHolder();
            result = monitorPrx.queryDeviceDataFrames(devName, inId, limit, msgs, outId);

            System.out.println("获得设备的通信数据流----" + "获取结果："
                    + result + "----返回对象：StringListHolder "
                    + devName + "devName----"
                    + inId + "inId----"
                    + limit + "limit----"
                    + limit + "limit----"
                    + msgs + "msgs----"
                    + outId + "outId----"
            );
            return "获得设备的通信数据流----" + "获取结果："
                    + result + "----返回对象：StringListHolder "
                    + devName + "devName----"
                    + inId + "inId----"
                    + limit + "limit----"
                    + limit + "limit----"
                    + msgs + "msgs----"
                    + outId + "outId----";
        } catch (Ice.LocalException e) {
            e.printStackTrace();
            status = 1;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            status = 1;
        } finally {
            if (ic != null) {
                ic.destroy();
            }
            return result;
        }

    }


    /**
     * 获得系统日志信息
     * inId：日志编号位置。第一调用此方法此参数传递0，再次调用时传递上次调用返回的outId参数
     * limit：最大显示行数。参数为0表示无限制。
     * Msgs：返回日志的字符串数组
     * outId：返回位置，下次调用此方法时传递此参数
     *
     * @return
     */
    public static Object querySystemLog() {
        String[] args = {"ser", "yn"};
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectPrx base = ic.stringToProxy(Const.STRINGIFIED_PROXIES);

            IServicePrx service = IServicePrxHelper.checkedCast(base);
            if (service == null) {
                throw new Error("service为空");
            }

            IDataMonitorPrxHolder iDataMonitorPrxHolder = new IDataMonitorPrxHolder();
            service.getDataMonitor(iDataMonitorPrxHolder);
            if (iDataMonitorPrxHolder == null) {
                throw new Error("iDataMonitorPrxHolder为空");
            }

            IDataMonitorPrx value = iDataMonitorPrxHolder.value;

            int inId = 1;
            int limit = 5;
            StringListHolder msgs = new StringListHolder();
            Ice.IntHolder outId = new IntHolder();
            result = value.querySystemLog(inId, limit, msgs, outId);

            System.out.println("获得系统日志信息----" + "获取结果："
                    + result + "----返回对象：StringListHolder " + msgs
                    + "----inId:" + inId
                    + "----limit:" + limit
                    + "----msgs:" + msgs
                    + "----outId:" + outId
            );
            return result;
        } catch (Ice.LocalException e) {
            e.printStackTrace();
            status = 1;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            status = 1;
        } finally {
            if (ic != null) {
                ic.destroy();
            }
            return result;
        }

    }
}
