<%@ tag language="java" pageEncoding="utf-8" body-content="empty"%>
<%@ attribute name="color" %>
<%@ attribute name="size" type="java.lang.Integer" %>
<font color="${color}">
	<%
		for(int i=0; i<size; i++){
			out.println("-");			
		}
	%>
</font><br>