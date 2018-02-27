package cn.tommyyang.calctool.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by TommyYang on 2017/12/26.
 */
public class MysqlBaseUtils {
    private static Logger logger = LoggerFactory.getLogger(MysqlBaseUtils.class);

    public static Connection getConn(String driverName, String url, String user, String passwd){
        Connection conn = null;
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, user, passwd);
        }catch (Exception e){
            logger.error("get connection error:\n", e);
        }
        return conn;
    }

    public static Statement getStmt(Connection conn){
        Statement stmt = null;
        if(conn == null){
            logger.error("connection is null");
            return stmt;
        }
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            logger.error("get statement error:\n", e);
        }
        return stmt;
    }

    public static void closeConn(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            logger.error("close connection error:\n", e);
        }
    }

    public static void closeStmt(Statement stmt){
        try {
            stmt.close();
        } catch (SQLException e) {
            logger.error("close statement error:\n", e);

        }
    }
}
