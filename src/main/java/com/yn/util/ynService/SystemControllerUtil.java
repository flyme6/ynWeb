package com.yn.util.ynService;

import Ice.StringHolder;
import YNRPC.*;
import com.yn.util.Const;

/**
 * 获得系统控制接口，ISystemControl可控制工程启/停等
 */

public class SystemControllerUtil {
    /**
     * 获取系统信息状态
     *
     * @param args
     * @return
     */
    public static DeviceInfoListHolder getSystemInformation() {
        String[] args = {"ser", "yn"};
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        DeviceInfoListHolder deviceInfoListHolder = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectPrx base = ic.stringToProxy(Const.STRINGIFIED_PROXIES);

            IServicePrx service = IServicePrxHelper.checkedCast(base);
            if (service == null) {
                throw new Error("service 为空");
            }

            ISystemInformationPrxHolder systemInformationPrxHolder = new ISystemInformationPrxHolder();
            service.getSystemInformation(systemInformationPrxHolder);
            if (systemInformationPrxHolder == null) {
                throw new Error("systemInformationPrxHolder为空");
            }

            ISystemInformationPrx value = systemInformationPrxHolder.value;
            deviceInfoListHolder = new DeviceInfoListHolder();
            Result netportsState = value.getNetportsState(deviceInfoListHolder);
            System.out.println("获取系统信息状态----" + "获取结果：" + netportsState + "----返回对象：" + deviceInfoListHolder);
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
     * 获取系统控制接口——新建工程
     *
     * @param args
     * @return
     */

    public static Result newProject() {
        String[] args = {"ser", "yn"};
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        DeviceInfoListHolder deviceInfoListHolder = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectPrx base = ic.stringToProxy(Const.STRINGIFIED_PROXIES);

            IServicePrx service = IServicePrxHelper.checkedCast(base);
            if (service == null) {
                throw new Error("Invalid proxy");
            }

            ISystemControlPrxHolder iSystemControlPrxHolder = new ISystemControlPrxHolder();
            service.getSystemControl(iSystemControlPrxHolder);
            if (iSystemControlPrxHolder == null) {
                throw new Error("iSystemControlPrxHolder为空");
            }

            ISystemControlPrx value = iSystemControlPrxHolder.value;
            result = value.newProject();

            System.out.println("新建工程----" + "获取结果：" + result + "----返回对象：null");
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
     * 获取系统控制接口——工程文件下载
     *
     * @param
     * @return
     */

    public static Result saveProject() {
        String[] args = {"ser", "yn"};
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        DeviceInfoListHolder deviceInfoListHolder = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectPrx base = ic.stringToProxy(Const.STRINGIFIED_PROXIES);

            IServicePrx service = IServicePrxHelper.checkedCast(base);
            if (service == null) {
                throw new Error("Invalid proxy");
            }

            ISystemControlPrxHolder iSystemControlPrxHolder = new ISystemControlPrxHolder();
            service.getSystemControl(iSystemControlPrxHolder);
            if (iSystemControlPrxHolder == null) {
                throw new Error("iSystemControlPrxHolder为空");
            }

            ISystemControlPrx value = iSystemControlPrxHolder.value;
            result = value.saveProject();

            System.out.println("工程文件下载----" + "获取结果：" + result + "----返回对象：null");
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
     * 获取系统控制接口——保存工程到本地
     *
     * @param
     * @return
     */

    public static StringHolder exportProject() {
        String[] args = {"ser", "yn"};
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        DeviceInfoListHolder deviceInfoListHolder = null;
        StringHolder stringHolder = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectPrx base = ic.stringToProxy(Const.STRINGIFIED_PROXIES);

            IServicePrx service = IServicePrxHelper.checkedCast(base);
            if (service == null) {
                throw new Error("Invalid proxy");
            }

            ISystemControlPrxHolder iSystemControlPrxHolder = new ISystemControlPrxHolder();
            service.getSystemControl(iSystemControlPrxHolder);
            if (iSystemControlPrxHolder == null) {
                throw new Error("iSystemControlPrxHolder为空");
            }

            ISystemControlPrx controlPrx = iSystemControlPrxHolder.value;
            stringHolder = new StringHolder();
            result = controlPrx.exportProject(stringHolder);
            System.out.println("保存工程到本地----" + "获取结果：" + result + "----返回对象：" + stringHolder);
            return stringHolder;
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
            return stringHolder;
        }

    }

    /**
     * 获取系统控制接口——打开本地工程
     *
     * @param
     * @return
     */

    public static Result importProject(String fileName) {
        String[] args = {"ser", "yn"};
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        DeviceInfoListHolder deviceInfoListHolder = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectPrx base = ic.stringToProxy(Const.STRINGIFIED_PROXIES);

            IServicePrx service = IServicePrxHelper.checkedCast(base);
            if (service == null) {
                throw new Error("Invalid proxy");
            }

            ISystemControlPrxHolder iSystemControlPrxHolder = new ISystemControlPrxHolder();
            service.getSystemControl(iSystemControlPrxHolder);
            if (iSystemControlPrxHolder == null) {
                throw new Error("iSystemControlPrxHolder为空");
            }

            ISystemControlPrx value = iSystemControlPrxHolder.value;

            result = value.importProject(fileName);

            System.out.println("打开本地工程----" + "获取结果：" + result + "----返回对象：" + fileName);
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
     * 获取系统控制接口——检查工程
     *
     * @param
     * @return
     */

    public static Result checkProject() {
        String[] args = {"ser", "yn"};
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        DeviceInfoListHolder deviceInfoListHolder = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectPrx base = ic.stringToProxy(Const.STRINGIFIED_PROXIES);

            IServicePrx service = IServicePrxHelper.checkedCast(base);
            if (service == null) {
                throw new Error("Invalid proxy");
            }

            ISystemControlPrxHolder iSystemControlPrxHolder = new ISystemControlPrxHolder();
            service.getSystemControl(iSystemControlPrxHolder);
            if (iSystemControlPrxHolder == null) {
                throw new Error("iSystemControlPrxHolder为空");
            }

            ISystemControlPrx controlPrx = iSystemControlPrxHolder.value;

            result = controlPrx.checkProject();

            System.out.println("检查工程----" + "获取结果：" + result + "----返回对象：");
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
     * 获取系统控制接口——启动工程
     *
     * @param
     * @return
     */

    public static Result startProject() {
        String[] args = {"ser", "yn"};
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        DeviceInfoListHolder deviceInfoListHolder = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectPrx base = ic.stringToProxy(Const.STRINGIFIED_PROXIES);

            IServicePrx service = IServicePrxHelper.checkedCast(base);
            if (service == null) {
                throw new Error("Invalid proxy");
            }

            ISystemControlPrxHolder iSystemControlPrxHolder = new ISystemControlPrxHolder();
            service.getSystemControl(iSystemControlPrxHolder);
            if (iSystemControlPrxHolder == null) {
                throw new Error("iSystemControlPrxHolder为空");
            }

            ISystemControlPrx value = iSystemControlPrxHolder.value;

            result = value.startProject();

            System.out.println("启动工程----" + "获取结果：" + result + "----返回对象：null");
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
     * 获取系统控制接口——停止工程
     *
     * @param
     * @return
     */

    public static Result stopProject() {
        String[] args = {"ser", "yn"};
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        DeviceInfoListHolder deviceInfoListHolder = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectPrx base = ic.stringToProxy(Const.STRINGIFIED_PROXIES);

            IServicePrx service = IServicePrxHelper.checkedCast(base);
            if (service == null) {
                throw new Error("Invalid proxy");
            }

            ISystemControlPrxHolder iSystemControlPrxHolder = new ISystemControlPrxHolder();
            service.getSystemControl(iSystemControlPrxHolder);
            if (iSystemControlPrxHolder == null) {
                throw new Error("iSystemControlPrxHolder为空");
            }

            ISystemControlPrx value = iSystemControlPrxHolder.value;

            result = value.stopProject();

            System.out.println("停止工程----" + "获取结果：" + result + "----返回对象：null");
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
     * 获取系统控制接口——重启盒子
     *
     * @param
     * @return
     */

    public static Result rebootBox() {
        String[] args = {"ser", "yn"};
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        DeviceInfoListHolder deviceInfoListHolder = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectPrx base = ic.stringToProxy(Const.STRINGIFIED_PROXIES);

            IServicePrx service = IServicePrxHelper.checkedCast(base);
            if (service == null) {
                throw new Error("service为空");
            }

            ISystemControlPrxHolder iSystemControlPrxHolder = new ISystemControlPrxHolder();
            service.getSystemControl(iSystemControlPrxHolder);
            if (iSystemControlPrxHolder == null) {
                throw new Error("iSystemControlPrxHolder为空");
            }

            ISystemControlPrx value = iSystemControlPrxHolder.value;
            result = value.rebootBox();

            System.out.println("重启盒子----" + "获取结果：" + result + "----返回对象：null");
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

    public static Result startDevice(String deviceName) {
        String[] args = {"ser", "yn"};
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        DeviceInfoListHolder deviceInfoListHolder = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectPrx base = ic.stringToProxy(Const.STRINGIFIED_PROXIES);

            IServicePrx service = IServicePrxHelper.checkedCast(base);
            if (service == null) {
                throw new Error("service为空");
            }

            ISystemControlPrxHolder iSystemControlPrxHolder = new ISystemControlPrxHolder();
            service.getSystemControl(iSystemControlPrxHolder);
            if (iSystemControlPrxHolder == null) {
                throw new Error("iSystemControlPrxHolder为空");
            }

            ISystemControlPrx value = iSystemControlPrxHolder.value;
            result = value.startDevice(deviceName);

            System.out.println("启动指定设备----" + "获取结果：" + result + "----返回对象：null");
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


    public static Result stopDevice(String deviceName) {
        String[] args = {"ser", "yn"};
        int status = 0;
        Ice.Communicator ic = null;
        Result result = null;
        DeviceInfoListHolder deviceInfoListHolder = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectPrx base = ic.stringToProxy(Const.STRINGIFIED_PROXIES);

            IServicePrx service = IServicePrxHelper.checkedCast(base);
            if (service == null) {
                throw new Error("service为空");
            }

            ISystemControlPrxHolder iSystemControlPrxHolder = new ISystemControlPrxHolder();
            service.getSystemControl(iSystemControlPrxHolder);
            if (iSystemControlPrxHolder == null) {
                throw new Error("iSystemControlPrxHolder为空");
            }

            ISystemControlPrx value = iSystemControlPrxHolder.value;
            result = value.stopDevice(deviceName);

            System.out.println("停止指定设备----" + "获取结果：" + result + "----返回对象：null");
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


    public static void main(String[] args) {
        DeviceInfoListHolder systemInformation = SystemControllerUtil.getSystemInformation();
        //新建工程
        newProject();
        //保存工程
        saveProject();
        //保存工程到本地
        exportProject();
        //打开本地工程
//        importProject();
        //检查工程
        checkProject();
        //启动工程
        startProject();
        //停止工程
        stopProject();
        //重启盒子
        rebootBox();
    }
}
