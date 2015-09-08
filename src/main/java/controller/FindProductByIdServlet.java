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

/**
 * Created by Vitaliy on 23.08.2015.
 */
@WebServlet(name="FindProductByIdServlet",value = "/FindProductID")
public class FindProductByIdServlet extends HttpServlet {

    private IProductService productService;
    private static final String PATH="/pages/product-info.jsp";
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        productService= (IProductService) config.getServletContext().getAttribute("ProductService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        Product product=productService.findOne(Integer.parseInt(id));


        req.setAttribute("product",product);
        req.getRequestDispatcher(PATH).forward(req,resp);

    }
}
