package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AuctionItem;
import service.AuctionDatabase;

import java.io.IOException;

/**
 * Servlet implementation class UpdateShowTopic
 */
@WebServlet("/showTopic")
public class UpdateShowTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateShowTopic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String itemIdParam = request.getParameter("itemId");
		Long itemId = Long.parseLong(itemIdParam);
		HttpSession session = request.getSession();
		AuctionItem item = AuctionDatabase.getInstance().getAuctionItem(itemId);
		session.setAttribute("item", item);
		request.getRequestDispatcher("showTopic.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
