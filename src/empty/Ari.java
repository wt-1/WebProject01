package empty;

public class Ari {
    String topic;
    String ans;
    String res;
    boolean flag;
    public Ari() {
    }



    public Ari(String topic, String ans) {
        this.topic = topic;
        this.ans = ans;
        this.res = "";
        this.flag=false;
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

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }
    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Ari{" +
                "topic='" + topic + '\'' +
                ", ans='" + ans + '\'' +
                ", res='" + res + '\'' +
                ", flag=" + flag +
                '}';
    }
}
