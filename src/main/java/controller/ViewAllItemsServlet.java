package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author cyrusbrucker - cbrucker19
 * CIS175 - Spring 2022
 * Feb 17, 2022
 */
/**
 * Servlet implementation class ViewAllItemsServlet
 */
@WebServlet("/ViewAllItemsServlet")
public class ViewAllItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllItemsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListBookHelper dao = new ListBookHelper();
		request.setAttribute("allItems", dao.showAllItems());
		String path = "/coursebook-list.jsp";
		if(dao.showAllItems().isEmpty()) {
			path="/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
