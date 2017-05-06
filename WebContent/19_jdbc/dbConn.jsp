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
		System.out.println("������� �ʱ�ȭ :  DB����");
		
		//1.�ܰ� ����̹� �ε�
		try {
			Class.forName(driver);
			System.out.println("�ε强��");
			
			//����
			con=DriverManager.getConnection(url, user, password);
			if (con!=null) {
				System.out.println("���Ӽ���");
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("�ε����");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{				
			
		}
	}
	
	public void jspDestroy(){
		System.out.println("������� �ʱ�ȭ :  DB���� ����");
		try{
			if(con!=null){
				con.close();
				System.out.println("��������");
			}
		}catch(Exception e){			
			System.out.println("�����������");
		}
	}
%>
��񿬰��׽�Ʈ