package Dao;

import empty.Question;
import empty.Score;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ScoreDao {
    //获取分数
    public ResultSet findScore(Connection conn, String username)throws SQLException;

    //添加分数到数据库
    public int addScore(Connection conn, Score sorce) throws  SQLException;


}
