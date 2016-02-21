package controller;

import model.Admin;
import org.apache.log4j.Logger;
import service.AdminService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Vitaliy on 15.08.2015.
 */

@WebServlet(name = "AdminPage", value="/SignInAdmin")
public class MyFirstServlet extends HttpServlet{
    private static final Logger LOGGER=Logger.getLogger(MyFirstServlet.class);
    private AdminService adminService;
    private static final String PATH="/pages/admin-page.jsp";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        adminService=(AdminService)config.getServletContext().getAttribute("AdminService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login=req.getParameter("login");
        String pass=req.getParameter("password");
        int a= (int) req.getSession().getAttribute("parametr");
        String captcha=req.getParameter("captcha");
        LOGGER.info("Admin Input Data:login:"+login+" password:"+pass+" captcha:"+captcha);
        Admin admin=adminService.getAdmin();

        if((!admin.getLogin().equals(login))||(!admin.getPassword().equals(pass))||((2+a)!=Integer.valueOf(captcha))){
            LOGGER.info("Admin Input Wrong Data:login:"+login+" password:"+pass+" captcha:"+captcha);
            resp.sendRedirect("pages/error.jsp");
        }else{
            LOGGER.info("Admin Input Correct Data:login:"+login+" password:"+pass+" captcha:"+captcha);
             admin=adminService.signIn(login,pass);
            req.setAttribute("admin",admin);
            req.getRequestDispatcher(PATH).forward(req,resp);
        }
    }
}
