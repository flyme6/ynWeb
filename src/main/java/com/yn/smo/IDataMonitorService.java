package com.yn.smo;

import com.yn.common.Result;
import com.yn.entity.Points;

public interface IDataMonitorService {
    Result getDevicesState();

    Result queryRealData(Points points);


    /**
     * 获得通信数据流
     *
     * @return
     */
    Result queryDeviceDataStream(String devName, int dataPos, int itemLimit);
}
