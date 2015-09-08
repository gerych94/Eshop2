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
import java.util.List;

/**
 * Created by Vitaliy on 23.08.2015.
 */
@WebServlet(name = "FindAllUserServlet",value = "/ShowAllUser")
public class FindAllUserServlet extends HttpServlet {

    private IUserService userService;
    private static final String PATH="/pages/show-users.jsp";
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService= (IUserService) config.getServletContext().getAttribute("UserService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
             List<Client> clientList=userService.showAllClients();
             req.setAttribute("clientList",clientList);
             req.getRequestDispatcher(PATH).forward(req,resp);
    }
}
