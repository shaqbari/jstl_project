<%@ tag language="java" pageEncoding="utf-8" body-content="empty"%>
<%@ tag dynamic-attributes="attrs" %><!-- Map의 이름을 지정 -->
<!-- 위의 속성을사용하면 아래의 color변수가 있다는 전제하에 코드를 작성할 수 있다. -->
<font color="${attrs.color}">
	<%
		java.util.Map attrs=(java.util.Map)jspContext.getAttribute("attrs");
		int size=Integer.parseInt((String)attrs.get("size"));//이코드는 size가 null이거나 숫자가 아닐경우 오류가 날 확률이 높다.
		
		String str=(String)attrs.get("ch");
		if(str==null){
			str="*";
		}
		
		for(int i=0; i<size; i++){
			out.println(str);			
		}
	%>
</font><br>