package cn.tommyyang.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by TommyYang on 2018/2/5.
 */
public class AccessUtils {

    private final static Logger logger = LoggerFactory.getLogger(AccessUtils.class);
    public static String URL = "jdbc:ucanaccess://E:\\runtest\\dat.mdb";

    public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//这个驱动的地址不要改
            conn = DriverManager.getConnection(URL,"","");
        }catch (Exception e){
            logger.error("get access conn error:\n", e);
        }
        return conn;
    }

    public static Statement getStmt(Connection connection){
        Statement stmt = null;
        if(connection == null){
            return stmt;
        }
        try {
            stmt = connection.createStatement();
        }catch (Exception e){
            logger.error("get access stmt error:\n", e);
        }
        return stmt;
    }

}
