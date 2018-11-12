package com.yn.smo;

import com.yn.common.Result;
import com.yn.entity.Com;
import com.yn.entity.ComExample;

public interface IComService {
    Result query(ComExample example);

    Result save(Com recod);

    Result add(Com recod);

    Result del(Com recod);
}
