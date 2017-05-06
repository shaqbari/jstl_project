package ch18_wrapper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class ResponseWrapper extends HttpServletResponseWrapper {

	HttpServletResponse response;
	
	public ResponseWrapper(HttpServletResponse response) {
		super(response);
		
		this.response=response;
	}
	
	@Override
	public void addCookie(Cookie cookie) {
		System.out.println("[���䷹��]�������� :"+cookie.getValue());
		
		//�ҹ��ڷ� �����Ͽ� ����
		cookie.setValue(cookie.getValue().toLowerCase());
		response.addCookie(cookie);
	}

}
