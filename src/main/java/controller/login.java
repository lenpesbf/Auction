package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import service.AuctionService;

import java.io.IOException;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		 // Lấy thông tin từ form đăng nhập
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Gọi phương thức authenticateUser của AuctionService để xác thực người dùng
        AuctionService auctionService = new AuctionService();
        User user = auctionService.authenticateUser(username, password);
        if (user != null) {
            // Xác thực thành công, đưa đối tượng User vào session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // Chuyển đến trang listItems.jsp
            response.sendRedirect("listItem.jsp");
        } else {
            // Xác thực thất bại, thông báo lỗi và yêu cầu đăng nhập lại
            request.setAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không chính xác.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
	}

}
