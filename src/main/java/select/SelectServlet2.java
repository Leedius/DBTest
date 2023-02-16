package select;

import java.io.IOException;
import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import dto.MemberDTO;

@WebServlet("/selectAge")
public class SelectServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<MemberDTO> members;
	 
	String page = "";

       
    public SelectServlet2() {
        super();
        members = new ArrayList<>();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int age = Integer.parseInt(request.getParameter("age"));
		
		
		Connection conn = null;

		String sql = "SELECT MEM_NUM, MEM_NAME, MEM_AGE "
				+ "FROM MEMBER "
				+ "WHERE MEM_AGE >= ? "
				;

		// 쿼리를 실행시켜주는 객체
		PreparedStatement pstmt = null;
		
		//조회 결과를 받아오는 객체
		ResultSet rs = null;

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();

			// 쿼리를 실행시킬 객체를 생성
			pstmt = conn.prepareStatement(sql);

			// ?값을 채워줘야 함
			pstmt.setInt(1, age);

			// 쿼리 실행
			// rs객체는 조회된 모든 데이터를 가지고 있다.
			rs = pstmt.executeQuery();
			
			// rs에서 데이터 추출
			// rs.next() : 다음 데이터가 있는지 확인하여 있으면 true, 없으면 false
			while(rs.next()) {
				int memNum = rs.getInt("MEM_NUM");
				String memName = rs.getString("MEM_NAME");
				int memAge = rs.getInt("MEM_AGE");
				
				MemberDTO member = new MemberDTO(memNum, memName, memAge);
				members.add(member);
				System.out.println("번호 - " + memNum + " / 이름 - " + memName + " / 나이 - " + memAge);
				
			}
			
		request.setAttribute("members", members);
			

		} catch (Exception e) {
			System.out.println("디비 오류!!!!!");
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		page = "select_result.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
