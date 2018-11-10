package com.yn.smo;

import com.yn.common.Result;
import com.yn.entity.FModbusRtu;
import com.yn.entity.FModbusRtuExample;

public interface IFModbusRtuService {
    Result query(FModbusRtuExample example);

    Result save(FModbusRtu recod);

    Result add(FModbusRtu recod);

    Result del(FModbusRtu recod);
}
