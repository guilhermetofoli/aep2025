package tofoli;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;

/**
 * Servlet implementation class LoginServLet
 */
@WebServlet("/Login/LoginServLet")
public class LoginServLet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
			String n=request.getParameter("txtName");
			String p=request.getParameter("txtPwd");
			
			PreparedStatement ps = con.prepareStatement("SELECT email FROM login_page WHERE email=? AND senha=?");
			ps.setString(1, n);
			ps.setString(2, p);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				RequestDispatcher rd = request.getRequestDispatcher("bemvindo.jsp");
				rd.forward(request, response);
			}
			
			else
			{
				out.println("<font color=red size=18> Login errado<br>");
	            out.println("<a href=login.jsp>Tente Novamente</a>");
			}
			
			rs.close();
	        ps.close();
	        con.close();
			
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
