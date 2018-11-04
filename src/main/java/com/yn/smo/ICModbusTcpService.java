package com.yn.smo;

import com.yn.common.Result;
import com.yn.entity.CModbusTcp;
import com.yn.entity.CModbusTcpExample;

/**
 * @Author ：flyme
 * @ProjectName: ynWeb1.2
 * @Title : ICModbusTcpService
 * @Description：CModbusTcp服务层
 * @Date ：Created in 15:07 2018/10/31
 */

public interface ICModbusTcpService {
    Result queryICModbusTcp(CModbusTcpExample cModbusTcp);

    Result saveICModbusTcp(CModbusTcp cModbusTcp);

    Result delICModbusTcp(CModbusTcp cModbusTcp);
}
