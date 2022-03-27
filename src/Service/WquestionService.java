package Service;

import empty.Question;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface WquestionService {

    public List<Question> findQuestion(String username);

    public int addQuestion(Question question);
    public int removeQuestion(Question question);


}
