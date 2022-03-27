package empty;

public class Score {
    String username;
    String grade;
    String date;

    public Score() {
    }

    @Override
    public String toString() {
        return "Score{" +
                "username='" + username + '\'' +
                ", grade='" + grade + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public Score(String username, String grade, String date) {
        this.username = username;
        this.grade = grade;
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
