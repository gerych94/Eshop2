import dao.*;
import model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.*;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Vitaliy on 21.07.2015.
 */
public class TestEshop2 {


    public static void main(String[] args) {

/*
        Client client=new Client("webr","fwr","fre","sdbd","sdbbb");
        Object object=client;
        Client client1=(Client)object;
        System.out.println(client1.toString());*/




     ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:app-context.xml");
    // IAdminService iAdminService= (IAdminService) applicationContext.getBean("AdminService");
    // System.out.println(iAdminService.signIn("gerych","12345").toString());
        IUserService userService= (IUserService) applicationContext.getBean("UserService");
        Client client=userService.findById(12);
        System.out.println(client.toString());
/*
     IUserService userService=(IUserService)applicationContext.getBean("UserService");
     Client client=userService.findById(16);



     IProductService productService=(IProductService)applicationContext.getBean("ProductService");
     Product product1=productService.findOne(1);
     Product product2=productService.findOne(7);


     IBucketService iBucketService=(IBucketService)applicationContext.getBean("BucketService");

       Bucket bucket=new Bucket(new Date());
          bucket.addProduct(product1);
          bucket.addProduct(product2);


     iBucketService.addBucket(bucket);

     IOrderService iOrderService=(IOrderService)applicationContext.getBean("OrderService");
     Order order=new Order(client,bucket,bucket.getDate(),bucket.getCost(),OrderStatus.NEW);
     iOrderService.addOrder(order);*/

       /* Client client=new Client("Vasiliy","v","093453420","vas@mail","dwqqw12e");
        IUserDao iUserDao=new UserDaoJPA();
        IUserService iUserService=new UserService(iUserDao);
        iUserService.showAllClients();*/
        // Product product=new Product("Accer", ProductType.ELECTRONIC,5500);
        // Product product1=new Product("Citroen",ProductType.CAR,10000);
        /*IProductDao productDao = new ProductDaoJPA();
        IProductService productService = new ProductService(productDao);
        Product product = productService.findOne(1);
        Product product1 = productService.findOne(3);
        Product product2=productService.findOne(7);

        Bucket bucket = new Bucket(new Date());
        bucket.addProduct(product);
        bucket.addProduct(product1);
        bucket.addProduct(product2);

        IBucketDao iBucketDao = new BucketDaoJPA();
        IBucketService iBucketService = new BucketService(iBucketDao);

        iBucketService.addBucket(bucket);
        IUserDao iUserDao = new UserDaoJPA();
        IUserService iUserService = new UserService(iUserDao);

        Client client = iUserService.findById(13);

        Order order = new Order(client, bucket, bucket.getDate(), bucket.getCost(), OrderStatus.NEW);
        IOrderDao iOrderDao = new OrderDaoJPA();
        IOrderService iOrderService = new OrderService(iOrderDao);
     System.out.println(iOrderService.getOrder(2).toString());*/


    }

}
