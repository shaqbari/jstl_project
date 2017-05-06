<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
	import="java.sql.*"
	import="ch19_jdbc.DBConnInfo"
%>    
<%!		
	DBConnInfo connInfo=new DBConnInfo();
	String driver=connInfo.getDriver();
	String url= connInfo.getUrl();
	String user = connInfo.getUser();
	String password=connInfo.getPassword();

	Connection con=null;
	
	public void jspInit(){
		System.out.println("멤버변수 초기화 :  DB연결");
		
		//1.단계 드라이버 로드
		try {
			Class.forName(driver);
			System.out.println("로드성공");
			
			//접속
			con=DriverManager.getConnection(url, user, password);
			if (con!=null) {
				System.out.println("접속성공");
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("로드실패");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{				
			
		}
	}
	
	public void jspDestroy(){
		System.out.println("멤버변수 초기화 :  DB연결 종료");
		try{
			if(con!=null){
				con.close();
				System.out.println("연결종료");
			}
		}catch(Exception e){			
			System.out.println("연결종료실패");
		}
	}
%>
디비연결테스트