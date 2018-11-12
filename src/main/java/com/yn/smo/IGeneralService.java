package com.yn.smo;

import com.yn.common.Result;
import com.yn.entity.General;
import com.yn.entity.GeneralExample;

public interface IGeneralService {
    Result query(GeneralExample example);

    Result save(General recod,GeneralExample example);

    Result add(General recod,GeneralExample example);

    Result del(GeneralExample example);
}
