package ch17_filter_listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {

    public MyListener() {
    	System.out.println("������ ��ü ����");
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
    	System.out.println("�����̳� �ȿ� ������ �Ҹ��ߴٴ� �̺�Ʈ �߻�");
    }

    public void contextInitialized(ServletContextEvent arg0)  { 
    	System.out.println("�����̳� �ȿ� ������ �ʱ�ȭ�Ǿ��ٴ� �̺�Ʈ �߻�");
    }
	
}
