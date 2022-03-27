package Service.Impl;

import Dao.Impl.ScoreDaoImpl;
import Dao.Impl.WquestionDaoImpl;
import Service.ScoreService;
import Utils.JDBCUtils;
import empty.Question;
import empty.Score;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScoreServiceImpl implements ScoreService {

    ScoreDaoImpl sdao;

    public ScoreServiceImpl(){
        this.sdao=new ScoreDaoImpl();
    }

    @Override
    public List<Score> findScore(String username) {
        Connection conn = null;
        ResultSet res = null;
        List<Score> scores=new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            res = sdao.findScore(conn, username);
            while(res.next()) {
                String  grade = res.getString("grade");
                String date = res.getString("date");
                scores.add(new Score(username,grade,date));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            sdao.closeAll();
        }
        return scores;
    }

    @Override
    public int addScore(Score score) {
        Connection conn = null;
        ResultSet res = null;
        try {
            conn = JDBCUtils.getConnection();
            sdao.addScore(conn,score);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            sdao.closeAll();
        }
        return 1;
    }
}
