package ch18_wrapper;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/WrappingFilter")
public class WrappingFilter implements Filter {

    public WrappingFilter() {
    	
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//��û�� ������ ��û��ü�� ��û ���۰�ü�� ���޽��Ѽ� �� ���� ��ü�� �������� �����Ѵ�.
		String str=request.getParameter("msg");
		System.out.println("[����]�������� :"+str);
		RequestWrapper requestWrapper=new RequestWrapper((HttpServletRequest) request);
		
		//���䰴ü�� ���䷹�� ��ü�� ���μ� �������� ����
		ResponseWrapper responseWrapper=new ResponseWrapper((HttpServletResponse) response);
		
		
		chain.doFilter(requestWrapper, responseWrapper);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
