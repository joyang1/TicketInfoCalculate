package cn.tommyyang.dao.impl;

import cn.tommyyang.dao.BaseDao;
import cn.tommyyang.dao.IDataDao;
import cn.tommyyang.model.Data;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by TommyYang on 2018/2/5.
 */
@Repository("dataDao")
public class DataDaoImpl extends BaseDao implements IDataDao {
    @Override
    public Boolean insertOne(String qihao, String res) throws SQLException {
        String sql = String.format("insert into dat (qihao, kjjg) values (%s, %s)", qihao,res);
        return  this.getStmt().executeUpdate(sql) > 0;
    }

    @Override
    public List<Data> getAll() {
        return null;
    }
}
