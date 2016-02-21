package controller;

import model.Admin;
import model.Client;
import org.apache.log4j.Logger;
import service.AdminService;
import service.IUserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vitaliy on 20.02.16.
 */
@WebServlet(name = "UserPage", value="/SignInUser")
public class SignInUser extends HttpServlet{
    private IUserService iUserService;
    private static final String PATH="/pages/user-page.jsp";
    private static final Logger LOGGER=Logger.getLogger(SignInUser.class);


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        iUserService= (IUserService) config.getServletContext().getAttribute("UserService");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login=req.getParameter("login");
        String pass=req.getParameter("password");
        int a= (int) req.getSession().getAttribute("parametr");
        String captcha=req.getParameter("captcha");
        LOGGER.info("User Input Data:login:"+login+" password:"+pass+" captcha:"+captcha);
        Client client=iUserService.findByLogin(login);

        if((!client.getLogin().equals(login))||(!client.getPassword().equals(pass))||((2+a)!=Integer.valueOf(captcha))){
            LOGGER.info("User Input Wrong Data:login:"+login+" password:"+pass+" captcha:"+captcha);
            resp.sendRedirect("pages/error.jsp");
        }else{
            LOGGER.info("User Input Correct Data:login:"+login+" password:"+pass+" captcha:"+captcha);
            req.setAttribute("client",client);
            req.getRequestDispatcher(PATH).forward(req,resp);
        }
    }
}
