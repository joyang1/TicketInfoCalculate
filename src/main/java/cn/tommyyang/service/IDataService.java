package cn.tommyyang.service;

import cn.tommyyang.model.Data;

import java.util.List;

/**
 * Created by TommyYang on 2018/2/5.
 */
public interface IDataService {

    Boolean insertOne(Data data);

    List<Data> getAll();

}
