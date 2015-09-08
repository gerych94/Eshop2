package listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IOrderService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Vitaliy on 21.08.2015.
 */
public class MyContextListenerOrder implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:app-context.xml");
        IOrderService orderService= (IOrderService) applicationContext.getBean("OrderService");
        servletContextEvent.getServletContext().setAttribute("OrderService",orderService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
