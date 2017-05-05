package ch16_simpleTagSupport;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyDySimpleTag extends SimpleTagSupport implements DynamicAttributes{
	//悼利 加己 汲沥 何盒
	private Map<String, Object> attrs=new HashMap<String, Object>();
	
	@Override
	public void setDynamicAttribute(String arg0, String arg1, Object arg2) throws JspException {
		attrs.put(arg1, arg2);
	}

	@Override
	public void doTag() throws JspException, IOException {
		String color=(String)attrs.get("color");
		int size=Integer.parseInt((String)attrs.get("size"));
		
		JspContext ctx= getJspContext();
		JspWriter out=ctx.getOut();
		//out.print("------------------------------------<br>");
		out.println("<font color="+color+">");
		for (int i = 0; i < size; i++) {
			out.print("-");
		}		
		out.println("</font>");
		
		return;
		
	}

}
