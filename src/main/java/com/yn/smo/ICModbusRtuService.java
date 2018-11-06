package com.yn.smo;

import com.yn.common.Result;
import com.yn.entity.CModbusRtu;
import com.yn.entity.CModbusRtuExample;

public interface ICModbusRtuService {
    Result query(CModbusRtuExample cModbusTcp);

    Result save(CModbusRtu recod);

    Result add(CModbusRtu recod);

    Result del(CModbusRtu recod);
}
