package Service.Impl;

import Dao.Impl.WquestionDaoImpl;
import Service.WquestionService;
import Utils.JDBCUtils;
import empty.Question;
import empty.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WquestionServiceImpl implements WquestionService {

    WquestionDaoImpl qdao;

    public WquestionServiceImpl(){
        this.qdao=new WquestionDaoImpl();
    }



    @Override
    public List<Question> findQuestion(String username) {
        Connection conn = null;
        ResultSet res = null;
        List<Question> questions=new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            res = qdao.findQuestion(conn, username);
            while(res.next()) {
                String  question = res.getString("topic");
                String ans = res.getString("ans");
                String date = res.getString("date");
                questions.add(new  Question(question,ans,date,username));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            qdao.closeAll();
        }
        return questions;
    }

    @Override
    public int addQuestion(Question question) {
        Connection conn = null;
        ResultSet res = null;
        try {
            conn = JDBCUtils.getConnection();
            return qdao.addQuestion(conn,question);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            qdao.closeAll();
        }
        return 0;
    }

    @Override
    public int removeQuestion(Question question) {
        Connection conn = null;
        ResultSet res = null;
        try {
            conn = JDBCUtils.getConnection();
            return qdao.removeQuestion(conn,question);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            qdao.closeAll();
        }
        return 0;
    }
}
