package com.yn.smo;

import com.yn.common.Result;
import com.yn.entity.Points;

public interface IRealTimeDataService {
    Result export(Points points, String path);
}
