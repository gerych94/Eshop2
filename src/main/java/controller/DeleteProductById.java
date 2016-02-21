package controller;



import dao.IProductDao;
import service.IProductService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Vitaliy on 24.08.2015.
 */

@WebServlet(name = "DeleteProductById",value = "/DeleteProductId")
public class DeleteProductById extends HttpServlet {

    private IProductService productService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        productService= (IProductService) config.getServletContext().getAttribute("ProductService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        productService.buy(Integer.parseInt(id));
    }
}
