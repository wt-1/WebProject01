package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import empty.User;

public interface UserDao {
    /**
     * 注册增加
     * @param conn
     * @param user
     * @return
     * @throws SQLException
     */
    int insertUser(Connection conn, User user)throws SQLException;
    /**
     * 登录
     * @param conn
     * @param user
     * @return
     * @throws SQLException
     */
    ResultSet Login(Connection conn, User user)throws SQLException;

}
