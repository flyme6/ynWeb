package com.yn.smo;

import Ice.StringHolder;
import YNRPC.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProjcetService {
    private static final Logger logger = LoggerFactory.getLogger(ProjcetService.class);

    /**
     * 解释说明ice 客户端和服务端进行简单交互
     *
     * @param args
     * @return
     */
    public static DeviceInfoListHolder getSystemInformation(String[] args) {
        // Communicator实例
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        DeviceInfoListHolder dilh = null;
        try {
            // 调用Ice.Util.Initialize()初始化Ice run time
            ic = Ice.Util.initialize(args);

            // 获取远地打印机的代理
            Ice.ObjectPrx base = ic.stringToProxy("YNRPC.IService:tcp -p 13613");

            // 将上面的代理向下转换成一个Printer接口的代理
            IServicePrx service = IServicePrxHelper.checkedCast(base);

            // 如果转换成功
            if (service == null) {
                throw new Error("Invalid proxy");
            }

            // 调用这个代理，将字符串传给它
            ISystemInformationPrxHolder systemInformationPrxHolder = new ISystemInformationPrxHolder();
            service.getSystemInformation(systemInformationPrxHolder);

            if (systemInformationPrxHolder == null) {
                throw new Error("Invalid proxy2");
            }

            ISystemInformationPrx prx = systemInformationPrxHolder.value;
            dilh = new DeviceInfoListHolder();

            Result netportsState = prx.getNetportsState(dilh);
//            System.out.println(netportsState + "---netportsState");
//            System.out.println(dilh.value + "---dilh.value");
            return dilh;
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
            return dilh;
//            System.exit(status);

        }

    }

    /**
     * 优化 客户端和服务端进行简单交互
     *
     * @param args
     * @return
     */
    public static DeviceInfoListHolder getSystemInformation2(String[] args) {
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        DeviceInfoListHolder deviceInfoListHolder = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectPrx base = ic.stringToProxy("YNRPC.IService:tcp -p 13613");

            IServicePrx service = IServicePrxHelper.checkedCast(base);
            if (service == null) {
                throw new Error("Invalid proxy");
            }

            ISystemInformationPrxHolder systemInformationPrxHolder = new ISystemInformationPrxHolder();
            service.getSystemInformation(systemInformationPrxHolder);
            if (systemInformationPrxHolder == null) {
                throw new Error("Invalid proxy2");
            }

            ISystemInformationPrx prx = systemInformationPrxHolder.value;
            deviceInfoListHolder = new DeviceInfoListHolder();
            Result netportsState = prx.getNetportsState(deviceInfoListHolder);
            System.out.println("获取串口状态：" + netportsState + "----返回对象：" + deviceInfoListHolder);
            return deviceInfoListHolder;
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
            return deviceInfoListHolder;
//            System.exit(status);

        }

    }

    /**
     * 创建新工程
     *
     * @param args
     */
    public static Result newProject(String[] args) {
        // Communicator实例
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        try {
            // 调用Ice.Util.Initialize()初始化Ice run time
            ic = Ice.Util.initialize(args);

            // 获取远地打印机的代理
            Ice.ObjectPrx base = ic.stringToProxy("YNRPC.IService:tcp -p 13613");

            // 将上面的代理向下转换成一个Printer接口的代理
            IServicePrx service = IServicePrxHelper.checkedCast(base);

            // 如果转换成功
            if (service == null) {
                throw new Error("Invalid proxy");
            }
            ISystemControlPrxHolder systemControlPrxHolder = new ISystemControlPrxHolder();
            service.getSystemControl(systemControlPrxHolder);

            if (systemControlPrxHolder == null) {
                throw new Error("Invalid proxy2 systemControlPrxHolder");
            }

            ISystemControlPrx prx = systemControlPrxHolder.value;
            result = prx.newProject();

            System.out.println(result);

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


    /**
     * 工程文件下载
     *
     * @param args
     */
    public static Result saveProject(String[] args) {
        // Communicator实例
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        try {
            // 调用Ice.Util.Initialize()初始化Ice run time
            ic = Ice.Util.initialize(args);

            // 获取远地打印机的代理
            Ice.ObjectPrx base = ic.stringToProxy("YNRPC.IService:tcp -p 13613");

            // 将上面的代理向下转换成一个Printer接口的代理
            IServicePrx service = IServicePrxHelper.checkedCast(base);

            // 如果转换成功
            if (service == null) {
                throw new Error("Invalid proxy");
            }
            ISystemControlPrxHolder prxHolder = new ISystemControlPrxHolder();
            service.getSystemControl(prxHolder);

            if (prxHolder == null) {
                throw new Error("Invalid proxy2 prxHolder");
            }

            ISystemControlPrx prx = prxHolder.value;
            result = prx.saveProject();

            System.out.println(result);

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

    /**
     * 工程文件下载
     *
     * @param args
     */
    public static Result exportProject(String[] args) {
        // Communicator实例
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        try {
            // 调用Ice.Util.Initialize()初始化Ice run time
            ic = Ice.Util.initialize(args);

            // 获取远地打印机的代理
            Ice.ObjectPrx base = ic.stringToProxy("YNRPC.IService:tcp -p 13613");

            // 将上面的代理向下转换成一个Printer接口的代理
            IServicePrx service = IServicePrxHelper.checkedCast(base);

            // 如果转换成功
            if (service == null) {
                throw new Error("Invalid proxy");
            }
            ISystemControlPrxHolder systemControlPrxHolderph = new ISystemControlPrxHolder();
            service.getSystemControl(systemControlPrxHolderph);

            if (systemControlPrxHolderph == null) {
                throw new Error("Invalid proxy2 systemControlPrxHolderph");
            }

            ISystemControlPrx prx = systemControlPrxHolderph.value;
            StringHolder stringHolder = new StringHolder();
            result = prx.exportProject(stringHolder);

            System.out.println(result);

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


    public static void main(String[] args) {
        DeviceInfoListHolder systemInformation1 = ProjcetService.getSystemInformation2(args);
        for (DeviceInfo deviceInfo : systemInformation1.value) {
            logger.info(deviceInfo.devName);
//                System.out.println(deviceInfo.devName);
        }
//        Result result = systemInformation;
//        Result result = ProjcetService.newProject(args);
//        String systemInformation = systemInformation1;
//        System.out.println(systemInformation1);
    }

}