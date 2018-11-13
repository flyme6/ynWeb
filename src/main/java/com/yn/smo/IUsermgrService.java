package com.yn.smo;

import com.yn.common.Result;
import com.yn.entity.Usermgr;
import com.yn.entity.UsermgrExample;

public interface IUsermgrService {
    Result query(UsermgrExample example);

    Result save(Usermgr recod);

    Result add(Usermgr recod);

    Result del(Usermgr recod);
}
