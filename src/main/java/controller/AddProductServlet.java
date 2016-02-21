package controller;

import model.Product;
import model.ProductType;
import service.IProductService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * Created by Vitaliy on 21.08.2015.
 */

@WebServlet(name="AddProductServlet",value = "/AddProduct")
public class AddProductServlet extends HttpServlet {


    private IProductService productService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        productService= (IProductService) config.getServletContext().getAttribute("ProductService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name=req.getParameter("name");
        String productType=req.getParameter("productType");
        String price=req.getParameter("price");
        ProductType productType1=ProductType.valueOf(productType);
        int d=Integer.valueOf(price);
        Product product=new Product(name,productType1,d);
        productService.add(product);
    }

}
