package com.yn.smo;

import com.yn.common.Result;

public interface ISystemControlService {
    Result newProject();

    Result saveProject();

    Result exportProject();

    Result importProject(String fileName);

    Result checkProject();

    Result startProject();

    Result stopProject();

    Result rebootBox();

    /**
     * Description: 启动单个设备
     * Input: deviceName设备名称
     * Output:
     * Return:
     * Others: 如工程配置此设备为非激状态，启动将失败。
     **/
    Result startDevice(String deviceName);

    /**
     * Description: 停止单个设备
     * Input: deviceName设备名称
     * Output:
     * Return:
     * Others:
     **/
    Result stopDevice(String deviceName);
}
