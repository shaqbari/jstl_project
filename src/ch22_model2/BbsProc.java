package ch22_model2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(description = "�Խù� �����͸� �������� ����", urlPatterns = { "/BbsProc" })
public class BbsProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;   
	
    public BbsProc() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//�Խù��� �о�ͼ� ����(����¡ �ؾ� ������ ��ü �о�ͼ� ����)
    	try {
			Context initCtx=new InitialContext();
			Context envCtx=(Context) initCtx.lookup("java:comp/env");
			DataSource ds=(DataSource) envCtx.lookup("jdbc/java");
			con=ds.getConnection();
			if (con!=null) {
				System.out.println("Ŀ�ؼ� Ǯ�κ��� Ŀ�ؼ� ��ü ȹ��");				
			}
			
			//���̵� ��� �̿��� ���� ����		
			String sql="select * from tbl_board order by bno asc" ;
			
			//������ ����
			pstmt=con.prepareStatement(sql);	
			rs=pstmt.executeQuery();
			
			//model
			Board dto=null;
			ArrayList<Board> boards =new ArrayList<Board>();
			
			while(rs.next()){
				dto=new Board();
				dto.setBno(rs.getInt("bno"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWriter(rs.getString("writer"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setViewcnt(rs.getInt("viewcnt"));
				dto.setReplycnt(rs.getInt("replycnt"));
				
				boards.add(dto);
			}
			
			if(dto==null){
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				
			}else{		
				request.setAttribute("bbs", boards);
				RequestDispatcher rd=request.getRequestDispatcher("22_model2/bbs.jsp");//view�� �ش�.
				//�ߺ��Ǵ� ���ϸ��� ������ �տ� �����̸��� ����� �Ѵ�.
				rd.forward(request, response);
			}
		} catch (NamingException e) {
			e.printStackTrace();
			System.out.println("Ŀ�ؼ� ��ü ȹ�� ����");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//�ݳ�
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null){
				try {
					con.close();
					System.out.println("Ŀ�ؼ� Ǯ���� Ŀ�ؼ� ��ü �ݳ�");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
    	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
