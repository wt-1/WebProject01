package Dao.Impl;

import Dao.BaseDao;
import Dao.UserDao;
import empty.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public int insertUser(Connection conn, User user) throws SQLException {
        String sql = "insert into user (username,password ) value (?,?)";
        return super.updateDate(conn, sql, user.getUsername(), user.getPassword());
    }
    @Override
    public ResultSet Login(Connection conn, User user) throws SQLException {
        String sql = "select * from user where username=? and password=?";
        return super.selectDate(conn, sql, user.getUsername(), user.getPassword());
    }

}
