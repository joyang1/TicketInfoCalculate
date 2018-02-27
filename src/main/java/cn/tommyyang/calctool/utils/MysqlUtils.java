package cn.tommyyang.calctool.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;

/**
 * Created by TommyYang on 2017/12/12.
 */
public class MysqlUtils extends MysqlBaseUtils{

    private static Logger logger = LoggerFactory.getLogger(MysqlUtils.class);

    private final static String driverName = PropertiesUtils.getString("datasource.ticketinfo.driverClassName");
    private final static String url = PropertiesUtils.getString("datasource.ticketinfo.url");
    private final static String user = PropertiesUtils.getString("datasource.ticketinfo.username");
    private final static String passwd = PropertiesUtils.getString("datasource.ticketinfo.password");

  public static Connection getConn(){
        return getConn(driverName,url,user,passwd);
  }

}
