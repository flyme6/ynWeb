package com.yn.util.ynService;

import Ice.IntHolder;
import YNRPC.*;

/**
 * 获得数据监听接口，IDataMonitor可监视实时数据及日志及通信数据流等。
 */
public class DataMonitorUtil {

    /**
     * 获得设备状态
     *
     * @return
     */
    public static Object getDevicesState() {
        String[] args = {"ser", "yn"};
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectPrx base = ic.stringToProxy("YNRPC.IService:tcp -p 13613");

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
            DeviceInfoListHolder deviceInfoListHolder = new DeviceInfoListHolder();
            result = value.getDevicesState(deviceInfoListHolder);

            System.out.println("获得设备状态----" + "获取结果：" + result + "----返回对象：" + deviceInfoListHolder);
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

    /**
     * 获得设备状态
     * ptIds: 点的ID列表
     * values: 返回点的实时数据值
     *
     * @return
     */
    public static Object queryRealData() {
        String[] args = {"ser", "yn"};
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectPrx base = ic.stringToProxy("YNRPC.IService:tcp -p 13613");

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
            RvqtListHolder rvqtListHolder = new RvqtListHolder();
            int[] ptIds = {1, 2};
            result = value.queryRealDatas(ptIds, rvqtListHolder);

            System.out.println("获得设备状态----" + "获取结果：" + result + "----返回对象：" + rvqtListHolder + "----点ID列表" + ptIds);
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
            Ice.ObjectPrx base = ic.stringToProxy("YNRPC.IService:tcp -p 13613");

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
            String devName = "dev";
            int inId = 1;
            int limit = 1;
            StringListHolder msgs = new StringListHolder();
            Ice.IntHolder outId = new IntHolder();
            result = value.queryDeviceDataFrames(devName, inId, limit, msgs, outId);

            System.out.println("获得设备状态----" + "获取结果："
                    + result + "----返回对象：StringListHolder "
                    + devName + "devName----"
                    + inId + "inId----"
                    + limit + "limit----"
                    + limit + "limit----"
                    + msgs + "msgs----"
                    + outId + "outId----"
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
            Ice.ObjectPrx base = ic.stringToProxy("YNRPC.IService:tcp -p 13613");

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

            System.out.println("获得设备状态----" + "获取结果："
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
