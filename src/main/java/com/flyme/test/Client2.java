package com.flyme.test;

import YNRPC.*;
import com.flyme.service.demo.HelloPrx;
import com.flyme.service.demo.HelloPrxHelper;
import com.yn.util.ProjectIceUtil;

/**
 * 客户端
 */
public class Client2 {
    public static void main(String[] args) {
        // Communicator实例
        int status = 0;
        Ice.Communicator ic = null;

//		try {
//			// 调用Ice.Util.Initialize()初始化Ice run time
//			ic = Ice.Util.initialize(args);
//
//			// 获取远地打印机的代理
//			Ice.ObjectPrx base = ic.stringToProxy("YNRPC.IService:tcp -p 13613");
//
//			// 将上面的代理向下转换成一个Printer接口的代理
//			IServicePrx service = IServicePrxHelper.checkedCast(base);
//
//			// 如果转换成功
//			if (service == null) {
//				throw new Error("Invalid proxy");
//			}

        final IServicePrx service = ProjectIceUtil.getService();

        // 调用这个代理，将字符串传给它
        ISystemInformationPrxHolder sih = new ISystemInformationPrxHolder();
        service.getSystemInformation(sih);

        if (sih == null) {
            throw new Error("Invalid proxy2");
        }

        ISystemInformationPrx si = sih.value;
        DeviceInfoListHolder dilh = new DeviceInfoListHolder();
        si.getNetportsState(dilh);

        for (DeviceInfo deviceInfo : dilh.value) {
            System.out.println(deviceInfo.devName);
        }

//
//		} catch (Ice.LocalException e) {
//			e.printStackTrace();
//			status = 1;
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//			status = 1;
//		}
        ProjectIceUtil.destroyService(ic);

//		if (ic != null) {
//			try {
//				ic.destroy();
//			} catch (Exception e) {
//				System.err.println(e.getMessage());
//				status = 1;
//			}
//		}
//        System.exit(status);
//        return s;
    }

    /**
     * 请求系统服务接口
     *
     * @param args
     * @return
     */
    public static String getSystem(String[] args) {
        int status = 0;
        // Communicator实例
        Ice.Communicator ic = null;
        Result systemInformation = null;
//        ic.destroy();
        try {
            // 调用Ice.Util.Initialize()初始化Ice run time
            ic = Ice.Util.initialize(args);
            // 获取远地打印机的代理
            Ice.ObjectPrx base = ic.stringToProxy("YNRPC.IService:tcp –h 127.0.0.1 –p 13613");
//            Ice.ObjectPrx base = ic.stringToProxy("hello:default -p 12002");
            // 将上面的代理向下转换成一个Printer接口的代理
            IServicePrx ynservice = IServicePrxHelper.checkedCast(base);

            // 如果转换成功
            if (ynservice == null) {
                throw new Error("ynservice");
            }

            ISystemInformationPrxHolder si = new ISystemInformationPrxHolder();
            // 调用这个代理，将字符串传给它
            systemInformation = ynservice.getSystemInformation(si);
            System.out.println(">>" + systemInformation);
        } catch (Ice.LocalException e) {
            e.printStackTrace();
            status = 1;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            status = 1;
        }
        if (ic != null) {
            try {
                ic.destroy();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                status = 1;
            }
        }
        return systemInformation.toString();
//        System.exit(status);
    }

//    public static String main(String[] args) {
//        int status = 0;
//        // Communicator实例
//        Ice.Communicator ic = null;
//        YNRPC.Result systemResourcesState = null;
////        ic.destroy();
//        try {
//            // 调用Ice.Util.Initialize()初始化Ice run time
//            ic = Ice.Util.initialize(args);
//            // 获取远地打印机的代理
//            Ice.ObjectPrx base = ic.stringToProxy("YNRPC.IService:tcp –h 127.0.0.1 –p 13613");
////            Ice.ObjectPrx base = ic.stringToProxy("hello:default -p 12002");
//            // 将上面的代理向下转换成一个Printer接口的代理
//            ISystemInformationPrx systemInformationPrx = ISystemInformationPrxHelper.checkedCast(base);
//            // 如果转换成功
//            if (systemInformationPrx == null) {
//                throw new Error("systemInformationPrx为空");
//            }
//            KeyValueListHolder keyValueListHolder = new KeyValueListHolder();
//            // 调用这个代理，将字符串传给它
//            systemResourcesState = systemInformationPrx.getSystemResourcesState(keyValueListHolder);
//            System.out.println(">>" + systemResourcesState);
//        } catch (Ice.LocalException e) {
//            e.printStackTrace();
//            status = 1;
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//            status = 1;
//        }
//        if (ic != null) {
//            try {
//                ic.destroy();
//            } catch (Exception e) {
//                System.err.println(e.getMessage());
//                status = 1;
//            }
//        }
//        return systemResourcesState.toString();
////        System.exit(status);
//    }

}
