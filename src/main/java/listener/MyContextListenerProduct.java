package listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IProductService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Vitaliy on 21.08.2015.
 */
public class MyContextListenerProduct implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:app-context.xml");
        IProductService iProductService= (IProductService) applicationContext.getBean("ProductService");
        servletContextEvent.getServletContext().setAttribute("ProductService",iProductService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
