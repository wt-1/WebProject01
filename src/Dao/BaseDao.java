package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * jdbc操作方法
 * 数据访问层
 */
public class BaseDao {
    public Connection conn;
    public PreparedStatement pre;
    public ResultSet res;

    //增删改方法
    public int updateDate(Connection conn, String sql, Object... obj) throws SQLException, SQLException {
        this.conn = conn;
        pre = conn.prepareStatement(sql);
        //传入参数
        for (int i = 0; i < obj.length; i++) {
            pre.setObject(i + 1, obj[i]);
        }

        return pre.executeUpdate();
    }
    //批量修改数据
    public int[] updateDateMore(Connection conn,String sql,Object[][] objs) throws SQLException {
        this.conn=conn;
        pre=conn.prepareStatement(sql);
        for (int i=0;i<objs.length;i++){
            for (int j=0;j<objs[i].length;j++){
                pre.setObject(j+1,objs[i][j]);
            }
            pre.addBatch();
        }
        return pre.executeBatch();

    }
    //查询方法
    public ResultSet selectDate(Connection conn, String sql, Object... obj) throws SQLException {
        this.conn = conn;
        pre = conn.prepareStatement(sql);
        //传入参数
        for (int i = 0; i < obj.length; i++) {
            pre.setObject(i + 1, obj[i]);
        }
        res = pre.executeQuery();
        return res;
    }

    public void closeAll() {
        if (res != null) {
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pre != null) {
            try {
                pre.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
//        System.out.println("资源关闭成功");
    }
}
