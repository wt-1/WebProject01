package empty;

public class Question {
    String topic;
    String ans;
    String date;
    String username;

    public Question() {
    }

    @Override
    public String toString() {
        return "Question{" +
                "topic='" + topic + '\'' +
                ", ans='" + ans + '\'' +
                ", date='" + date + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Question(String topic, String ans, String date, String username) {
        this.topic = topic;
        this.ans = ans;
        this.date = date;
        this.username = username;
    }
}
