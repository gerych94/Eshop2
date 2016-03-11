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

@WebServlet(name = "SecretServlet", value = "/SecretServlet")
public class NetCrackerSecretServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter printWriter=resp.getWriter();
        if("admin".equals(req.getSession().getAttribute("user"))){
            printWriter.println("SecretServlet");
        }
    }
}
