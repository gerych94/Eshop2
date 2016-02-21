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
 * Created by Vitaliy on 20.08.2015.
 */

@WebServlet(name = "AddUserServlet" , value = "/AddUser")
public class AddUserServlet extends HttpServlet {
      private IUserService userService;
    private static final String PATH="/pages/user-page.jsp";
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService= (IUserService) config.getServletContext().getAttribute("UserService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String name=req.getParameter("name");
            String login=req.getParameter("login");
            String phone=req.getParameter("phone");
            String email=req.getParameter("email");
            String password=req.getParameter("password");

             userService.register(name,login,phone,email,password);

             Client client=userService.findByLogin(login);
             req.setAttribute("client",client);
              req.getRequestDispatcher(PATH).forward(req,resp);

    }
}
