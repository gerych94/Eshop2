package controller;

import model.Product;
import service.IProductService;

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
@WebServlet(name = "FindProductByNameServlet",value = "/FindProductName")
public class FindProductByNameServlet extends HttpServlet {

    private IProductService productService;
    private static final String PATH="/pages/Allproduct-info.jsp";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        productService= (IProductService) config.getServletContext().getAttribute("ProductService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");

        List<Product> productList=productService.findProduct(name);
        req.setAttribute("productList",productList);
        req.getRequestDispatcher(PATH).forward(req,resp);
    }
}
