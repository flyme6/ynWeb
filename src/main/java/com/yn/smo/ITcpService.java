package com.yn.smo;

import com.yn.common.Result;
import com.yn.entity.Tcp;
import com.yn.entity.TcpExample;

public interface ITcpService {
    Result query(TcpExample example);

    Result save(Tcp recod);

    Result add(Tcp recod);

    Result del(Tcp recod);
}
