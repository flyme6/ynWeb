package com.yn.smo;

import com.yn.common.Result;
import com.yn.entity.Points;

public interface IDataMonitorService {
    Result getDevicesState();

    Result queryRealData(Points points);


}
