package cn.tommyyang.service.impl;

import cn.tommyyang.dao.IDataDao;
import cn.tommyyang.model.Data;
import cn.tommyyang.service.IDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
            return dataDao.insertOne(data.getQihao().toString(), data.getRes().toString());
        }catch (Exception e){
            logger.error("insert data into table error:\n",e );
        }
        return false;
    }

    @Override
    public List<Data> getAll() {
        return null;
    }
}
