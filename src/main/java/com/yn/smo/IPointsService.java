package com.yn.smo;

import com.yn.common.Result;
import com.yn.entity.Points;
import com.yn.entity.PointsExample;

public interface IPointsService {

    Result query(PointsExample example, Points recod);

    Result query(Points recod);

    Result queryDriver(Points recod);

    Result save(Points recod);

    Result add(Points recod);

    Result del(Points recod);
}
