package cn.tommyyang.calctool.dao;

import cn.tommyyang.calctool.model.Data;

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

}
