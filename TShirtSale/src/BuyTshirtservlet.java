

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class BuyTshirtservlet
 */
@WebServlet("/BuyTshirtservlet")
public class BuyTshirtservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/Java";
	private static final String user = "root";
	private static final String password = "root";
	Connection con;
    /**
     * Default constructor. 
     */
    public BuyTshirtservlet() {
        // TODO Auto-generated constructor stub
    	try{
    		Class.forName(driver);
    		con = DriverManager.getConnection(url, user, password);
    	}
    	catch (Exception e) {
    		e.printStackTrace();
			
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("amisha");
		String tagline = request.getParameter("tagline");
		String color = request.getParameter("color");
		String[] accessories = request.getParameterValues("accessories");
		int pocket = Integer.parseInt(request.getParameter("chestPocket"));
		
		String acc = "";
		for (String x : accessories )
			acc += (x + " ");
		
		try {
			String sql = "insert into tshirt(color, chestPocket, tagline, accessories) values(?,?,?,?)";
			java.sql.PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, color);
			statement.setInt(2, pocket);
			statement.setString(3, tagline);
			statement.setString(4, acc);
			statement.executeUpdate();		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		response.getWriter().append("color : " + color).append("access " + acc);
		response.sendRedirect("show.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
