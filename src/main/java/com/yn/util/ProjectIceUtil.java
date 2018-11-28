package com.yn.util;

import Ice.Exception;
import IceInternal.Ex;
import YNRPC.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ProjectIceUtil {
    private static String args[] = {"1", "2"};
    private static int status = 0;
    private static Ice.Communicator ic = null;
    private static Result result = null;
    private static IServicePrx service = null;
    private static final Logger logger = LoggerFactory.getLogger(ProjectIceUtil.class);

    private ProjectIceUtil() {
    }

    /**
     * 获取 service
     *
     * @return
     * @throws Exception
     */
    public static IServicePrx getService() throws Exception {
        ic = Ice.Util.initialize(args);

        // 获取远地打印机的代理
        Ice.ObjectPrx base = ic.stringToProxy(Const.STRINGIFIED_PROXIES);

        // 将上面的代理向下转换成一个Printer接口的代理
        service = IServicePrxHelper.checkedCast(base);
        if (service == null) {
            throw new Error("getService 为空");
        }
        return service;
    }

    /**
     * 释放连接 Connection
     *
     * @param ic
     */
    public static void destroyService(Ice.Communicator ic) {
        if (ic != null) {
            ic.destroy();
        }
    }


//    public static IServicePrx getService() {
//        String args[] = {"yn", "service"};
//        int status = 0;
//        Ice.Communicator ic = null;
//        Result result = null;
//        IServicePrx service = null;
//        try {
//            // 调用Ice.Util.Initialize()初始化Ice run time
//            ic = Ice.Util.initialize(args);
//
//            // 获取远地打印机的代理
//            Ice.ObjectPrx base = ic.stringToProxy(Const.STRINGIFIED_PROXIES);
//
//            // 将上面的代理向下转换成一个Printer接口的代理
//            service = IServicePrxHelper.checkedCast(base);
//
//            // 如果转换成功
//            if (service == null) {
//                throw new Error("Invalid proxy");
//            }
//
//        } catch (Ice.LocalException e) {
//            e.printStackTrace();
//            status = 1;
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//            status = 1;
//        } finally {
//            if (ic != null) {
//                ic.destroy();
//            }
//            System.exit(status);
//        }
//
//        return service;
//    }

    public static Result getSystemControl(String[] args) {
        // Communicator实例
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        try {
            // 调用Ice.Util.Initialize()初始化Ice run time
            ic = Ice.Util.initialize(args);

            // 获取远地打印机的代理
            Ice.ObjectPrx base = ic.stringToProxy(Const.STRINGIFIED_PROXIES);

            // 将上面的代理向下转换成一个Printer接口的代理
            IServicePrx service = IServicePrxHelper.checkedCast(base);

            // 如果转换成功
            if (service == null) {
                throw new Error("Invalid proxy");
            }

            // 调用这个代理，将字符串传给它
            ISystemInformationPrxHolder sih = new ISystemInformationPrxHolder();
            service.getSystemInformation(sih);

            if (sih == null) {
                throw new Error("Invalid proxy2");
            }

            ISystemInformationPrx si = sih.value;
            DeviceInfoListHolder dilh = new DeviceInfoListHolder();
            result = si.getNetportsState(dilh);

            for (DeviceInfo deviceInfo : dilh.value) {
                logger.info(deviceInfo.devName);
//                System.out.println(deviceInfo.devName);
            }


//            return result.toString();
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
            System.exit(status);
        }
        return result;
    }
}
