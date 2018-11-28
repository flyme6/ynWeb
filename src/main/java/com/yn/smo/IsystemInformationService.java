package com.yn.smo;

import com.yn.common.Result;

public interface IsystemInformationService {
    Result getSystemResourcesState();

    Result getAppRunState();

    Result getNetportsState();

    Result getComportsState();
}
