package com.yn.smo;

import com.yn.common.Result;

public interface IDataMonitorService {
    Result getDevicesState();

    Result queryRealData();
}
