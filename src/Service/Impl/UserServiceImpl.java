package Service.Impl;

import Dao.Impl.UserDaoImpl;
import empty.User;
import Service.UserService;
import Utils.JDBCUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private UserDaoImpl ud;

    public UserServiceImpl() {
        this.ud = new UserDaoImpl();
    }
    @Override
    public int AddUser(User user) {
        Connection conn = null;
        int i = 0;
        try {
            conn = JDBCUtils.getConnection();
            i = ud.insertUser(conn, user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ud.closeAll();
        }
        return i;
    }
    @Override
    public User UserLogin(User user) {
        Connection conn = null;
        ResultSet res = null;
        try {
            conn = JDBCUtils.getConnection();
            res = ud.Login(conn, user);
            while(res.next()) {
                String username = res.getString("username");
                String password = res.getString("password");
                User user1 = new User(username, password);
                System.out.println(user1);
                return new User(username,password);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ud.closeAll();
        }
        return null;
    }
}

