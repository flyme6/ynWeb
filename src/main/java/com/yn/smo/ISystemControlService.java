package com.yn.smo;

import com.yn.common.Result;

public interface ISystemControlService {
    Result newProject();

    Result saveProject();

    Result exportProject();

    Result importProject();

    Result checkProject();

    Result startProject();

    Result stopProject();

    Result rebootBox();


}
