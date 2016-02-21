package controller;

import model.Client;
import service.IUserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Vitaliy on 23.08.2015.
 */

@WebServlet(name = "FindUserByLoginServlet" ,value = "/FindUserLogin")
public class FindUserByLoginServlet extends HttpServlet {

    private IUserService userService;
    private static final String PATH="/pages/user-page.jsp";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService= (IUserService) config.getServletContext().getAttribute("UserService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login= req.getParameter("login");
        Client client=userService.findByLogin(login);

        req.setAttribute("client",client);
        req.getRequestDispatcher(PATH).forward(req,resp);


    }
}
