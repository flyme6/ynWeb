package com.yn.smo.impl;

import YNRPC.Rvqt;
import com.yn.common.Constant;
import com.yn.common.Result;
import com.yn.entity.Points;
import com.yn.mapper.PointsMapper;
import com.yn.smo.IRealTimeDataService;
import com.yn.util.CSVUtils;
import com.yn.util.DateUtil;
import com.yn.util.ynService.DataMonitorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

@Service
public class RealTimeDataServiceImpl implements IRealTimeDataService {


    @Autowired
    private PointsMapper mapper;


    @Override
    public Result export(Points points, String path) {

        Result result = new Result();
        try {
            String[] strings = mapper.selectPoints(points);

            int[] ints = DataMonitorUtil.queryPointIds(strings);

            List<HashMap<String, Object>> maps = new ArrayList<>();
            Rvqt[] rvqts = DataMonitorUtil.queryRealData(ints);
            List exportData = new ArrayList<Map>();
            for (int i = 0; i < rvqts.length; i++) {
                HashMap<String, Object> map = new HashMap<>();
                Map row1 = new LinkedHashMap<String, String>();

                row1.put("name", strings[i]);
                row1.put("id", ints[i]);
                row1.put("q", rvqts[i].q);
                row1.put("r", rvqts[i].r);
                row1.put("t", rvqts[i].t);
                row1.put("v", rvqts[i].v);

                exportData.add(row1);
            }
            LinkedHashMap lie = new LinkedHashMap();
            lie.put("name", "name");
            lie.put("id", "id");
            lie.put("q", "q");
            lie.put("r", "r");
            lie.put("t", "t");
            lie.put("v", "v");

            String time = DateUtil.getSdfTimes();

            String fileName = points.getName() + "-" + points.getcDev() + "-" + points.getfDev() + "-" + time;

            File file = CSVUtils.createCSVFile(exportData, lie, path, fileName);

            System.out.println(file.getName());


            result.addCode(Constant.CODE_QUERY_SUCCESS);
            result.addMsg(file.getName());
            result.addCount(rvqts.length);
            result.addData(maps);

            return result;
        } catch (Exception e) {
            return Result.getQueryFailResult(e);
        }
    }
}