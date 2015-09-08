package controller;

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
@WebServlet(name = "DeleteUserByIdServlet",value = "/DeleteUser")
public class DeleteUserByIdServlet extends HttpServlet {


    private IUserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService= (IUserService) config.getServletContext().getAttribute("UserService");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");

        userService.remove(Integer.parseInt(id));

    }


}
