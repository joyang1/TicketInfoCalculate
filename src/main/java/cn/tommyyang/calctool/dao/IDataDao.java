package cn.tommyyang.calctool.dao;

import cn.tommyyang.calctool.model.Data;
import cn.tommyyang.calctool.model.ResultData;
import cn.tommyyang.calctool.model.WarningData;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by TommyYang on 2018/2/5.
 */
public interface IDataDao {

    Boolean insertOne(String qihao, String res) throws SQLException;

    List<Data> getAll() throws SQLException;

    List<Data> get(Long startTime, Long endTime) throws SQLException;

    List<Data> get(Integer qishu) throws SQLException;

    Boolean saveData(String res, Integer avg, String bit) throws SQLException;

    List<ResultData> getData() throws SQLException;

}
