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
		//������ ����
		//�ҹ��� -> �빮��
		
		String value=request.getParameter(name);
		System.out.println("[����]�������� : "+value);
		
		
		return value.toUpperCase();
	}

}
