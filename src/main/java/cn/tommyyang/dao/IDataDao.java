package cn.tommyyang.dao;

import cn.tommyyang.model.Data;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by TommyYang on 2018/2/5.
 */
public interface IDataDao {

    Boolean insertOne(String qihao, String res) throws SQLException;

    List<Data> getAll();

}
