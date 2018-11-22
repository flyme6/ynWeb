package com.yn.util.ynService;

import YNRPC.*;
import org.apache.log4j.Logger;

/**
 * 获得系统信息接口，ISystemInformation可监视系统资源使用情况。
 */
public class systemInformationUtil {

    private static Logger logger = Logger.getLogger(systemInformationUtil.class);

    /**
     * 获得系统资源使用情况
     * Values：返回一对键值对我数组。键为资源的名称，值为资源使用数据，都为字符串格式。
     *
     * @return
     */
    public static Object getSystemResourcesState() {
        String[] args = {"ser", "yn"};
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        DeviceInfoListHolder deviceInfoListHolder = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectPrx base = ic.stringToProxy("YNRPC.IService:tcp -p 13613");

            IServicePrx service = IServicePrxHelper.checkedCast(base);
            if (service == null) {
                throw new Error("service为空");
            }

            ISystemInformationPrxHolder systemInformationPrxHolder = new ISystemInformationPrxHolder();
            service.getSystemInformation(systemInformationPrxHolder);
            if (systemInformationPrxHolder == null) {
                throw new Error("iSystemControlPrxHolder为空");
            }

            ISystemInformationPrx value = systemInformationPrxHolder.value;
            KeyValueListHolder keyValueListHolder = new KeyValueListHolder();
            result = value.getSystemResourcesState(keyValueListHolder);

            System.out.println("获得系统资源使用情况----" + "获取结果：" + result + "----返回对象：" + keyValueListHolder);
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
     * 获得嵌入式应用的运行情况
     * Values：返回一对键值对我数组。键为应用状态的名称，值为状态数据，都为字符串格式。
     *
     * @return
     */
    public static Object getAppRunState() {
        String[] args = {"ser", "yn"};
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        DeviceInfoListHolder deviceInfoListHolder = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectPrx base = ic.stringToProxy("YNRPC.IService:tcp -p 13613");

            IServicePrx service = IServicePrxHelper.checkedCast(base);
            if (service == null) {
                throw new Error("service为空");
            }

            ISystemInformationPrxHolder systemInformationPrxHolder = new ISystemInformationPrxHolder();
            service.getSystemInformation(systemInformationPrxHolder);
            if (systemInformationPrxHolder == null) {
                throw new Error("iSystemControlPrxHolder为空");
            }

            ISystemInformationPrx value = systemInformationPrxHolder.value;
            KeyValueListHolder keyValueListHolder = new KeyValueListHolder();
            result = value.getAppRunState(keyValueListHolder);

            System.out.println("获得嵌入式应用的运行情况----" + "获取结果：" + result + "----返回对象：" + keyValueListHolder);
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
     * 获得系统网口的运行情况
     * states：返回一对键值对我数组。键为网口的名称，值为网口状态值。
     *
     * @return
     */
    public static Object getNetportsState() {
        String[] args = {"ser", "yn"};
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        DeviceInfoListHolder deviceInfoListHolder = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectPrx base = ic.stringToProxy("YNRPC.IService:tcp -p 13613");

            IServicePrx service = IServicePrxHelper.checkedCast(base);
            if (service == null) {
                throw new Error("service为空");
            }

            ISystemInformationPrxHolder systemInformationPrxHolder = new ISystemInformationPrxHolder();
            service.getSystemInformation(systemInformationPrxHolder);
            if (systemInformationPrxHolder == null) {
                throw new Error("iSystemControlPrxHolder为空");
            }

            ISystemInformationPrx value = systemInformationPrxHolder.value;
            DeviceInfoListHolder deviceInfoListHolder1 = new DeviceInfoListHolder();
            result = value.getNetportsState(deviceInfoListHolder1);

            System.out.println("获得系统网口的运行情况----" + "获取结果：" + result + "----返回对象：" + deviceInfoListHolder1);
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
     * 获得系统串口的运行情况
     * states：返回一对键值对我数组。键为串口的名称，值为串口状态值。
     *
     * @return
     */
    public static Object getComportsState() {
        String[] args = {"ser", "yn"};
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        DeviceInfoListHolder deviceInfoListHolder = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectPrx base = ic.stringToProxy("YNRPC.IService:tcp -p 13613");

            IServicePrx service = IServicePrxHelper.checkedCast(base);
            if (service == null) {
                throw new Error("service为空");
            }

            ISystemInformationPrxHolder systemInformationPrxHolder = new ISystemInformationPrxHolder();
            service.getSystemInformation(systemInformationPrxHolder);
            if (systemInformationPrxHolder == null) {
                throw new Error("iSystemControlPrxHolder为空");
            }

            ISystemInformationPrx value = systemInformationPrxHolder.value;
            DeviceInfoListHolder deviceInfoListHolder1 = new DeviceInfoListHolder();
            result = value.getComportsState(deviceInfoListHolder1);

            System.out.println("获得系统串口的运行情况----" + "获取结果：" + result + "----返回对象：" + deviceInfoListHolder1);
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
