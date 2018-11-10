package com.yn.smo;

import com.yn.common.Result;
import com.yn.entity.FIec104;
import com.yn.entity.FIec104Example;

public interface IFIec104Service {
    Result query(FIec104Example example);

    Result save(FIec104 recod);

    Result add(FIec104 recod);

    Result del(FIec104 recod);
}
