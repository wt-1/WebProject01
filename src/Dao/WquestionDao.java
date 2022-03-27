package Dao;

import empty.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;

public interface WquestionDao {
    //获取错题
    public ResultSet findQuestion(Connection conn, String username)throws SQLException;

    //添加错题到数据库
    public int addQuestion(Connection conn, Question question) throws  SQLException;

    //重做错题
    public int removeQuestion(Connection conn, Question question) throws SQLException;
}
