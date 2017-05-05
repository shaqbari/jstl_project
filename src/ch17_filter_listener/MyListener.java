package ch17_filter_listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {

    public MyListener() {
    	System.out.println("리스너 객체 생성");
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
    	System.out.println("컨테이너 안에 서블릿이 소멸했다는 이벤트 발생");
    }

    public void contextInitialized(ServletContextEvent arg0)  { 
    	System.out.println("컨테이너 안에 서블릿이 초기화되었다는 이벤트 발생");
    }
	
}
