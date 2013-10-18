package springcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextUtil {

	private static ApplicationContext context = 
    		new ClassPathXmlApplicationContext("DataSourceConnection.xml");
	
	
	ApplicationContext getApplicationContextBean(){
		return context;
	}
	
}
