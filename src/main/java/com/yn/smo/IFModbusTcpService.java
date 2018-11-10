package com.yn.smo;

import com.yn.common.Result;
import com.yn.entity.FModbusTcp;
import com.yn.entity.FModbusTcpExample;

public interface IFModbusTcpService {
    Result query(FModbusTcpExample example);

    Result save(FModbusTcp recod);

    Result add(FModbusTcp recod);

    Result del(FModbusTcp recod);
}
