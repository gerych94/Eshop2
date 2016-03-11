package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by vitaliy on 03.03.16.
 */
@WebServlet(name = "HelloWorldServlet" ,value="/HelloWorld")
public class NetCrackerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login=req.getParameter("login");
        String password=req.getParameter("password");

        if("admin".equals(login)&&"admin".equals(password)){
            req.getSession().setAttribute("user","admin");
            resp.sendRedirect("/SecretServlet");
        }else {
            req.getSession().invalidate();
        }

        PrintWriter printWriter=resp.getWriter();
        printWriter.println(login);
        printWriter.println(password);
    }
}
