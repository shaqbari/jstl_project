package ch18_wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class RequestWrapper extends HttpServletRequestWrapper {
	HttpServletRequest request;
	
	public RequestWrapper(HttpServletRequest request) {
		super(request);
		
		this.request=request;
	}
	
	@Override
	public String getParameter(String name) {
		//데이터 조작
		//소문자 -> 대문자
		
		String value=request.getParameter(name);
		System.out.println("[레퍼]원데이터 : "+value);
		
		
		return value.toUpperCase();
	}

}
