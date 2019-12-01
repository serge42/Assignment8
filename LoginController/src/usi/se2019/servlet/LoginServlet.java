package usi.se2019.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description="Login Servlet",
			urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection con;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        con = null;
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
    	String url = getServletContext().getInitParameter("dbUrl");
//    	String dbUser = getServletContext().getInitParameter("dbUser");
//    	String dbUserPwd = getServletContext().getInitParameter("dbUserPwd");
    	
		try {
			con = DriverManager.getConnection(url);
		} catch (SQLException ex) {
			throw new ServletException("DB connection error " + ex.getMessage());
		}
		
		getServletContext().setAttribute("DB_Success", "true");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		
		assert getServletContext().getAttribute("DB_Success").equals("true"): "NOT CONNECTED TO DB";
//		if(!getServletContext().getAttribute("DB_Success").equals("true")) {
//			this.init();
//		}
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select id,name,pwd_hash from users where name='demo_user'");
			System.out.println("HERE" + rs == null);
			
			if (rs != null && rs.next()) {
				System.out.println("FOUND: " + rs.getString("name") + " ; " + rs.getBlob("pwd_hash") );
			}
		} catch (SQLException e) {
			throw new ServletException("SQL error: " + e.getMessage());
		}
		
		if (user.length() > 0 && pwd.length() > 0) {
			response.sendRedirect("LoginSuccess.jsp");
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Username and password did not match.</font>");
			rd.include(request, response);
		}
	}

}
