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
		//요청이 들어오면 요청객체를 요청 래퍼객체로 전달시켜서 이 래퍼 객체를 서블릿으로 전달한다.
		String str=request.getParameter("msg");
		System.out.println("[필터]원데이터 :"+str);
		RequestWrapper requestWrapper=new RequestWrapper((HttpServletRequest) request);
		
		//응답객체도 응답레퍼 객체로 감싸서 서블릿으로 전송
		ResponseWrapper responseWrapper=new ResponseWrapper((HttpServletResponse) response);
		
		
		chain.doFilter(requestWrapper, responseWrapper);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
