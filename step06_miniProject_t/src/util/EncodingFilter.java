package util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/guestbook.do")
public class EncodingFilter implements Filter {
	String env;
    public EncodingFilter() {
    	System.out.println("���� ��ü ����");
    }
    public void init(FilterConfig config) throws ServletException {
    	System.out.println("���� ��ü init");
    	env = config.getInitParameter("charset");
    }
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Before : ���� ����");
		request.setCharacterEncoding(env);
		chain.doFilter(request, response);
		System.out.println("After : ���� ����");
	}
	public void destroy() {
		System.out.println("���� ��ü ����");
	}

}
