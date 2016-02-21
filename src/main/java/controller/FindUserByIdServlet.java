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

@WebServlet(name = "FindUserByIdServlet",value = "/FindUserId")
public class FindUserByIdServlet extends HttpServlet {

    private IUserService iUserService;
    private static final String PATH="/pages/user-page.jsp";
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        iUserService= (IUserService) config.getServletContext().getAttribute("UserService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        Client client=iUserService.findById(Integer.parseInt(id));
        req.setAttribute("client",client);
        req.getRequestDispatcher(PATH).forward(req,resp);
    }
}
