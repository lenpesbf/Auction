package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AuctionItem;
import model.User;

import java.io.IOException;

/**
 * Servlet implementation class setPrice
 */
@WebServlet("/setPrice")
public class setPrice extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public setPrice() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // You may want to handle GET request as well
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            // Lấy giá đặt từ form và chuyển sang kiểu double
            double bidPrice = Double.parseDouble(request.getParameter("bidPrice"));

            // Lấy AuctionItem từ request hoặc session (tùy thuộc vào cách bạn lưu trữ)
            AuctionItem auctionItem = (AuctionItem) session.getAttribute("item");
            if (auctionItem == null) {
                auctionItem = (AuctionItem) session.getAttribute("item");
            }

            if (auctionItem == null) {
                response.sendError(400, "Auction item not found");
                return;
            }

            // Lấy giá hiện tại cộng với bước giá
            double minValidBid = auctionItem.getCurrentPrice() + auctionItem.getPriceStep();

            // Lấy thông tin người dùng từ session
            User user = (User) session.getAttribute("user");
            if (user == null) {
                response.sendError(400, "User not logged in");
                return;
            }

            // Kiểm tra giá đặt có hợp lệ không
            if (bidPrice <= 0) {
                response.sendError(400, "Invalid bid price");
                return;
            }

            if (bidPrice >= minValidBid) {
                // Nếu hợp lệ, thực hiện đặt giá
                auctionItem.bid(user, bidPrice);
                response.sendRedirect("listProduct"); // Redirect về danh sách đấu giá
            } else {
                response.sendError(400, "Bid price is too low");
            }

        } catch (NumberFormatException e) {
            // Xử lý nếu người dùng nhập vào giá không hợp lệ
            response.sendError(400, "Invalid input for bid price");
        } catch (Exception e) {
            // Xử lý các lỗi khác
            e.printStackTrace();  // In ra lỗi cho dễ debug
            response.sendError(500, "Internal Server Error");
        }
    }
}
