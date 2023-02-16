package insert;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/InsertServlet2")
public class InsertServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    public InsertServlet2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// oracle과 자바를 연결시켜줄 수 있는 객체
		Connection conn = null;

		// 실행할 쿼리문 작성(문자열을 받더라도 ''은 안붙임 주의!!)
		String sql = "INSERT INTO MEMBER (MEM_NUM, MEM_NAME, MEM_AGE) VALUES (?, ?, ?)";
		System.out.println("쿼리성공");

		// 쿼리를 실행시켜주는 객체
		PreparedStatement pstmt = null;

		try {
			// 리소스를 검색할 수 있는 객체 생성
			Context init = new InitialContext();

			// context.xml 파일의 디비 접속 정보를 읽어드림.
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");

			// 읽어온 디비정보로부터 자바와 디비를 연결 함.
			conn = ds.getConnection();

			// 쿼리를 실행시킬 객체를 생성
			pstmt = conn.prepareStatement(sql);

			// ?값을 채워줘야 함(x번째수, 넣을정보)
			pstmt.setInt(1, 6);
			pstmt.setString(2, "김자바");
			pstmt.setInt(3, 35);

			// 쿼리 실행
			pstmt.executeUpdate();

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
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
