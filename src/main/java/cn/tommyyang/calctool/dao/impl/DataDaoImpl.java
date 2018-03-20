package cn.tommyyang.calctool.dao.impl;

import cn.tommyyang.calctool.dao.BaseDao;
import cn.tommyyang.calctool.dao.IDataDao;
import cn.tommyyang.calctool.model.Bit;
import cn.tommyyang.calctool.model.Data;
import cn.tommyyang.calctool.model.ResultData;
import cn.tommyyang.calctool.model.WarningData;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public List<Data> getAll()  throws SQLException {
        String sql = "select qihao,kjjg from dat order by qihao desc";
        ResultSet rs = this.getStmt().executeQuery(sql);
        List<Data> dataList = new ArrayList<>();
        while (rs.next()){
            Long qihao = rs.getLong("qihao");
            String kjjg = rs.getString("kjjg");
            dataList.add(new Data(qihao, kjjg));
        }
        return dataList;
    }

    @Override
    public List<Data> get(Long startTime, Long endTime) throws SQLException {
        String sql = String.format("select qihao,kjjg from dat where qihao >= %d and qihao <= %d",
                startTime, endTime);
        ResultSet rs = this.getStmt().executeQuery(sql);
        List<Data> dataList = new ArrayList<>();
        while (rs.next()){
            Long qihao = rs.getLong("qihao");
            String kjjg = rs.getString("kjjg");
            dataList.add(new Data(qihao, kjjg));
        }
        return dataList;
    }

    @Override
    public List<Data> get(Integer qishu) throws SQLException {
        String sql = String.format("select qihao,kjjg from dat order by qihao desc limit %d", qishu);
        ResultSet rs = this.getStmt().executeQuery(sql);
        List<Data> dataList = new ArrayList<>();
        while (rs.next()){
            Long qihao = rs.getLong("qihao");
            String kjjg = rs.getString("kjjg");
            dataList.add(new Data(qihao, kjjg));
        }
        return dataList;
    }

    @Override
    public Boolean saveData(String res, Integer avg, String bit) throws SQLException {
        String sql = String.format("insert into yjdata (res, avg, bit) values ('%s', %d, '%s')", res, avg, bit);
        return  this.getMysqlStmt().executeUpdate(sql) > 0;
    }

    @Override
    public List<ResultData> getData() throws SQLException {
        String sql = "select * from yjdata";
        ResultSet rs = this.getMysqlStmt().executeQuery(sql);
        List<ResultData> resultDataList = new ArrayList<>();
        while (rs.next()){
            String res = rs.getString("res");
            Integer avg = rs.getInt("avg");
            String bit = rs.getString("bit");
            ResultData resultData = new ResultData(res, avg, Bit.get(bit));
            resultDataList.add(resultData);
        }
        return resultDataList;
    }
}
