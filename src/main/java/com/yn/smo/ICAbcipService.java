package com.yn.smo;

import com.yn.common.Result;
import com.yn.entity.CAbcip;
import com.yn.entity.CAbcipExample;

public interface ICAbcipService {
    Result query(CAbcipExample cModbusTcp);

    Result save(CAbcip recod);

    Result add(CAbcip recod);

    Result del(CAbcip recod);
}
