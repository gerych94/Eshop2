package listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IBucketService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Vitaliy on 21.08.2015.
 */
public class MyContextListenerBucket implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:app-context.xml");
        IBucketService bucketService= (IBucketService) applicationContext.getBean("BucketService");
        servletContextEvent.getServletContext().setAttribute("BucketService",bucketService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
