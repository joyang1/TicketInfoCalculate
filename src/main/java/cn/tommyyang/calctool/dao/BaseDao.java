package cn.tommyyang.calctool.dao;

import cn.tommyyang.calctool.utils.AccessUtils;
import cn.tommyyang.calctool.utils.MysqlUtils;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by TommyYang on 2018/2/5.
 */
public class BaseDao {

    private Connection conn;
    private Statement stmt;

    private Connection mysqlConn;
    private Statement mysqlStmt;

    private Connection getConn(){
        return AccessUtils.getConn();
    }

    private Connection getMysqlConn(){
        return MysqlUtils.getConn();
    }

    protected Statement getStmt(){
        conn = this.getConn();
        stmt = AccessUtils.getStmt(conn);
        return stmt;
    }

    protected Statement getMysqlStmt(){
        mysqlConn = this.getMysqlConn();
        stmt = MysqlUtils.getStmt(mysqlConn);
        return stmt;
    }

}
