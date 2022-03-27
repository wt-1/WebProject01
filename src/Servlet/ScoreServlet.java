package Servlet;

import Service.Impl.ScoreServiceImpl;
import Service.Impl.UserServiceImpl;
import Service.UserService;
import com.alibaba.fastjson.JSON;
import empty.Score;

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

@WebServlet("/scoreServlet")
public class ScoreServlet extends HttpServlet {
    ScoreServiceImpl service;

    public ScoreServlet(){
        service=new ScoreServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userservice = new UserServiceImpl();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        //1收参
        PrintWriter out = resp.getWriter();
        String method = req.getParameter("method");
        if ("add".equals(method)){
            Score score=new Score();
            HttpSession session = req.getSession();
            String grade = req.getParameter("grade");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d = new Date();
            String date = sdf.format(d);
            String username = (String) session.getAttribute("username");
            score.setDate(date);
            score.setGrade(grade);
            score.setUsername(username);
            int i = service.addScore(score);
            System.out.println("score add :"+(i==1));
        }else if ("find".equals(method)){
            HttpSession session = req.getSession();
            String username = (String) session.getAttribute("username");
            List<Score> score = service.findScore(username);
            Map<String,Object> map=new HashMap<>();
            map.put("sorces",score);
            String s = JSON.toJSONString(map);
            out.print(s);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
