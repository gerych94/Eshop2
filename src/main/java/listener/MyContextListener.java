package listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IAdminService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Vitaliy on 18.08.2015.
 */
public class MyContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:app-context.xml");
        IAdminService iAdminService= (IAdminService) applicationContext.getBean("AdminService");
        servletContextEvent.getServletContext().setAttribute("AdminService",iAdminService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
