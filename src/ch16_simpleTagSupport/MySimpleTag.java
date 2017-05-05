package ch16_simpleTagSupport;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;


/**커스텀 액션 태그
 * @author sakba
 *
 */
public class MySimpleTag extends SimpleTagSupport {
	private int size;
	private String color;
	
	
	public void setSize(int size) {
		this.size = size;
	}


	public void setColor(String color) {
		this.color = color;
	}


	@Override
	public void doTag() throws JspException, IOException {
		
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
