package Servlet;

import Service.Impl.UserServiceImpl;
import Service.Impl.WquestionServiceImpl;
import Service.UserService;
import Service.WquestionService;
import com.alibaba.fastjson.JSON;
import empty.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/questionServlet")
public class WquestionServlet extends HttpServlet {
    WquestionServiceImpl service;

    public WquestionServlet() {
        this.service = new WquestionServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userservice = new UserServiceImpl();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        //1收参
        PrintWriter out = resp.getWriter();
        String method = req.getParameter("method");
        if ("add".equals(method)) {
            HttpSession session = req.getSession();
            String topic = req.getParameter("topic");
            topic = topic.replace(' ', '+');
            String ans = req.getParameter("ans");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d = new Date();
            String date = sdf.format(d);
            String username = (String) session.getAttribute("username");
            Question question = new Question(topic,ans,date,username);
            int i = service.addQuestion(question);
            System.out.println(topic);
            System.out.println("question add :"+(i==1));
        } else if ("find".equals(method)) {
            HttpSession session = req.getSession();
            String username = (String) session.getAttribute("username");
            List<Question> questions = service.findQuestion(username);
            Map<String,Object> map=new HashMap<>();
            map.put("questions",questions);
            String s = JSON.toJSONString(map);
            out.print(s);
        }else if("remove".equals(method)){
            HttpSession session = req.getSession();
            String topic = req.getParameter("topic");
            topic = topic.replace(' ', '+');
            String username = (String) session.getAttribute("username");
            Question question = new Question();
            question.setTopic(topic);
            question.setUsername(username);
            int i = service.removeQuestion(question);
            System.out.println(topic);
            System.out.println("question remove :"+(i==1));
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
