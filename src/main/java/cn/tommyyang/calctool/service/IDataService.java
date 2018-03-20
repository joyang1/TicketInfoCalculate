package cn.tommyyang.calctool.service;

import cn.tommyyang.calctool.model.Data;
import cn.tommyyang.calctool.model.ResultData;

import java.util.List;

/**
 * Created by TommyYang on 2018/2/5.
 */
public interface IDataService {

    Boolean insertOne(Data data);

    List<Data> getAll();

    List<Data> get(Long startTime, Long endTime);

    List<Data> get(Integer qishu);

    Boolean saveResultData(String res, Integer avg, String bit);

    List<ResultData> getData();

}
