package controller;

import model.Admin;
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
        if(login==null){
            resp.sendRedirect("pages/error.jsp");
        }else{
            Admin admin=adminService.signIn(login,pass);
            req.setAttribute("admin",admin);
           req.getRequestDispatcher(PATH).forward(req,resp);
        }
    }
}
