package controller;

import model.Bucket;
import model.Client;
import model.Order;
import model.OrderStatus;
import service.IBucketService;
import service.IOrderService;
import service.IUserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Vitaliy on 21.08.2015.
 */
@WebServlet(name="AddOrderServlet",value="/AddOrder")
public class AddOrderServlet extends HttpServlet {

    private IUserService userService;
    private IBucketService bucketService;
    private IOrderService orderService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService= (IUserService) config.getServletContext().getAttribute("UserService");
        bucketService= (IBucketService) config.getServletContext().getAttribute("BucketService");
        orderService= (IOrderService) config.getServletContext().getAttribute("OrderService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Bucket bucket= (Bucket) req.getSession().getAttribute("bucket");
        String login=req.getParameter("login");
        System.out.println(bucket.toString());
        Client client=userService.findByLogin(login);
        System.out.println(client.toString());
        Order order=new Order(client,bucket,new Date(),bucket.getCost(), OrderStatus.NEW);
        orderService.addOrder(order);


    }

}
