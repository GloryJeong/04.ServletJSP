package util;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener, ServletRequestAttributeListener {

    public RequestListener() {
    	System.out.println("������ ��ü ����");
    }

    public void requestDestroyed(ServletRequestEvent sre)  { 
    	System.out.println("������ ��ü ����");
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    }

    public void requestInitialized(ServletRequestEvent sre)  { 
    	System.out.println("������ ��ü �ʱ�ȭ");
    }

    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    }
	
}
