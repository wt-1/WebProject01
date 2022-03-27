package Servlet;

import Service.Impl.AriServiceImpl;
import Service.Impl.UserServiceImpl;
import Service.UserService;
import empty.Ari;
import empty.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;

@WebServlet("/ariServlet")
public class AriServlet extends HttpServlet {
    AriServiceImpl service;

    public AriServlet() {
        service = new AriServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userservice = new UserServiceImpl();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        //1收参
        PrintWriter out = resp.getWriter();
        String method = req.getParameter("method");
        if ("int".equals(method)) {
            List<Ari> ints = service.getint();
//            Question question = new Question("1+1", "2", "2020-2-16 20:6:00", "wang");
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("topics", ints);
            String str = JSON.toJSONString(data);
            out.print(str);
        } else if ("bracket".equals(method)) {
            List<Ari> brackets = service.getbracket();
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("topics", brackets);
            String str = JSON.toJSONString(data);
            out.print(str);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
