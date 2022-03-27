package Dao.Impl;


import Dao.BaseDao;
import Dao.ScoreDao;
import empty.Score;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoreDaoImpl extends BaseDao implements ScoreDao {


    @Override
    public ResultSet findScore(Connection conn, String username) throws SQLException {
        String sql="select * from score where username=? order by date desc;";
        ResultSet resultSet = super.selectDate(conn, sql, username);
        return resultSet;
    }

    @Override
    public int addScore(Connection conn, Score score) throws SQLException {
        String sql="insert into score (username,grade,date) values (?,?,?)";
        int i = super.updateDate(conn, sql, score.getUsername(),score.getGrade(),score.getDate());
        return i;
    }
}
