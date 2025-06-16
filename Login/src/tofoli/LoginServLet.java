package tofoli;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServLet")
public class LoginServLet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
            String n = request.getParameter("txtName");
            String p = request.getParameter("txtPwd");

            PreparedStatement ps = con.prepareStatement("SELECT email FROM login_page WHERE email=? AND senha=?");
            ps.setString(1, n);
            ps.setString(2, p);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                RequestDispatcher rd = request.getRequestDispatcher("bemvindo.jsp");
                rd.forward(request, response);
            } else {
            	out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset='UTF-8'>");
                out.println("<link rel='stylesheet' type='text/css' href='style.css'>");
                out.println("<link rel='preconnect' href='https://fonts.googleapis.com'>");
                out.println("<link rel='preconnect' href='https://fonts.gstatic.com' crossorigin>");
                out.println("<link href='https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&display=swap' rel='stylesheet'>");
                out.println("<title>Erro de Login</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class='login-container'>");
                out.println("<h1>Login</h1>");
                out.println("<div class='erro-login'>Usuário ou senha incorretos.</div>");
                out.println("<a class='link-voltar' href='login.jsp'>Tente Novamente</a>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }

            rs.close();
            ps.close();
            con.close();
        } catch (ClassNotFoundException | java.sql.SQLException e) {
            e.printStackTrace();
        }

    }
}
