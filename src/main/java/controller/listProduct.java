package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AuctionItem;
import service.AuctionDatabase;
import service.AuctionService;

import java.io.IOException;
import java.util.Collection;

/**
 * Servlet implementation class listProduct
 */
@WebServlet("/listProduct")
public class listProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AuctionService aus;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		Collection<AuctionItem> lst = aus.getAllAuctionItems();
//		
//		request.setAttribute("listItem", lst);
//		
//		Collection<AuctionItem> auctionItems = AuctionDatabase.getInstance().getAllAuctionItems();
//		request.setAttribute("listItem", auctionItems);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
