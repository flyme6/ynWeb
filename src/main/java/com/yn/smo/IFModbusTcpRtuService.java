package com.yn.smo;

import com.yn.common.Result;
import com.yn.entity.FModbusTcpRtu;
import com.yn.entity.FModbusTcpRtuExample;

public interface IFModbusTcpRtuService {
    Result query(FModbusTcpRtuExample example);

    Result save(FModbusTcpRtu recod);

    Result add(FModbusTcpRtu recod);

    Result del(FModbusTcpRtu recod);
}
