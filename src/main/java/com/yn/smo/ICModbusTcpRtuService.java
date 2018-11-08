package com.yn.smo;

import com.yn.common.Result;
import com.yn.entity.CModbusTcpRtu;
import com.yn.entity.CModbusTcpRtuExample;

public interface ICModbusTcpRtuService {
    Result query(CModbusTcpRtuExample example);

    Result save(CModbusTcpRtu recod);

    Result add(CModbusTcpRtu recod);

    Result del(CModbusTcpRtu recod);
}
