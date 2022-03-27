package Service;

import empty.Question;
import empty.Score;

import java.util.List;

public interface ScoreService {
    public List<Score> findScore(String username);

    public int addScore(Score score);


}
