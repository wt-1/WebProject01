package Dao.Impl;

import Dao.BaseDao;
import Dao.WquestionDao;
import empty.Question;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class WquestionDaoImpl extends BaseDao implements WquestionDao {
    @Override
    public ResultSet findQuestion(Connection conn, String username) throws SQLException {
        String sql="select * from question where username=? order by date ";
        ResultSet resultSet = super.selectDate(conn, sql, username);
        return resultSet;
    }

    @Override
    public int addQuestion(Connection conn, Question questions) throws SQLException {
        String sql="insert into question (topic,username,ans,date) values (?,?,?,?)";
        int i = super.updateDate(conn, sql, questions.getTopic(),questions.getUsername(),questions.getAns(),questions.getDate());
        return i;
    }

    @Override
    public int removeQuestion(Connection conn, Question question) throws SQLException {
        String sql="delete from question where username=? and topic=?";
        int i = super.updateDate(conn, sql, question.getUsername(),question.getTopic());
        return i;
    }
}
