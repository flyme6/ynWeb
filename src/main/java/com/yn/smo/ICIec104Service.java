package com.yn.smo;

import com.yn.common.Result;
import com.yn.entity.CIec104;
import com.yn.entity.CIec104Example;

public interface ICIec104Service {
    Result query(CIec104Example example);

    Result save(CIec104 recod);

    Result add(CIec104 recod);

    Result del(CIec104 recod);
}
