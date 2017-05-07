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

@WebServlet(description = "게시물 데이터를 가져오는 서블릿", urlPatterns = { "/BbsProc" })
public class BbsProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;   
	
    public BbsProc() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//게시물을 읽어와서 전달(페이징 해야 하지만 전체 읽어와서 전달)
    	try {
			Context initCtx=new InitialContext();
			Context envCtx=(Context) initCtx.lookup("java:comp/env");
			DataSource ds=(DataSource) envCtx.lookup("jdbc/java");
			con=ds.getConnection();
			if (con!=null) {
				System.out.println("커넥션 풀로부터 커넥션 객체 획득");				
			}
			
			//아이디 비번 이용해 쿼리 수행		
			String sql="select * from tbl_board order by bno asc" ;
			
			//쿼리를 수행
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
				RequestDispatcher rd=request.getRequestDispatcher("22_model2/bbs.jsp");//view에 준다.
				//중복되는 파일명이 있으면 앞에 폴더이름을 써줘야 한다.
				rd.forward(request, response);
			}
		} catch (NamingException e) {
			e.printStackTrace();
			System.out.println("커넥션 객체 획득 오류");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//반납
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
					System.out.println("커넥션 풀부터 커넥션 객체 반납");
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
