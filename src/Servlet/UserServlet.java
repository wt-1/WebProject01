package Servlet;

import Service.UserService;
import empty.User;

import Service.Impl.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    UserServiceImpl service;
    public UserServlet(){
        service=new UserServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        //1收参

        String method = req.getParameter("method");
        if("register".equals(method)){
            String username=req.getParameter("username");
            String password=req.getParameter("password");
            User user  = new User(username,password);
            service.AddUser(user);
            resp.sendRedirect(req.getContextPath() + "/login.html");

        }else if("login".equals(method)){
            String username=req.getParameter("username");
            String password=req.getParameter("password");
            PrintWriter out = resp.getWriter();
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            User user1 = service.UserLogin(user);
            HttpSession session = req.getSession();
            System.out.println(user1);
            if(user1!=null){
                session.setAttribute("username", user.getUsername());
                resp.sendRedirect(req.getContextPath() + "/main.html");
            }else {
                out.write("<script>alert('用户名或密码错误！');location.href='login.html';</script>");
            }

        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}