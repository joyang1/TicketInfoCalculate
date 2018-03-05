package cn.tommyyang.calctool.service;

import cn.tommyyang.calctool.model.WarningData;

import java.util.List;

/**
 * Created by TommyYang on 2018/3/5.
 */
public interface ICalcService {

    List<WarningData> getWarningDataList();

    void warnData();

}
