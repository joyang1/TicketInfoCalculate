package cn.tommyyang.calctool.service.impl;

import cn.tommyyang.calctool.dao.IDataDao;
import cn.tommyyang.calctool.model.Data;
import cn.tommyyang.calctool.service.IDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by TommyYang on 2018/2/5.
 */
@Service
public class DataServiceImpl implements IDataService {


    private final static Logger logger = LoggerFactory.getLogger(DataServiceImpl.class);

    @Autowired
    @Qualifier("dataDao")
    private IDataDao dataDao;

    @Override
    public Boolean insertOne(Data data) {
        try {
            return dataDao.insertOne(data.getQihao().toString(), data.getRes());
        }catch (Exception e){
            logger.error("insert data into table error:\n",e );
        }
        return false;
    }

    @Override
    public List<Data> getAll() {
        try {
            return dataDao.getAll();
        }catch (Exception e){
            logger.error("get all data error:\n",e );
        }
        return null;
    }

    @Override
    public List<Data> get(Long startTime, Long endTime) {
        try {
            return dataDao.get(startTime, endTime);
        }catch (Exception e){
            logger.error("get data by startTime,endTime error:\n",e );
        }
        return null;
    }

    @Override
    public List<Data> get(Integer qishu) {
        try {
            return dataDao.get(qishu);
        }catch (Exception e){
            logger.error("get data by qishu error:\n",e );
        }
        return null;
    }

    @Override
    public Boolean saveData(String res, Integer avg, String bit) {
        try {
            return dataDao.saveData(res, avg, bit);
        } catch (SQLException e) {
            logger.error("save data error:\n",e );
        }
        return false;
    }
}
