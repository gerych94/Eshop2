package controller;

import model.Bucket;
import model.Product;
import service.IBucketService;
import service.IProductService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Vitaliy on 21.08.2015.
 */
@WebServlet(name = "AddBucketServlet" , value = "/AddBucket")
public class AddBucketServlet extends HttpServlet {

    private IBucketService bucketService;
    private IProductService productService;
    private static final String PATH="/pages/add-order.jsp";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        bucketService = (IBucketService) config.getServletContext().getAttribute("BucketService");
        productService= (IProductService) config.getServletContext().getAttribute("ProductService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String id=req.getParameter("id");
        String[] idArray=id.split(",");

        ArrayList<Product> products=new ArrayList<>();

        for (String s:idArray){
            products.add(productService.findOne(Integer.parseInt(s)));
        }
        Bucket bucket=new Bucket(new Date());

        for (Product p:products){
            bucket.addProduct(p);
        }
        bucketService.addBucket(bucket);
        session.setAttribute("bucket",bucket);

       // req.getSession().setAttribute("bucket",bucket);
        req.getRequestDispatcher(PATH).forward(req,resp);
    }
}
